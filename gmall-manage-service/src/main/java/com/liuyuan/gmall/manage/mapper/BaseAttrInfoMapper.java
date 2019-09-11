package com.liuyuan.gmall.manage.mapper;

import com.liuyuan.gmall.bean.BaseAttrInfo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BaseAttrInfoMapper extends Mapper<BaseAttrInfo> {
    //做到通用，spu信息里面需要属性名合数性质列表，在对应的baseAttrInfoMapper里面查的时候做了关联查询
    //根据三级分类查询出下面对应的属性和属性值列表
    public List<BaseAttrInfo> getBaseAttrInfoListByCatalog3Id(String catalog3Id);
}
