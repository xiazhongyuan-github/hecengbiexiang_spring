package com.hitachi.elderly.constant;

public enum CancelEnum {

    ONE("1","老人原因"),
    TWO("2","个人原因"),
    THREE("3","信息有误，重新下单"),
    OTHER("1000","其他原因");
    private final String key;
    private final String value;

    private CancelEnum(String key,String value){
        this.key = key;
        this.value = value;
    }
    //根据key获取枚举
    public static CancelEnum getEnumByKey(String key){
        if(null == key){
            return null;
        }
        for(CancelEnum temp:CancelEnum.values()){
            if(temp.getKey().equals(key)){
                return temp;
            }
        }
        return null;
    }
    public String getKey() {
        return key;
    }
    public String getValue() {
        return value;
    }
}
