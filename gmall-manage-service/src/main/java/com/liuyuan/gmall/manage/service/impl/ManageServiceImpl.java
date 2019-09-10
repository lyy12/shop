package com.liuyuan.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.liuyuan.gmall.bean.*;
import com.liuyuan.gmall.manage.mapper.*;
import com.liuyuan.gmall.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class ManageServiceImpl implements ManageService {

    @Autowired
    BaseCatalog1Mapper baseCatalog1Mapper;

    @Autowired
    BaseCatalog2Mapper baseCatalog2Mapper;

    @Autowired
    BaseCatalog3Mapper baseCatalog3Mapper;

    @Autowired
    BaseAttrInfoMapper baseAttrInfoMapper;

    @Autowired
    BaseAttrValueMapper baseAttrValueMapper;

    //查询所有的一级分类列表
    @Override
    public List<BaseCatalog1> getCatalog1List() {
        return baseCatalog1Mapper.selectAll();
    }

    @Override
    public List<BaseCatalog2> getCatalog2List(String catalog1Id) {
        BaseCatalog2 baseCatalog2 = new BaseCatalog2();
        baseCatalog2.setCatalog1Id(catalog1Id);
        //查的时候需要用的是二级分类的对象
        //二级分类的对象里面放一级分类的id，就可以根据一级分类id查二级分类列表了
        return baseCatalog2Mapper.select(baseCatalog2);
    }

    @Override
    public List<BaseCatalog3> getCatalog3List(String catalog2Id) {
        BaseCatalog3 baseCatalog3 = new BaseCatalog3();
        baseCatalog3.setCatalog2Id(catalog2Id);
        //查的时候需要用的是三级分类的对象
        //三级分类的对象里面放二级分类的id，就可以根据二级分类id查三级分类列表了
        return baseCatalog3Mapper.select(baseCatalog3);

    }

    @Override
    public List<BaseAttrInfo> getBaseAttrInfoList(String catalog3Id) {
        //写法一
       /*BaseAttrInfo baseAttrInfo = new BaseAttrInfo();
        baseAttrInfo.setCatalog3Id(catalog3Id);
        return baseAttrInfoMapper.select(baseAttrInfo);*/
       //写法二
        Example example = new Example(BaseAttrInfo.class);
        example.createCriteria().andEqualTo("catalog3Id",catalog3Id);
        List<BaseAttrInfo> baseAttrInfoList = baseAttrInfoMapper.selectByExample(example);
        //查的时候需要用的是平台属性信息的对象
        //平台属性信息的对象里面放三级分类的id，就可以根据三级分类id查平台属性信息了
        return baseAttrInfoList;
    }

    @Override
    public void saveAttrInfo(BaseAttrInfo baseAttrInfo) {
        if(baseAttrInfo.getId()!=null && baseAttrInfo.getId().length()>0 ){
            baseAttrInfoMapper.updateByPrimaryKeySelective(baseAttrInfo);
        }else{
            //baseAttrInfo.setId(null);
            baseAttrInfoMapper.insertSelective(baseAttrInfo);
        }
        Example example = new Example(BaseAttrValue.class);
        //根据平台属性id查询所有的对应的平台属性值，这个平台属性id在属性值表里面存的都有
        example.createCriteria().andEqualTo("attrId",baseAttrInfo.getId());
        //根据attrid先全部删除，再统一保存
        baseAttrValueMapper.deleteByExample(example);
        //在从前端页面提交的时候就已经封装好了，这个时候直接取就行了
        List<BaseAttrValue> baseAttrValueList = baseAttrInfo.getAttrValueList();
        for (BaseAttrValue baseAttrValue : baseAttrValueList) {
            String id = baseAttrInfo.getId();//获取属性值的id赋给属性值表的属性id字段
            baseAttrValue.setAttrId(id);
            baseAttrValueMapper.insertSelective(baseAttrValue);

        }
    }

    /**
     *获取平台属性信息，进而能获取到平台属性值列表
     * @param attrId 平台属性id
     * @return
     */
    @Override
    public BaseAttrInfo getBaseAttrInfo(String attrId) {
        //根据平台属性id查询出平台属性，平台属性里有平台属性值，三级分类等信息
        BaseAttrInfo baseAttrInfo = baseAttrInfoMapper.selectByPrimaryKey(attrId);
        //封装查询条件，查询条件里为平台属性值表的平台属性值，这个代表这个属性值隶属于某个属性上
        BaseAttrValue baseAttrValue = new BaseAttrValue();
        baseAttrValue.setAttrId(attrId);
        //通过平台属性获取到平台属性值列表
        List<BaseAttrValue> baseAttrValueList = baseAttrValueMapper.select(baseAttrValue);
        //查出来的结果封装进这个对象，将该对象返回
        baseAttrInfo.setAttrValueList(baseAttrValueList);
        return baseAttrInfo;
    }
}
