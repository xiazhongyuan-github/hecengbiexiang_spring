package com.hitachi.elderly.applaud.repository;

import com.hitachi.elderly.applaud.model.ApplaudModel;

import java.util.List;

public interface ApplaudRepositoryCustom {
    List<ApplaudModel> findByCommentCodeAndOpenId(String commnetCode, String openId);
    //取消点赞
    Integer deleteByCode(String code);
}
