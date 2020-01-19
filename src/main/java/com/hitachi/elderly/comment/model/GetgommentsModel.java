package com.hitachi.elderly.comment.model;
// 获取评论返回的封装model
/**
 * @Author xiazhongyuan
 * @Version  1.0
 * @Date
 */
public class GetgommentsModel {
    private String name;//昵称
    private String headPortrait;//头像
    private String commentContent;//回复内容
    private String createAt;//回复时间
    private String code;//code
    private Boolean is_applaud;//是否点赞此条记录
    private Integer count;//此记录的被点赞量


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getIs_applaud() {
        return is_applaud;
    }

    public void setIs_applaud(Boolean is_applaud) {
        this.is_applaud = is_applaud;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
