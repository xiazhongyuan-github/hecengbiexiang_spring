package com.hitachi.elderly.repository;

import com.hitachi.elderly.model.CommentsRequestModel;
import com.hitachi.elderly.model.GetgommentsModel;

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
}
