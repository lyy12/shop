package com.liuyuan.gmall.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class SpuSaleAttrValue implements Serializable {

    @Id
    @Column
    String id ;

    @Column
    String spuId;
    //隶属于某个销售属性
    @Column
    String saleAttrId;

    @Column
    String saleAttrValueName;
    //这个属性是标记sku的属性值是否被选中，某个sku的销售属性值不一样，做个标记用的
    @Transient
    String isChecked;
}

