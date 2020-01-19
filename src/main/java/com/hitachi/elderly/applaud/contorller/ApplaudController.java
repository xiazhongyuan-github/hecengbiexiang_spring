package com.hitachi.elderly.applaud.contorller;


import com.hitachi.elderly.applaud.model.ApplaudRequestModel;
import com.hitachi.elderly.applaud.service.ApplaudService;
import com.hitachi.elderly.bean.ResultMsg;
import com.hitachi.elderly.constant.ResultStatusCode;
import com.hitachi.elderly.exception.BizException;
import com.hitachi.elderly.utils.ResultUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：xzy
 * @date ：Created in 2020/1/19 11:50
 * @description：${description}
 * @modified By：点赞Controller
 * @version: $version$
 */
@RestController
@RequestMapping("/applaudController")
public class ApplaudController {
    protected static org.slf4j.Logger logger = LoggerFactory.getLogger(ApplaudController.class);
    @Autowired
    private ApplaudService applaudService;

    //点赞
    @RequestMapping("/applaud")
    public ResultMsg applaud(@RequestBody ApplaudRequestModel requestModel) {
        try {
            applaudService.applaud(requestModel);
            return ResultUtils.Success("保存成功");
        } catch(BizException biz){
            logger.info(biz.getMessage());
            return ResultUtils.Error(biz.getResultStatusCode(),biz.getMessage());
        } catch(Exception e){
            logger.error(e.getMessage(),e);
            return ResultUtils.Error(ResultStatusCode.SYSTEM_ERR_30001, ResultStatusCode.SYSTEM_ERR_30001.getRetMsg());
        }
    }
    //取消点赞
    @RequestMapping("/cancelApplaud")
    public ResultMsg cancelApplaud(@RequestBody ApplaudRequestModel requestModel) {
        try {
            applaudService.cancelApplaud(requestModel);
            return ResultUtils.Success("取消成功");
        } catch(BizException biz){
            logger.info(biz.getMessage());
            return ResultUtils.Error(biz.getResultStatusCode(),biz.getMessage());
        } catch(Exception e){
            logger.error(e.getMessage(),e);
            return ResultUtils.Error(ResultStatusCode.SYSTEM_ERR_30001, ResultStatusCode.SYSTEM_ERR_30001.getRetMsg());
        }
    }

}
