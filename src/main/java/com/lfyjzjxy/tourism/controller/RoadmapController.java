package com.lfyjzjxy.tourism.controller;

import com.lfyjzjxy.tourism.entity.*;
import com.lfyjzjxy.tourism.service.*;
import com.lfyjzjxy.tourism.util.RequestUtil;
import com.lfyjzjxy.tourism.vo.RoadmapScenicVo;
import com.lfyjzjxy.tourism.vo.RoadmapStrategyVo;
import com.lfyjzjxy.tourism.vo.RoadmapUserVo;
import com.lfyjzjxy.tourism.vo.StrategyCommentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: Penghong Li
 * @Date: Create in 22:57 2020/11/11
 */

@Controller
@RequestMapping("/roadmap")
public class RoadmapController {

    @Autowired
    RoadmapService roadmapService;

    @Autowired
    RoadmapUserService roadmapUserService;

    @Autowired
    RoadmapStrategyService roadmapStrategyService;

    @Autowired
    UserService userService;

    @Autowired
    RoadmapScenicService roadmapScenicService;

    @Autowired
    StrategyLikeService strategyLikeService;

    @Autowired
    StrategyCommentService strategyCommentService;

    @GetMapping("/add")
    public String add(HttpServletRequest request){
       if (RequestUtil.getSession(request) == null){
           return "common/error";
        }
        return "roadmap/roadmap_add";
    }

    @GetMapping("/list")
    public String list(Integer num,String keyword,Integer searchId ,Model model){
        searchId = searchId==null?1:searchId;
        List<RoadmapVo> roadmapList = roadmapService.findAllAndScnicList(num,keyword,searchId,1,10);

        //List<RoadmapVo> roadmapNewList = roadmapService.findAllAndScnicList(3,null,1,1,3);
        List<RoadmapVo> roadmapHotList = roadmapService.findAllAndScnicList(3,null,2,1,5);
        model.addAttribute("roadmapList",roadmapList);
        model.addAttribute("num",num);
        model.addAttribute("keyword",keyword);
        model.addAttribute("searchId",searchId);
       // model.addAttribute("roadmapNewList",roadmapNewList);
        model.addAttribute("roadmapHotList",roadmapHotList);
        return "roadmap/roadmap_list";
    }

    @GetMapping("/detail")
    public String detail(Integer roadmapId,Model model,HttpServletRequest request){
        UserEntity session = RequestUtil.getSession(request);
        Integer userId = 0;
        if (session != null){
            userId = session.getUserId();
        }
        List<RoadmapUserVo> roadmapUserVos = roadmapUserService.findByRoadmapId(roadmapId);
        RoadmapUserEntity roadmapUserEntity =  roadmapUserService.findByUserAndId(userId,roadmapId);
        RoadmapVo roadmapVo = roadmapService.findById(roadmapId);
        model.addAttribute("roadmapUserVos",roadmapUserVos);
        model.addAttribute("roadmapVo",roadmapVo);
        model.addAttribute("userId", userId);
        model.addAttribute("userIdStatus", roadmapUserEntity==null?0:1);
        model.addAttribute("statusName", roadmapVo.getStatusName());
        return "roadmap/roadmap_detail";
    }

    @GetMapping("/edit")
    public String edit(Integer roadmapId, Model model, HttpServletRequest request){
        RoadmapEntity roadmapEntity = roadmapService.findOne(roadmapId);
        UserEntity session = RequestUtil.getSession(request);
        if (session == null || roadmapEntity.getUserId() != session.getUserId()){
            //return "redirect:detail?roadmapId="+roadmapId;
            return "common/error";
        }
        model.addAttribute("roadmapId",roadmapId);
        return "roadmap/roadmap_edit";
    }

    @GetMapping("/strategyAdd")
    public String strategyAdd(Integer roadmapId,Model model){
        model.addAttribute("roadmapId",roadmapId);
        return "personage/strategy_add";
    }

    @GetMapping("/strategyEdit")
    public String strategyEdit(Integer strategyId,Model model){
        model.addAttribute("strategyId",strategyId);
        return "personage/strategy_edit";
    }

    @GetMapping("/strategyList")
    public String strategyList(Integer num,String keyword,Integer searchId ,Model model){
        searchId = searchId==null?1:searchId;
        List<RoadmapStrategyVo> strategyList = roadmapStrategyService.findAllAndScenicAndCommentAmdLikeList(num,keyword,searchId,1,10);

        //List<RoadmapVo> roadmapNewList = roadmapService.findAllAndScnicList(3,null,1,1,3);
        List<RoadmapStrategyVo> strategyHotList = roadmapStrategyService.findAllAndScenicAndCommentAmdLikeList(4,null,4,1,10);
        model.addAttribute("strategyList",strategyList);
        model.addAttribute("num",num);
        model.addAttribute("keyword",keyword);
        model.addAttribute("searchId",searchId);
        // model.addAttribute("roadmapNewList",roadmapNewList);
        model.addAttribute("strategyHotList",strategyHotList);
        return "personage/strategy_list";
    }

    @GetMapping("/strategyDetail")
    public String strategyDetail(Integer strategyId,Model model,HttpServletRequest request){

        //查询到攻略信息
        RoadmapStrategyEntity roadmapStrategy = roadmapStrategyService.findOne(strategyId);
        //查询用户信息
        UserEntity userEntity = userService.findOne(roadmapStrategy.getUserId());
        //查询该攻略里的路线里的景点名称
        List<RoadmapScenicVo> roadmapScenicList = roadmapScenicService.findByRoadmapId(roadmapStrategy.getRoadmapId());
        //点赞信息
        UserEntity session = RequestUtil.getSession(request);
        StrategyLikeEntity strategyLikeEntity = null;
        if (session != null){
            strategyLikeEntity = strategyLikeService.findOneByUserAndStrategy(session.getUserId(),strategyId);
            model.addAttribute("sessionUser",session.getUserId());
        }else {
            model.addAttribute("sessionUser",0);
        }
        //评论信息
        List<StrategyCommentVo> strategyCommentList = strategyCommentService.findOneByStrategy(strategyId);



        model.addAttribute("roadmapStrategy",roadmapStrategy);
        model.addAttribute("userEntity",userEntity);
        model.addAttribute("roadmapScenicList",roadmapScenicList);
        model.addAttribute("strategyCommentList",strategyCommentList);
        model.addAttribute("strategyLikeEntity",strategyLikeEntity);
        return "personage/strategy_detail";
    }

}
