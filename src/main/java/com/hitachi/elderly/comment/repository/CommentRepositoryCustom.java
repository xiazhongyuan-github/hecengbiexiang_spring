package com.hitachi.elderly.comment.repository;

import com.hitachi.elderly.comment.model.CommentsRequestModel;
import com.hitachi.elderly.comment.model.GetgommentsModel;

import java.util.List;

/**
 * @ProjectName: hecengbiexiang_spring
 * @Package: com.hitachi.elderly.repository
 * @ClassName: CommentRepositoryCustom
 * @Author: 72763
 * @Description: ${description}
 * @Date: 2020/1/12 16:19
 * @Version: 1.0
 */
public interface CommentRepositoryCustom {
    List<GetgommentsModel> getCommentsByArticleId(CommentsRequestModel commentsRequestModel);
    //根据评论记录code，查询其被点赞量
    Integer findApplaudCount(String code);
    //根据用户的openid及评论记录code，查询用户是否点赞过此条记录
    Boolean findIsApplaud(String commentCode, String openId);
}
