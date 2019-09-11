package com.liuyuan.gmall.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
public class SkuInfo implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column
    String id;

    @Column
    String spuId;

    @Column
    BigDecimal price;

    @Column
    String skuName;

    @Column
    BigDecimal weight;

    @Column
    String skuDesc;
    //sku和spu中都有这个字段，sku里面这个字段主要是为了检索来用，冗余字段，而spu中的三级分类字段主要是业务关联用的
    @Column
    String catalog3Id;

    @Column
    String skuDefaultImg;
    //sku图片列表
    @Transient
    List<SkuImage> skuImageList;
    //sku属性值列表
    @Transient
    List<SkuAttrValue> skuAttrValueList;
    //sku属性值列表
    @Transient
    List<SkuSaleAttrValue> skuSaleAttrValueList;
}

