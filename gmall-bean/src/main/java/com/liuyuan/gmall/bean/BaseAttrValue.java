package com.liuyuan.gmall.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
//平台属性值表
@Data
@NoArgsConstructor
public class BaseAttrValue implements Serializable {
    @Id
    @Column
    private String id;
    @Column
    private String valueName;

    //这个平台属性值所属，属于那个平台属性
    @Column
    private String attrId;
}