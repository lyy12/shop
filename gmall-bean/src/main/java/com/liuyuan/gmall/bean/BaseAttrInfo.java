package com.liuyuan.gmall.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
//平台属性信息表
@Data
@NoArgsConstructor
public class BaseAttrInfo implements Serializable {
    //这个是基本属性信息表，也就是对应的平台属性
    //里面有平台属性的一些信息，包括属性id，属性的名字，以及这个属性所属的三级分类
    //属性值
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @Column
    private String attrName;
    //这个平台属性是绑定在某个三级分类上的，比如说：一级手机，二级手机通讯，三级手机，手机下面有
    /**
     * 价格：这个是属性
     * 0-499 500-999 1000-1699 1700-2799 2800-4499 4500-11999 12000以上  属性值，属性和属性值是1：n的关系
     * -
     * 确定
     * 屏幕尺寸：
     * 6.95英寸及以上 6.65-6.74英寸 6.45-6.54英寸 6.35-6.44英寸 6.25-6.34英寸 6.0～6.24英寸 5.5～5.99英寸 5.0～5.49英寸 5.0英寸以下 多选
     * 运行内存：
     * 12GB 10GB 8GB 6GB 4GB 3GB 2GB 2GB以下 其它内存 更多 多选
     * 热点：
     * 高倍率变焦 曲面屏 无线充电 快速充电 防水防尘 超高屏占比 屏幕指纹 弹出式摄像头 NFC 液冷散热 人脸识别
     *
     * 三级分类和平台属性也是一个1：n的关系
     */
    @Column
    private  String catalog3Id;
    //这个Transient注解意思是这个属性不会和数据库的字段做对应的
    @Transient
    private List<BaseAttrValue> attrValueList;

}

