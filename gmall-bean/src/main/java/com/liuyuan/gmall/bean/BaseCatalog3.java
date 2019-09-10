package com.liuyuan.gmall.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

@NoArgsConstructor
@Data
public class BaseCatalog3 implements Serializable {
    @Id
    @Column
    private String id;
    @Column
    private String name;
    //一个二级分类下面对应有多个三级分类，在三级分类，也就是多的一方，添加一个少的一方的主键作为外键。
    @Column
    private String catalog2Id;
}