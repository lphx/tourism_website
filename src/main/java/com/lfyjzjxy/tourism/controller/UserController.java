package com.lfyjzjxy.tourism.controller;

import com.lfyjzjxy.tourism.entity.RoadmapEntity;
import com.lfyjzjxy.tourism.entity.RoadmapVo;
import com.lfyjzjxy.tourism.service.RoadmapService;
import com.lfyjzjxy.tourism.util.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 前台跳转页面
 */


@Controller
public class UserController {

    @Autowired
    RoadmapService roadmapService;


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


    @GetMapping("/user/detail")
    public String index(Integer userId,Model model){
        model.addAttribute("userId",userId);
        return "user/detail";
    }

    @GetMapping("/user/roadmap")
    public String roadmap(Integer userId, Model model,HttpServletRequest request){
        List<RoadmapVo> roadmapList = roadmapService.findByUser(userId);
        Integer userSession = RequestUtil.getSession(request)==null?0:1;
        model.addAttribute("roadmapList",roadmapList);
        model.addAttribute("userSession",userSession);
        model.addAttribute("userId",userId);
        return "user/roadmap";
    }

}
