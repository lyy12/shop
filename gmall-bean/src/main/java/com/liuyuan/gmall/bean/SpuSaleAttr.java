package com.liuyuan.gmall.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Data
public class SpuSaleAttr  implements Serializable {

    @Id
    @Column
    String id ;

    //隶属于某个spu，spu下面有下有销售属性1：n，销售属性下面有销售属性值1：n
    @Column
    String spuId;

    @Column
    String saleAttrId;

    @Column
    String saleAttrName;


    @Transient
    List<SpuSaleAttrValue> spuSaleAttrValueList;
}