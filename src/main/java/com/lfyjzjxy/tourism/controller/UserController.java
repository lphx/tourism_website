package com.lfyjzjxy.tourism.controller;

import com.lfyjzjxy.tourism.util.RequestUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 前台跳转页面
 */


@Controller
public class UserController {

    @GetMapping("/login")
    public String login(){
        return "user/login";
    }


    @GetMapping("/loginOut")
    public String loginOut(HttpServletRequest request){
        RequestUtil.removeSession(request);
        return "redirect:";
    }

    @GetMapping("/register")
    public String register(){
        return "user/register";
    }

    @GetMapping("/change")
    public String change(){
        return "user/change";
    }

}
