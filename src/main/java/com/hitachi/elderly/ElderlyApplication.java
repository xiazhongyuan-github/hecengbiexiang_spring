package com.hitachi.elderly;

import com.hitachi.elderly.config.MyWebSocket;
import com.hitachi.elderly.constant.CommonCode;
import org.java_websocket.WebSocketImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

@SpringBootApplication
@EnableJpaAuditing
@EnableScheduling
public class ElderlyApplication {

    public static void main(String[] args) {
        WebSocketImpl.DEBUG = false;
        int port = CommonCode.SOCKET_PORT; // 端口
        MyWebSocket s = new MyWebSocket(port);
        s.start();
        SpringApplication.run(ElderlyApplication.class, args);
    }

    @PostConstruct
    void setDefaultTimezone() {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
    }
}
