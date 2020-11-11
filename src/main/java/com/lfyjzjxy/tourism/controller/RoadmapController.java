package com.lfyjzjxy.tourism.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: Penghong Li
 * @Date: Create in 22:57 2020/11/11
 */

@Controller
@RequestMapping("/roadmap")
public class RoadmapController {

    @GetMapping("/add")
    public String add(){
        return "roadmap/roadmap_add";
    }


}
