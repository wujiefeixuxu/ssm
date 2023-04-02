package com.tiBill.Controllor;

import com.sun.net.httpserver.HttpServer;
import com.tiBill.Service.CookiesService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

@RestController
public class UserController {
    @Autowired
    CookiesService cookiesService;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        Cookie[] cookies = request.getCookies();
        String value = "嗨，欢迎您来到 from zero to expert.";
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("key3".equals(cookie.getName())) {
                    String originalValue = URLDecoder.decode(cookie.getValue(), "UTF-8");
                    value =  originalValue;
                    break;
                }
            }
        }
        String encodedValue = URLEncoder.encode("嗨，欢迎您再次来到 from zero to expert.", "UTF-8");
        Cookie cookie = new Cookie("key3", encodedValue);
        cookie.setMaxAge(4);
        response.addCookie(cookie);
        return value;
    }
}