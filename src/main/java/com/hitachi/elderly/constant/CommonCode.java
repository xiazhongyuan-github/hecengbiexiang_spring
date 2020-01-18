package com.hitachi.elderly.constant;

public class CommonCode {
    public static final Integer DELETE_STATUS_ZERO = 0;  //删除标识0
    //socket池
    public static final Integer SOCKET_PORT = 9091; //socket的端口号
    //获取微信id的url
    public static final String GET_VXID_URL = "https://api.weixin.qq.com/sns/jscode2session";
    //获取微信id的请求参数
    public static final String CODE2SESSION = "appid=wxfa61348928088ec4&secret=b4de0575017a771aa2819d7aec6eef97&js_code=%s&grant_type=authorization_code";

    //评论code头
    public static final String COMMENT_CODE = "CC";

}
