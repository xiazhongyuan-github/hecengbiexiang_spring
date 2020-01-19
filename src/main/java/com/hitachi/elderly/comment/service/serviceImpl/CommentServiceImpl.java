package com.hitachi.elderly.comment.service.serviceImpl;
import com.google.gson.Gson;
import com.hitachi.elderly.comment.entity.CommentsEntity;
import com.hitachi.elderly.comment.model.CommentsRequestModel;
import com.hitachi.elderly.comment.model.GetgommentsModel;
import com.hitachi.elderly.comment.repository.CommentRepository;
import com.hitachi.elderly.comment.repository.CommentRepositoryCustom;
import com.hitachi.elderly.comment.service.CommentService;
import com.hitachi.elderly.config.HttpRequest;
import com.hitachi.elderly.constant.CommonCode;
import com.hitachi.elderly.exception.BizException;
import com.hitachi.elderly.model.WeiXinOpenIdModel;
import com.hitachi.elderly.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author ：xzy
 * @date ：Created in 2020/1/9 18:18
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
@Service
public class CommentServiceImpl implements CommentService {
    protected static Logger logger = LoggerFactory.getLogger(CommentServiceImpl.class);
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private CommentRepositoryCustom commentRepositoryCustom;
    @Override
    public void comment(CommentsRequestModel commentsRequestModel) {
        try {

            CommentsEntity commentsEntity = new CommentsEntity();
            commentsEntity.setCreated_at(new Date());
            commentsEntity.setCreated_by(commentsRequestModel.getOpenId());
            commentsEntity.setCode(Utils.getCode(CommonCode.COMMENT_CODE));
            commentsEntity.setComments_content(commentsRequestModel.getCommentContent());
            commentsEntity.setWx_id(commentsRequestModel.getOpenId());
            commentsEntity.setHead_portrait(commentsRequestModel.getHeadPortrait());
            commentsEntity.setName(commentsRequestModel.getName());
            commentsEntity.setArticle_id(commentsRequestModel.getArticleId());
            CommentsEntity entity = commentRepository.save(commentsEntity);
        } catch (BizException biz) {
            logger.info(biz.getMessage());
            throw new BizException(biz.getResultStatusCode(), biz.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public List<GetgommentsModel> getCommentsByArticleId(CommentsRequestModel commentsRequestModel) {
        List<GetgommentsModel> list = null;
        try {
            list = commentRepositoryCustom.getCommentsByArticleId(commentsRequestModel);
            for (int i = 0; i < list.size(); i++) {
                //查询每条记录的被点赞数
                Integer count = commentRepositoryCustom.findApplaudCount(list.get(i).getCode());
                list.get(i).setCount(count);
                //根据用户的openid及评论记录code，查询用户是否点赞过此条记录
                Boolean isApplaud = commentRepositoryCustom.findIsApplaud(list.get(i).getCode(), commentsRequestModel.getOpenId());
                list.get(i).setIs_applaud(isApplaud);
            }
        } catch (BizException biz) {
            logger.info(biz.getMessage());
            throw new BizException(biz.getResultStatusCode(), biz.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return list;
    }

    @Override
    public String getOpenId(CommentsRequestModel commentsRequestModel) {
        String openid = null;
        try {
            // 根据用户的session_key获取openID
            String params = String.format(CommonCode.CODE2SESSION,commentsRequestModel.getSession_key());
            String res = HttpRequest.sendPost(CommonCode.GET_VXID_URL, params);
            Gson gson = new Gson();
            WeiXinOpenIdModel wx = (WeiXinOpenIdModel) gson.fromJson(res, WeiXinOpenIdModel.class);
            openid = wx.getOpenid();
        } catch (BizException biz) {
            logger.info(biz.getMessage());
            throw new BizException(biz.getResultStatusCode(), biz.getMessage());
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return openid;
    }
}
