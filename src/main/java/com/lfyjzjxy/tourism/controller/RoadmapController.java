package com.lfyjzjxy.tourism.controller;

import com.lfyjzjxy.tourism.entity.RoadmapEntity;
import com.lfyjzjxy.tourism.entity.RoadmapUserEntity;
import com.lfyjzjxy.tourism.entity.RoadmapVo;
import com.lfyjzjxy.tourism.entity.UserEntity;
import com.lfyjzjxy.tourism.service.RoadmapService;
import com.lfyjzjxy.tourism.service.RoadmapUserService;
import com.lfyjzjxy.tourism.util.RequestUtil;
import com.lfyjzjxy.tourism.vo.RoadmapUserVo;
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

    @GetMapping("/add")
    public String add(){
        return "roadmap/roadmap_add";
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
            return "redirect:detail?roadmapId="+roadmapId;
        }
        model.addAttribute("roadmapId",roadmapId);
        return "roadmap/roadmap_edit";
    }

}
