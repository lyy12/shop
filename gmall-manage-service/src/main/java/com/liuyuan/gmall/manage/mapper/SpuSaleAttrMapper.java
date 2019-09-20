package com.liuyuan.gmall.manage.mapper;

import com.liuyuan.gmall.bean.SpuSaleAttr;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/*
public interface SpuSaleAttrMapper extends Mapper<SpuSaleAttr> {

    //根据spuid查询销售属性
    public List<SpuSaleAttr> getSpuSaleAttrListBySpuId(String spuId);

    public List<SpuSaleAttr> getSpuSaleAttrListBySpuIdCheckSku(@Param("skuId") String skuId,@Param("spuId")  String spuId);
}
*/

public interface SpuSaleAttrMapper extends Mapper<SpuSaleAttr> {
    /**
     * 根据spuId 查询销售属性集合
     * 需要使用SpuSaleAttrMapper.xml 写在resources 目录下
     * @param spuId
     * @return
     */
    List<SpuSaleAttr> selectSpuSaleAttrList(String spuId);

    /**
     *
     * @param skuId
     * @param spuId
     * @return
     */
    List<SpuSaleAttr> selectSpuSaleAttrListCheckBySku(String skuId, String spuId);
}
