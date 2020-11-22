package com.lfyjzjxy.tourism.controller;

import com.lfyjzjxy.tourism.entity.*;
import com.lfyjzjxy.tourism.service.TravelLikeService;
import com.lfyjzjxy.tourism.service.TravelService;
import com.lfyjzjxy.tourism.service.UserService;
import com.lfyjzjxy.tourism.util.RequestUtil;
import com.lfyjzjxy.tourism.vo.RoadmapScenicVo;
import com.lfyjzjxy.tourism.vo.StrategyCommentVo;
import com.lfyjzjxy.tourism.vo.TravelVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: Penghong Li
 * @Date: Create in 21:54 2020/11/19
 */

@Controller
@RequestMapping("/travel")
public class TravelController {

    @Autowired
    TravelService travelService;

    @Autowired
    TravelLikeService travelLikeService;

    @Autowired
    UserService userService;

    @GetMapping("/add")
    public String add(HttpServletRequest request){
       if (RequestUtil.getSession(request) == null){
            return "common/error";
        }
        return "travel/travel_add";
    }

    @GetMapping("/edit")
    public String edit(Integer travelId, Model model,HttpServletRequest request){
        if (RequestUtil.getSession(request) == null){
            return "common/error";
        }
        model.addAttribute("travelId",travelId);
        return "travel/travel_edit";
    }

    @GetMapping("/detail")
    public String strategyDetail(Integer travelId,Model model,HttpServletRequest request){

        //查询到攻略信息
        TravelEntity travelEntity = travelService.findOne(travelId);
        //查询用户信息
        UserEntity userEntity = userService.findOne(travelEntity.getUserId());

        //点赞信息
        UserEntity session = RequestUtil.getSession(request);
        TravelLikeEntity travelLikeEntity = null;
        if (session != null){
            travelLikeEntity = travelLikeService.findOneByUserAndTravel(session.getUserId(),travelId);
            model.addAttribute("sessionUser",session.getUserId());
        }else {
            model.addAttribute("sessionUser",0);
        }

        model.addAttribute("travelEntity",travelEntity);
        model.addAttribute("userEntity",userEntity);
        model.addAttribute("travelLikeEntity",travelLikeEntity);
        return "travel/travel_detail";
    }


    @GetMapping("/list")
    public String list(String keyword,Integer num,Model model){

        List<TravelVo> list = travelService.findAllListBySearch(keyword, num);
        model.addAttribute("keyword",keyword);
        model.addAttribute("num",num);
        model.addAttribute("list",list);

        return "travel/travel_list";
    }

}
