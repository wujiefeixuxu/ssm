package com.tiBill.Controllor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class UserController {
    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        System.out.println("嗨，欢迎您来到 from zero to expert.。");
        return "嗨，欢迎您来到 from zero to expert.。";
    }
}
