package com.liuyuan.gmall.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

@NoArgsConstructor
@Data
public class SkuImage implements Serializable {
    //主键
    @Id
    @Column
    String id;
    //这张图片隶属于某个sku商品
    @Column
    String skuId;
    //图片名
    @Column
    String imgName;
    //图片存放地址
    @Column
    String imgUrl;
    //所属于某个spu图片表，因为是在spu中添加图片，然后添加sku时，选择spu中的图片作为该sku的图片
    @Column
    String spuImgId;
    //这个值是是否为默认图片
    @Column
    String isDefault;
}

