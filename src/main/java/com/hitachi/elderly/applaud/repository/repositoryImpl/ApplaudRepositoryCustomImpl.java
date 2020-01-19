package com.hitachi.elderly.applaud.repository.repositoryImpl;

import com.hitachi.elderly.applaud.entity.ApplaudEntity;
import com.hitachi.elderly.applaud.model.ApplaudModel;
import com.hitachi.elderly.applaud.repository.ApplaudRepositoryCustom;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ApplaudRepositoryCustomImpl implements ApplaudRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ApplaudModel> findByCommentCodeAndOpenId(String commentCode, String openId) {
        entityManager.clear();
        StringBuffer sql = new StringBuffer();
        sql.append(" select code,id from applaud_entity where ");
        sql.append(" comment_code = '" + commentCode +  "' ");
        sql.append(" and open_id = '" + openId + "' ");
        Query query_list = entityManager.createNativeQuery(sql.toString());
        List<ApplaudModel> list = query_list.unwrap(NativeQueryImpl.class).setResultTransformer(Transformers.aliasToBean(ApplaudModel.class)).getResultList();
        return list;
    }

    public Integer deleteByCode(String code) {
        entityManager.clear();
        StringBuffer sql = new StringBuffer();
        sql.append(" DELETE from applaud_entity where code = '" + code +"' ");
        Query query = entityManager.createNativeQuery(sql.toString());
        return query.executeUpdate();
    }
}
