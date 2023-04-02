package com.tiBill.Service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.UnsupportedEncodingException;

public interface CookiesService {
    String setCookies(HttpServletResponse response) throws UnsupportedEncodingException;

    String getCookies(HttpServletRequest httpServletRequest);
}
