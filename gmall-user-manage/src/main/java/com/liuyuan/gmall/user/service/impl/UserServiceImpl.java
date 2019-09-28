package com.liuyuan.gmall.user.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.liuyuan.gmall.bean.UserAddress;
import com.liuyuan.gmall.bean.UserInfo;
import com.liuyuan.gmall.service.UserService;
import com.liuyuan.gmall.user.mapper.UserAddressMapper;
import com.liuyuan.gmall.user.mapper.UserInfoMapper;
import com.liuyuan.gmall.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private UserAddressMapper userAddressMapper;

    @Autowired
    private RedisUtil redisUtil;

    public String userKey_prefix="user:";
    public String userinfoKey_suffix=":info";
    public int userKey_timeOut=60*60*24;



    @Override
    public List<UserInfo> getUserInfoListAll() {
        List<UserInfo> userInfoList = userInfoMapper.selectAll();

        return userInfoList;
    }

    @Override
    public void addUser(UserInfo userInfo) {
        userInfoMapper.insertSelective(userInfo);
    }

    @Override
    public void updateUser(UserInfo userInfo) {
        userInfoMapper.updateByPrimaryKeySelective(userInfo);
    }

    @Override
    public void updateUserByName(String name, UserInfo userInfo) {

        Example example = new Example(UserInfo.class);
        example.createCriteria().andEqualTo("name",name);
        //通过条件进行更新的方法
        userInfoMapper.updateByExampleSelective(userInfo,example);

    }

    @Override
    public void delUser(UserInfo userInfo) {
        userInfoMapper.deleteByPrimaryKey(userInfo.getId());
    }

    @Override
    public UserInfo getUserInfoById(String id) {
        return userInfoMapper.selectByPrimaryKey(id);
    }






    @Override
    public List<UserInfo> findAll() {
        return userInfoMapper.selectAll();
    }

    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        // 调用mapper
        // select * from userAddress where userId=?
        UserAddress userAddress = new UserAddress();
        userAddress.setUserId(userId);
        return    userAddressMapper.select(userAddress);
    }

    @Override
    public UserInfo login(UserInfo userInfo) {
        // select * from userInfo where loginName = ? and passwd=?
        /*
            1.  根据当前的sql 语句 查询是否有当前用户
            2.  将用户信息存储到缓存中！
         */
        // 202cb962ac59075b964b07152d234b70 密码需要进行加密
        String passwd = userInfo.getPasswd();
        // 对密码进行加密
        String newPwd = DigestUtils.md5DigestAsHex(passwd.getBytes());
        // 将加密后的密码赋值给当前对象
        userInfo.setPasswd(newPwd);

        UserInfo info = userInfoMapper.selectOne(userInfo);

        if (info!=null){
            // 获取Jedis
            Jedis jedis = redisUtil.getJedis();
            // 放入redis ,必须起key=user:userId:info
            String userKey = userKey_prefix+info.getId()+userinfoKey_suffix;

            // 哪种数据类型
            jedis.setex(userKey,userKey_timeOut, JSON.toJSONString(info));
            // 关闭jedis
            jedis.close();
            return info;
        }
        return null;
    }

    @Override
    public Boolean verify(String userId) {
        Jedis jedis = redisUtil.getJedis();
        String userKey=userKey_prefix+userId+userinfoKey_suffix;
        Boolean isLogin = jedis.exists(userKey);
        if(isLogin){  //如果经过验证，延长用户使用时间
            jedis.expire(userKey,userKey_timeOut);
        }

        jedis.close();

        return isLogin;
    }
}
