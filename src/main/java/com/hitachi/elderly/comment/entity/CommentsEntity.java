package com.hitachi.elderly.comment.entity;

import com.hitachi.elderly.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author ：xzy
 * @date ：Created in 2020/1/8 12:28
 * @description：${description}
 * @modified By： 评论表
 * @version: $version$
 */
@Entity
@Table(name="comments_entity")
public class CommentsEntity extends BaseEntity{
    private static final long serialVersionUID = 1L;
    @Column(unique = true, columnDefinition = "varchar(50) COMMENT '评论记录code'")
    private String code;
    @Column(columnDefinition = "varchar(50) COMMENT '评论人名称'")
    private String name;
    @Column(columnDefinition = "varchar(50) COMMENT '评论人id'")
    private String wx_id;
    @Column(columnDefinition = "text COMMENT '评论人头像'")
    private String head_portrait;
    @Column(columnDefinition = "text COMMENT '评论内容'")
    private String comments_content;
    @Column(columnDefinition = "varchar(50) COMMENT '文章唯一id'")
    private String article_id;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComments_content() {
        return comments_content;
    }

    public void setComments_content(String comments_content) {
        this.comments_content = comments_content;
    }

    public String getWx_id() {
        return wx_id;
    }

    public void setWx_id(String wx_id) {
        this.wx_id = wx_id;
    }

    public String getArticle_id() {
        return article_id;
    }

    public void setArticle_id(String article_id) {
        this.article_id = article_id;
    }

    public String getHead_portrait() {
        return head_portrait;
    }

    public void setHead_portrait(String head_portrait) {
        this.head_portrait = head_portrait;
    }
}
