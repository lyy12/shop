package com.liuyuan.gmall.service;


import com.liuyuan.gmall.bean.UserAddress;
import com.liuyuan.gmall.bean.UserInfo;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.List;

public interface UserService {

    List<UserInfo> getUserInfoListAll();

    void addUser(UserInfo userInfo);

    void updateUser(UserInfo userInfo);

    void updateUserByName(String name, UserInfo userInfo);

    void delUser(UserInfo userInfo);

    UserInfo getUserInfoById(String id);


    /**
     * 查询所有数据
     * @return
     */
    List<UserInfo> findAll();

    /**
     * 根据userId 查询用户地址列表
     * @param userId
     * @return
     */
    List<UserAddress> getUserAddressList(String userId);

    /**
     * 登录方法
     * @param userInfo
     * @return
     */
    UserInfo login(UserInfo userInfo);

    /**
     * 根据用户Id 查询数据
     * @param userId
     * @return
     */
    Boolean verify(String userId);


}
