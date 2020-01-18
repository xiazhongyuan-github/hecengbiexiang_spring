package com.hitachi.elderly.bean;

import com.hitachi.elderly.constant.ResultStatusCode;

/**
 * @Desciption :
 * @Author : wyl
 * @CreateDate : 2018-10-24:13:43
 */
public class Result {
    private int code;

    private Object data;


    public Result(ResultStatusCode resultStatusCode, Object data) {
        this.code = resultStatusCode.getRetCode();
        this.data = data;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int Code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
