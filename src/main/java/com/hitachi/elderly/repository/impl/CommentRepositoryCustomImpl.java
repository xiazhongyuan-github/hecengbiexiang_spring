package com.hitachi.elderly.repository.impl;

import com.hitachi.elderly.model.CommentsRequestModel;
import com.hitachi.elderly.model.GetgommentsModel;
import com.hitachi.elderly.repository.CommentRepositoryCustom;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * @Author xiazhongyuan
 * @Version  1.0
 * @Date:2020/01/12
 */
@Repository
public class CommentRepositoryCustomImpl implements CommentRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<GetgommentsModel> getCommentsByArticleId(CommentsRequestModel commentsRequestModel) {
        entityManager.clear();
        StringBuffer sql = new StringBuffer();
        sql.append(" select name,head_portrait as headPortrait,comments_content as commentContent,code from comments_entity where article_id = '"+commentsRequestModel.getArticleId()+"' order by created_at desc");
        Query query_list = entityManager.createNativeQuery(sql.toString());
        List<GetgommentsModel> list = query_list.unwrap(NativeQueryImpl.class).setResultTransformer(Transformers.aliasToBean(GetgommentsModel.class)).getResultList();
        return list;
    }
}
