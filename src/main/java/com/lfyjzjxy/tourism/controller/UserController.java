package com.lfyjzjxy.tourism.controller;

import com.lfyjzjxy.tourism.entity.RoadmapEntity;
import com.lfyjzjxy.tourism.entity.RoadmapVo;
import com.lfyjzjxy.tourism.entity.ScenicEntity;
import com.lfyjzjxy.tourism.entity.UserEntity;
import com.lfyjzjxy.tourism.service.RoadmapService;
import com.lfyjzjxy.tourism.service.RoadmapStrategyService;
import com.lfyjzjxy.tourism.service.ScenicService;
import com.lfyjzjxy.tourism.service.UserService;
import com.lfyjzjxy.tourism.util.RequestUtil;
import com.lfyjzjxy.tourism.vo.RoadmapStrategyVo;
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

    @Autowired
    UserService userService;

    @Autowired
    ScenicService scenicService;

    @Autowired
    RoadmapStrategyService roadmapStrategyService;




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
    public String index(Integer userId,Model model,HttpServletRequest request){
        UserEntity userEntity = userService.findOne(userId);
        List<RoadmapStrategyVo> voList = roadmapStrategyService.findByUser(userId);
        Integer userSession = RequestUtil.getSession(request)==null?0: RequestUtil.getSession(request).getUserId();
        model.addAttribute("userSession",userSession);
        model.addAttribute("userEntity",userEntity);
        model.addAttribute("voList",voList);
        return "user/detail";
    }

    @GetMapping("/user/roadmap")
    public String roadmap(Integer userId, Model model,HttpServletRequest request){
        UserEntity userEntity = userService.findOne(userId);

        List<RoadmapVo> roadmapList = roadmapService.findByUser(userId);
        Integer userSession = RequestUtil.getSession(request)==null?0: RequestUtil.getSession(request).getUserId();
        model.addAttribute("roadmapList",roadmapList);
        model.addAttribute("userSession",userSession);
        model.addAttribute("userEntity",userEntity);
        return "user/roadmap";
    }

    @GetMapping("/user/scenic")
    public String scenic(Integer userId, Model model,HttpServletRequest request){
        UserEntity userEntity = userService.findOne(userId);

        List<ScenicEntity> scenicList = scenicService.findAllList();
        Integer userSession = RequestUtil.getSession(request)==null?0: RequestUtil.getSession(request).getUserId();
        model.addAttribute("scenicList",scenicList);
        model.addAttribute("userSession",userSession);
        model.addAttribute("userEntity",userEntity);
        return "user/scenic";
    }

}
