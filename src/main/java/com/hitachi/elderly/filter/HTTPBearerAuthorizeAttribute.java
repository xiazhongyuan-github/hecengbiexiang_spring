package com.hitachi.elderly.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.hitachi.elderly.utils.*;
import com.hitachi.elderly.bean.*;
import com.hitachi.elderly.constant.*;

/**
 * @ClassName: HTTPBearerAuthorizeAttribute
 * @Description: JWT的过滤器，验证用户
 * @Author: lizhe
 * @Date: 2018/9/4
 */
public class HTTPBearerAuthorizeAttribute implements Filter {
    @Autowired
    private Audience audienceEntity;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this,
                filterConfig.getServletContext());
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // TODO Auto-generated method stub

        ResultMsg resultMsg;
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        if (httpRequest.getMethod().equals("OPTIONS")) {
            chain.doFilter(request, response);
            return;
        } else {
            String auth = httpRequest.getHeader("Authorization");
            if ((auth != null) && (auth.length() > 7)) {
                String HeadStr = auth.substring(0, 6);
                if (HeadStr.compareTo(audienceEntity.getTokenHead()) == 0) {
                    auth = auth.substring(7);
                    if (JwtUtil.parseJWT(auth, audienceEntity.getBase64Secret()) != null) {
                        chain.doFilter(request, response);
                        return;
                    }
                }
            }
        }

        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setCharacterEncoding("UTF-8");
        httpResponse.setContentType("application/json; charset=utf-8");
        httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        ObjectMapper mapper = new ObjectMapper();

        resultMsg = new ResultMsg(ResultStatusCode.INVALID_TOKEN_30004.getRetCode(), ResultStatusCode.INVALID_TOKEN_30004.getRetMsg(), null);
        httpResponse.getWriter().write(mapper.writeValueAsString(resultMsg));
        return;
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
    }
}
