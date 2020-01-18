package com.hitachi.elderly.controller;

import com.hitachi.elderly.bean.ResultMsg;
import com.hitachi.elderly.constant.ResultStatusCode;
import com.hitachi.elderly.exception.BizException;
import com.hitachi.elderly.model.CommentsRequestModel;
import com.hitachi.elderly.model.GetgommentsModel;
import com.hitachi.elderly.service.CommentService;
import com.hitachi.elderly.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.dc.pr.PRError;

import java.util.List;

/**
 * @author ：xzy
 * @date ：Created in 2020/1/9 12:24
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
@RestController
@RequestMapping("/commentController")
public class CommentController {
    protected static Logger logger = LoggerFactory.getLogger(CommentController.class);
    @Autowired
    private CommentService commentService;

    //保存评论
    @RequestMapping("/saveComment")
    public ResultMsg comment(@RequestBody CommentsRequestModel model) {
        try {
            commentService.comment(model);
            return ResultUtils.Success("保存成功");
        } catch(BizException biz){
            logger.info(biz.getMessage());
            return ResultUtils.Error(biz.getResultStatusCode(),biz.getMessage());
        } catch(Exception e){
            logger.error(e.getMessage(),e);
            return ResultUtils.Error(ResultStatusCode.SYSTEM_ERR_30001, ResultStatusCode.SYSTEM_ERR_30001.getRetMsg());
        }
    }

    //根据文章id查询此文章下的评论
        @RequestMapping("/getCommentsByArticleId")
    public ResultMsg getCommentsByArticleId(@RequestBody CommentsRequestModel model) {
        try {
            List<GetgommentsModel> list = commentService.getCommentsByArticleId(model);
            return ResultUtils.Success(list);
        } catch(BizException biz){
            logger.info(biz.getMessage());
            return ResultUtils.Error(biz.getResultStatusCode(),biz.getMessage());
        } catch(Exception e){
            logger.error(e.getMessage(),e);
            return ResultUtils.Error(ResultStatusCode.SYSTEM_ERR_30001, ResultStatusCode.SYSTEM_ERR_30001.getRetMsg());
        }
    }

    //保存评论
    @RequestMapping("/getOpenId")
    public ResultMsg getOpenId(@RequestBody CommentsRequestModel model) {
        try {
            String openid = commentService.getOpenId(model);
            return ResultUtils.Success(openid);
        } catch(BizException biz){
            logger.info(biz.getMessage());
            return ResultUtils.Error(biz.getResultStatusCode(),biz.getMessage());
        } catch(Exception e){
            logger.error(e.getMessage(),e);
            return ResultUtils.Error(ResultStatusCode.SYSTEM_ERR_30001, ResultStatusCode.SYSTEM_ERR_30001.getRetMsg());
        }
    }
}
