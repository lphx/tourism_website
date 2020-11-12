package com.lfyjzjxy.tourism.controller;

import com.lfyjzjxy.tourism.entity.RoadmapEntity;
import com.lfyjzjxy.tourism.entity.UserEntity;
import com.lfyjzjxy.tourism.service.RoadmapService;
import com.lfyjzjxy.tourism.util.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Penghong Li
 * @Date: Create in 22:57 2020/11/11
 */

@Controller
@RequestMapping("/roadmap")
public class RoadmapController {

    @Autowired
    RoadmapService roadmapService;

    @GetMapping("/add")
    public String add(){
        return "roadmap/roadmap_add";
    }

    @GetMapping("/edit")
    public String edit(Integer roadmapId, Model model, HttpServletRequest request){
        RoadmapEntity roadmapEntity = roadmapService.findOne(roadmapId);
        UserEntity session = RequestUtil.getSession(request);
        if (session == null || roadmapEntity.getUserId() != session.getUserId()){
            return "roadmap/roadmap_add";
        }
        model.addAttribute("roadmapId",roadmapId);
        return "roadmap/roadmap_edit";
    }

}
