package com.liuyuan.gmall.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class SkuAttrValue implements Serializable {
    //主键，在这个表中只是做计数用，也可以不要这个主键，让attrId和valueId作为联合主键，不过一般都不这样用
    @Id
    @Column
    String id;
    //平台属性属性id
    @Column
    String attrId;
    //平台属性值id
    @Column
    String valueId;
    //隶属于某个sku
    @Column
    String skuId;
}
