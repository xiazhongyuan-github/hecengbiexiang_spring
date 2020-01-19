package com.hitachi.elderly.comment.repository.repositoryImpl;

import com.hitachi.elderly.comment.model.CommentsRequestModel;
import com.hitachi.elderly.comment.model.GetgommentsModel;
import com.hitachi.elderly.comment.repository.CommentRepositoryCustom;
import com.hitachi.elderly.constant.CommonCode;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigInteger;
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
    //根据评论记录code，查询其被点赞量
    @Override
    public Integer findApplaudCount(String code){
        entityManager.clear();
        StringBuffer sql = new StringBuffer();
        sql.append(" select count(1) from applaud_entity where");
        sql.append(" comment_code = '" + code +  "' ");
        Query query = entityManager.createNativeQuery(sql.toString());
        List<BigInteger> countList = query.getResultList();
        BigInteger counts = countList.get(0);
        return counts.intValue();
    }

    @Override
    public Boolean findIsApplaud(String commentCode,String openId){
        entityManager.clear();
        StringBuffer sql = new StringBuffer();
        sql.append(" select count(1) from applaud_entity where ");
        sql.append(" comment_code = '" + commentCode +  "' ");
        sql.append(" and open_id = '" + openId + "' ");
        Query query = entityManager.createNativeQuery(sql.toString());
        List<BigInteger> countList = query.getResultList();
        Integer counts = countList.get(0).intValue();
        return counts > 0? true:false;
    }
}
