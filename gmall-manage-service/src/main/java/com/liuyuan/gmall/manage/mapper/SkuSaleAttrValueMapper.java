package com.liuyuan.gmall.manage.mapper;

import com.liuyuan.gmall.bean.SkuSaleAttrValue;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/*public interface SkuSaleAttrValueMapper extends Mapper<SkuSaleAttrValue> {
    public List<Map> getSaleAttrValuesBySpu(String spuId);
}*/

public interface SkuSaleAttrValueMapper extends Mapper<SkuSaleAttrValue>{
    //  根据spuId 查询数据
    List<SkuSaleAttrValue> selectSkuSaleAttrValueListBySpu(String spuId);
}
