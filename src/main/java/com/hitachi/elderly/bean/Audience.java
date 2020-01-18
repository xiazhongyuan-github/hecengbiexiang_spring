package com.hitachi.elderly.bean;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;

/** 
* @ClassName: Audience
* @Description: 读取JWT配置文件类
* @Author: lizhe
* @Date: 2018/9/4
*/
@Configuration
@PropertySource("classpath:jwt.properties")
public class Audience {

    @Value("${base64Secret}")
    private String base64Secret;
    @Value("${name}")
    private String name;
    @Value("${expiresSecond}")
    private String expiresSecond;
    @Value("${tokenHead}")
    private String tokenHead;

    public String getTokenHead() {
        return tokenHead;
    }

    public void setTokenHead(String tokenHead) {
        this.tokenHead = tokenHead;
    }

    public String getBase64Secret() {
        return base64Secret;
    }

    public String getName() {
        return name;
    }

    public long getExpiresSecond() {
        return Long.parseLong(expiresSecond);
    }
}
