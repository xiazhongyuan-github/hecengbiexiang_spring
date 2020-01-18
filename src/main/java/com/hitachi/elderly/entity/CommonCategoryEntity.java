package com.hitachi.elderly.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
* @ClassName: CommonCategoryEntity
* @Description: 公共类别信息实体类
* @Author: zyhao
* @Date: 2018/9/11
*/
@Entity
@Table(name="common_category")
public class CommonCategoryEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(nullable = false,columnDefinition = "varchar(15) COMMENT '公共实体类code' ")
    private String code;
    @Column(nullable = false,columnDefinition = "Integer(3) COMMENT '公共实体类值' ")
    private Integer value;
    @Column(nullable = false,columnDefinition = "varchar(20) COMMENT '公共实体类名称' ")
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

