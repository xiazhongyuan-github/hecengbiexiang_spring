package com.hitachi.elderly.bean;

import com.hitachi.elderly.constant.ResultStatusCode;

/**
* @ClassName: ResultMsg
* @Description: http返回结果类
* @Author: lizhe
* @Date: 2018/9/4
*/
public class ResultMsg {
    private int retCode;
    private String retMsg;
    private Object retData;
    
    public ResultMsg(int retCode, String retMsg, Object retData) {
        this.retCode = retCode;
        this.retMsg = retMsg;
        this.retData = retData;
    }

    public ResultMsg(int retCode, String retMsg) {
        this.retCode = retCode;
        this.retMsg = retMsg;
    }

    public ResultMsg(ResultStatusCode resultStatusCode, Object retData) {
        this.retCode = resultStatusCode.getRetCode();
        this.retMsg = resultStatusCode.getRetMsg();
        this.retData = retData;
    }

    public ResultMsg(ResultStatusCode resultStatusCode, String retMsg) {
        this.retCode = resultStatusCode.getRetCode();
        this.retMsg = retMsg;
        this.retData = null;
    }

    public int getRetCode() {
        return retCode;
    }

    public void setRetCode(int retCode) {
        this.retCode = retCode;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }

    public Object getRetData() {
        return retData;
    }

    public void setRetData(Object retData) {
        this.retData = retData;
    }

}
