package com.liuyuan.gmall.service;

import com.liuyuan.gmall.bean.*;

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

    //根据三级分类获取所有的spu列表，在存spuInfo的时候，就要指定spuInfo隶属于某个三级分类
    public List<SpuInfo> getSpuList(String catalog3Id);

    //获得基本销售属性
    public List<BaseSaleAttr> getBaseSaleAttrList();

    //保存spu信息
    public void saveSpuInfo(SpuInfo spuInfo);

    //根据spuid查询图片列表
    public List<SpuImage> getSpuImageList(String spuId);

    //根据spuid查询销售属性
    public List<SpuSaleAttr> getSpuSaleAttrList(String spuId);
}
