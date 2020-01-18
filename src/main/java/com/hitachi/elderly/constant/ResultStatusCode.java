package com.hitachi.elderly.constant;

public enum ResultStatusCode {
    OK_0(0, "OK_0"),
    BUSINESS_ERR_20001(20001, "业务错误。请仔细确认业务需要。"),
    SYSTEM_ERR_30001(30001, "系统错误，请联系系统管理员。"),
    INVALID_TOKEN_30004(30004, "Token验证不正确，请重新登录。");
    private int retCode;
    private String retMsg;

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

    private ResultStatusCode(int Errode, String retMsg)
    {
        this.retCode = Errode;
        this.retMsg = retMsg;
    }
}
