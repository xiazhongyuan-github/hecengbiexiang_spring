package com.hitachi.elderly.comment.service;

import com.hitachi.elderly.comment.model.CommentsRequestModel;
import com.hitachi.elderly.comment.model.GetgommentsModel;

import java.util.List;

/**
 * @author ：xzy
 * @date ：Created in 2020/1/9 12:30
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
public interface CommentService {
    //保存评论
    void comment(CommentsRequestModel commentsRequestModel);
    //根据文章id查询此文章下的评论
    List<GetgommentsModel> getCommentsByArticleId(CommentsRequestModel commentsRequestModel);
    //获取openid
    String getOpenId(CommentsRequestModel commentsRequestModel);

    //删除指定code的记录
    void deleteByCode(String code,String openId);

}
