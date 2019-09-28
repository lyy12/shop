package com.liuyuan.gmall.service;

import com.liuyuan.gmall.bean.*;

import java.util.List;

/*
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
    //保存sku信息
    public void saveSkuInfo(SkuInfo skuInfo);
}
*/


public interface ManageService {

    /**
     * 获取所有的一级分类数据
     * @return
     */
    List<BaseCatalog1> getCatalog1();

    /**
     * 根据一级分类Id 查询二级分类数据
     * select * from baseCatalog2 where catalog1Id =?
     * @param catalog1Id
     * @return
     */
    List<BaseCatalog2> getCatalog2(String catalog1Id);

    /**
     * 根据二级分类Id 查询三级分类数据
     * @param catalog2Id
     * @return
     */
    List<BaseCatalog3> getCatalog3(String catalog2Id);

    /**
     * 根据三级分类Id 查询平台属性集合
     * @param catalog3Id
     * @return
     */
    List<BaseAttrInfo> getAttrList(String catalog3Id);

    /**
     * 保存平台属性数据
     * @param baseAttrInfo
     */
    void saveAttrInfo(BaseAttrInfo baseAttrInfo);

    /**
     * 根据平台属性Id 查询平台属性值集合
     * @param attrId
     * @return
     */
    List<BaseAttrValue> getAttrValueList(String attrId);

    /**
     * 根据平台属性Id 查询平台属性对象
     * @param attrId
     * @return
     */
    BaseAttrInfo getAttrInfo(String attrId);

    List<SpuInfo> getSpuList(String catalog3Id);

    /**
     * 根据spuInfo 对象属性获取spuInfo 集合
     * @param spuInfo
     * @return
     */
    List<SpuInfo> getSpuList(SpuInfo spuInfo);

    /**
     * 获取所有的销售属性数据
     * @return
     */
    List<BaseSaleAttr> getBaseSaleAttrList();

    /**
     * 保存spuInfo
     * @param spuInfo
     */
    void saveSpuInfo(SpuInfo spuInfo);

    /**
     *
     * @param spuImage
     * @return
     */
    List<SpuImage> getSpuImageList(SpuImage spuImage);

    /**
     * 根据spuId 获取销售属性集合
     * @param spuId
     * @return
     */
    List<SpuSaleAttr> getSpuSaleAttrList(String spuId);

    /**
     * 保存skuInfo 数据
     * @param skuInfo
     */
    void saveSkuInfo(SkuInfo skuInfo);

    /**
     * 根据skuId 查询skuInfo
     * @param skuId
     * @return
     */
    SkuInfo getSkuInfo(String skuId);

    /**
     * 根据skuId 查询skuImage集合
     * @param skuId
     * @return
     */
    List<SkuImage> getSkuImageBySkuId(String skuId);

    /**
     * 根据skuId,spuId 查询销售属性集合
     * @param skuInfo
     * @return
     */
    List<SpuSaleAttr> getSpuSaleAttrListCheckBySku(SkuInfo skuInfo);

    /**
     *  根据spuId 查询销售属性值集合
     * @param spuId
     * @return
     */
    List<SkuSaleAttrValue> getSkuSaleAttrValueListBySpu(String spuId);

    /**
     * 根据平台属性值id查询
     * @param attrValueIdList
     * @return
     */
    List<BaseAttrInfo> getAttrList(List<String> attrValueIdList);
}
