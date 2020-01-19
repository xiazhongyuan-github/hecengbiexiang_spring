package com.hitachi.elderly.applaud.model;

/**
 * @author ：xzy
 * @date ：Created in 2020/1/19 11:54
 * @description：${description}
 * @modified By：applaud请求参数封装model
 * @version: $version$
 */
public class ApplaudRequestModel {
    private String openId;
    private String commentCode;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getCommentCode() {
        return commentCode;
    }

    public void setCommentCode(String commentCode) {
        this.commentCode = commentCode;
    }
}
