package com.hitachi.elderly.applaud.service.serviceImpl;

import com.hitachi.elderly.applaud.entity.ApplaudEntity;
import com.hitachi.elderly.applaud.model.ApplaudModel;
import com.hitachi.elderly.applaud.model.ApplaudRequestModel;
import com.hitachi.elderly.applaud.repository.ApplaudRepository;
import com.hitachi.elderly.applaud.repository.ApplaudRepositoryCustom;
import com.hitachi.elderly.applaud.service.ApplaudService;
import com.hitachi.elderly.comment.repository.repositoryImpl.CommentRepositoryCustomImpl;
import com.hitachi.elderly.constant.CommonCode;
import com.hitachi.elderly.exception.BizException;
import com.hitachi.elderly.utils.Utils;
import com.sun.org.apache.regexp.internal.RE;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author ：xzy
 * @date ：Created in 2020/1/19 11:59
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
@Service
public class ApplaudServiceImpl implements ApplaudService {
    protected static org.slf4j.Logger logger = LoggerFactory.getLogger(ApplaudServiceImpl.class);
    @Autowired
    private ApplaudRepository applaudRepository;
    @Autowired
    private ApplaudRepositoryCustom applaudRepositoryCustom;

    @Override
    public void applaud(ApplaudRequestModel requestModel) {
        try {
            ApplaudEntity entity = new ApplaudEntity();
            entity.setCode(Utils.getCode(CommonCode.APPLAUD_CODE));
            entity.setOpen_id(requestModel.getOpenId());
            entity.setComment_code(requestModel.getCommentCode());
            entity.setCreated_at(new Date());
            entity.setCreated_by(requestModel.getOpenId());
            ApplaudEntity save = applaudRepository.save(entity);
        } catch (BizException biz) {
            logger.info(biz.getMessage());
            throw new BizException(biz.getResultStatusCode(), biz.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    /**
     *@Description :取消点赞
     *@Author :zhongyuan
     *@Date : 13:56 2020/1/19
     **/
    public void cancelApplaud(ApplaudRequestModel requestModel) {
        try {
            List<ApplaudModel> list = applaudRepositoryCustom.findByCommentCodeAndOpenId(requestModel.getCommentCode(), requestModel.getOpenId());
            if (list.size() > 0) {
                applaudRepository.deleteByCode(list.get(0).getCode());
            }
        } catch (BizException biz) {
            logger.info(biz.getMessage());
            throw new BizException(biz.getResultStatusCode(), biz.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
}
