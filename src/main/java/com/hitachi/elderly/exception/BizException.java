package com.hitachi.elderly.exception;

import com.hitachi.elderly.constant.ResultStatusCode;

/**
 * @program: elderly
 * @description: 自定义异常
 * @author: ykzhou
 * @create: 2018-09-20 17:01
 **/
public class BizException extends RuntimeException {

    private ResultStatusCode resultStatusCode;

    public BizException(){}

    public BizException(String message){
        super(message);
    }

    public BizException( ResultStatusCode resultStatusCode,String message){
        super(message);
        this.resultStatusCode = resultStatusCode;
    }

    public ResultStatusCode getResultStatusCode() {
        return resultStatusCode;
    }

    public void setResultStatusCode(ResultStatusCode resultStatusCode) {
        this.resultStatusCode = resultStatusCode;
    }
}
