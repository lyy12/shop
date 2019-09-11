package com.liuyuan.gmall.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class SkuSaleAttrValue implements Serializable {
    //spu的销售属性和spu的销售属性值分开了，这个表放在一起了
    @Id
    //sku属性隶属于某个sku
    @Column
    String id;
    //销售属性值属性隶属于某个sku
    @Column
    String skuId;
    //销售属性id
    @Column
    String saleAttrId;
    //销售属性值id
    @Column
    String saleAttrValueId;
    //销售属性名
    @Column
    String saleAttrName;
    //销售属性值名
    @Column
    String saleAttrValueName;
}
