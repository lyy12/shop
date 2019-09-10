package com.liuyuan.gmall.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class BaseCatalog2 implements Serializable {
    @Id
    @Column
    private String id;
    @Column
    private String name;
    //一个一级分类下面对应有多个二级分类，在二级分类，也就是多的一方，添加一个少的一方的主键作为外键。
    @Column
    private String catalog1Id;
}