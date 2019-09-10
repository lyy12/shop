package com.liuyuan.gmall.service;

import com.liuyuan.gmall.bean.BaseAttrInfo;
import com.liuyuan.gmall.bean.BaseCatalog1;
import com.liuyuan.gmall.bean.BaseCatalog2;
import com.liuyuan.gmall.bean.BaseCatalog3;

import java.util.List;

public interface ManageService {
    //查询一级分类
    public List<BaseCatalog1> getCatalog1List();
    //查询二级分类 根据一级分类ID
    public List<BaseCatalog2> getCatalog2List(String catalog1Id);
    //查询三级分类 根据二级分类ID
    public List<BaseCatalog3> getCatalog3List(String catalog2Id);
    //查询平台属性列表 根据三级分类ID
    public List<BaseAttrInfo> getBaseAttrInfoList(String catalog3Id);
    //保存平台属性信息，保存的信息有，平台属性名称，平台属性值列表，catalog3Id
    public void saveAttrInfo(BaseAttrInfo baseAttrInfo);
    //根据平台属性id获取平台属性信息，顺便能取得到该属性id下的属性值列表
    public BaseAttrInfo getBaseAttrInfo(String attrId);
}
