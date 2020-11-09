package com.lfyjzjxy.tourism.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 前台跳转页面
 */


@Controller
public class UserController {

    @GetMapping("/login")
    public String login(){
        return "user/login";
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
