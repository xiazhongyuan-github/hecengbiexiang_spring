package com.hitachi.elderly.utils;

import com.hitachi.elderly.bean.ResultMsg;
import com.hitachi.elderly.constant.ResultStatusCode;

/**
 * @ClassName: ResultUtils
 * @Description: 返回类型包装类
 * @Author: lizhe
 * @Date: 2018/9/5
 */
public class ResultUtils {
    //当正确时返回的值
    public static ResultMsg Success(Object data){
        ResultMsg result = new ResultMsg(ResultStatusCode.OK_0, data);
        return result;
    }

    //当正确时返回的值
    public static ResultMsg Success(String msg, Object data){
        ResultMsg result = new ResultMsg(ResultStatusCode.OK_0.getRetCode(),msg, data);
        return result;
    }

    public static ResultMsg Success(){
        return Success(null);
    }

    //当错误时返回的值
    public static ResultMsg Error(ResultStatusCode resultStatusCode){
        ResultMsg result = new ResultMsg(resultStatusCode, null);
        return result;
    }

    public static ResultMsg Error(ResultStatusCode resultStatusCode, String retMsg){
        ResultMsg result = new ResultMsg(resultStatusCode, retMsg);
        return result;
    }

    //当错误时返回的值
    public static ResultMsg Error(Object data){
        ResultMsg result = new ResultMsg(ResultStatusCode.BUSINESS_ERR_20001, data);
        return result;
    }
}