package com.lfyjzjxy.tourism.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lfyjzjxy.tourism.entity.AdminEntity;
import com.lfyjzjxy.tourism.entity.UserEntity;
import com.lfyjzjxy.tourism.service.AdminService;
import com.lfyjzjxy.tourism.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Penghong Li
 * @Date: Create in 23:42 2020/11/23
 */

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String adminLogin(){
        return "admin/login";
    }

    @PostMapping("/login")
    public String login(AdminEntity adminEntity, Model model, HttpServletRequest request){
        AdminEntity entity = adminService.findByUsernamAndPassword(adminEntity);
        if (entity==null){
            model.addAttribute("error","账号或者密码错误");
            return "admin/login";
        }
        HttpSession session = request.getSession();
        session.setAttribute("admin",entity);
        return "admin/index";
    }

    @GetMapping("/user")
    public String user(){
        return "admin/user/user_list";
    }

    @GetMapping("/travel")
    public String travel(){
        return "admin/travel/travel_list";
    }


    @GetMapping("/scenic")
    public String scenic(){
        return "admin/scenic/scenic_list";
    }

    @GetMapping("/roadmap")
    public String roadmap(){
        return "admin/roadmap/roadmap_list";
    }
}
