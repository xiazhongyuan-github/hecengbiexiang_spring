package com.hitachi.elderly.applaud.service;

import com.hitachi.elderly.applaud.model.ApplaudRequestModel;

/**
 * @author ：xzy
 * @date ：Created in 2020/1/19 11:58
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
public interface ApplaudService {
    //添加点赞记录
    void applaud(ApplaudRequestModel requestModel);
    //取消点赞
    void cancelApplaud(ApplaudRequestModel requestModel);
}
