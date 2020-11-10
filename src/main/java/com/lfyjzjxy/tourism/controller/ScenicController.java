package com.lfyjzjxy.tourism.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: Penghong Li
 * @Date: Create in 14:26 2020/11/10
 */
@Controller
@RequestMapping("/scenic")
public class ScenicController {

    @GetMapping("/add")
    public String add(){
        return "scenic/scenic_add";
    }

    @GetMapping("/edit")
    public String edit(Integer scenicId, Model model){
        model.addAttribute("scenicId",scenicId);
        return "scenic/scenic_edit";
    }

}
