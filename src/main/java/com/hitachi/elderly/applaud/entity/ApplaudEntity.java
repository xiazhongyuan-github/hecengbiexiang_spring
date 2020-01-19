package com.hitachi.elderly.applaud.entity;

import com.hitachi.elderly.constant.CommonCode;
import com.hitachi.elderly.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author ：xzy
 * @date ：Created in 2020/1/19 10:40
 * @description：${description}
 * @modified By：点赞记录表
 * @version: $version$
 */
@Entity
@Table(name="applaud_entity")
public class ApplaudEntity extends BaseEntity{
    private static final long serialVersionUID = 1L;

    @Column(nullable = false,columnDefinition = "varchar(30) COMMENT '点赞记录code' ")
    private String code;
    @Column(nullable = false,columnDefinition = "varchar(30) COMMENT '评论记录表中的code' ")
    private String comment_code;
    @Column(nullable = false,columnDefinition = "varchar(32) COMMENT '点赞人的openid' ")
    private String open_id;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getComment_code() {
        return comment_code;
    }

    public void setComment_code(String comment_code) {
        this.comment_code = comment_code;
    }

    public String getOpen_id() {
        return open_id;
    }

    public void setOpen_id(String open_id) {
        this.open_id = open_id;
    }
}
