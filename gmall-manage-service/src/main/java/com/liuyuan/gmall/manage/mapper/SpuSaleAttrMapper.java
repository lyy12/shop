package com.liuyuan.gmall.manage.mapper;

import com.liuyuan.gmall.bean.SpuSaleAttr;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SpuSaleAttrMapper extends Mapper<SpuSaleAttr> {

    //根据spuid查询销售属性
    public List<SpuSaleAttr> getSpuSaleAttrListBySpuId(String spuId);
}
