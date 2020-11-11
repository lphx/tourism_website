package com.lfyjzjxy.tourism.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: Penghong Li
 * @Date: Create in 17:35 2020/11/11
 */
@Controller
public class IndexController {

    @GetMapping
    public String index(){
        return "redirect:/scenic/list";
    }

}
