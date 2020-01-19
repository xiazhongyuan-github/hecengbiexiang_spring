package com.hitachi.elderly.comment.model;

/**
 * @author ：xzy
 * @date ：Created in 2020/1/9 12:20
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
public class CommentsRequestModel {
    private String name;//昵称
    private String headPortrait;//头像
    private String commentContent;//回复内容
    private String session_key;//换取openid的key
    private String articleId;//公众号文章id
    private String openId;//用户的openid

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

    public String getSession_key() {
        return session_key;
    }

    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }
}
