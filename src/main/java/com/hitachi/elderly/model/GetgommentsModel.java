package com.hitachi.elderly.model;
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
}
