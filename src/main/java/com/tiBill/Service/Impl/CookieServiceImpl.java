package com.tiBill.Service.Impl;

import com.tiBill.Service.CookiesService;
import jakarta.servlet.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

@Service
public class CookieServiceImpl implements CookiesService {


    @Override
    public String setCookies(HttpServletResponse response) throws UnsupportedEncodingException {
        String Value = URLEncoder.encode("嗨,欢迎您再次到 from zero to expert.","UTF-8");
        //HttpServerletRequest 装请求信息类
        //HttpServerletRespionse 装相应信息的类
        Cookie cookie = new Cookie("key1", Value);
        cookie.setMaxAge(60*60*24);
        response.addCookie(cookie);
        String cookieValue = cookie.getValue();
        return cookieValue;
    }
    @Override
    public String getCookies(HttpServletRequest httpServletRequest) {
        //HttpServletRequest 装请求信息类
        //HttpServletRespionse 装相应信息的类
        //   Cookie cookie=new Cookie("sessionId","CookieTestInfo");
        Cookie[] cookies = httpServletRequest.getCookies();

        if (cookies != null) {
            for (Cookie cookie:cookies){
                if ("key1".equals(cookie.getName())){
                    String originalCookieValue = null;
                    try {
                        originalCookieValue = URLDecoder.decode(cookie.getValue(), "UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        throw new RuntimeException(e);
                    }
                    return originalCookieValue;
                }
            }
        }
        return "没有找到这个cookies";
    }
}
