package com.lfyjzjxy.tourism.controller;

import com.lfyjzjxy.tourism.entity.ScenicEntity;
import com.lfyjzjxy.tourism.entity.ScenicPictureEntity;
import com.lfyjzjxy.tourism.entity.ScenicVo;
import com.lfyjzjxy.tourism.entity.UserEntity;
import com.lfyjzjxy.tourism.service.ScenicPictureService;
import com.lfyjzjxy.tourism.service.ScenicService;
import com.lfyjzjxy.tourism.service.UserService;
import com.lfyjzjxy.tourism.util.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: Penghong Li
 * @Date: Create in 14:26 2020/11/10
 */
@Controller
@RequestMapping("/scenic")
public class ScenicController {

    @Autowired
    ScenicService scenicService;

    @Autowired
    ScenicPictureService scenicPictureService;

    @Autowired
    UserService userService;

    @GetMapping("/add")
    public String add(HttpServletRequest request){
       if (RequestUtil.getSession(request) == null){
            return "common/error";
        }
        return "scenic/scenic_add";
    }


    @GetMapping("/list")
    public String list(String keyword,Integer provinceId,Integer cityId,Model model){


        List<ScenicVo> list  = scenicService.findKeywordAndProvince(keyword,provinceId,cityId);
        model.addAttribute("list",list);
        model.addAttribute("keyword",keyword);
        model.addAttribute("provinceId",provinceId==null?0:provinceId);
        model.addAttribute("cityId",cityId==null?0:cityId);

        return "scenic/scenic_list";
    }

    @GetMapping("/edit")
    public String edit(Integer scenicId, Model model, HttpServletRequest request){
        //登录成功保存session信息
        UserEntity userSession = RequestUtil.getSession(request);
        if (userSession == null){
            return "common/error";
        }
        /*ScenicEntity scenicEntity = scenicService.findUserId(userSession.getUserId(),scenicId);
        if (scenicEntity==null){
            //return "redirect:detail?scenicId="+scenicId;
            return "common/error";
        }*/
        //假如用户没有编辑的权限就定型到详情页

        model.addAttribute("scenicId",scenicId);
        return "scenic/scenic_edit";
    }

    @GetMapping("/detail")
    public String detail(Integer scenicId,Model model){
        ScenicEntity scenicEntity = scenicService.findOne(scenicId);
        List<ScenicPictureEntity> scenicPictureList = scenicPictureService.findAllByScenicIdLimitThree(scenicId);
        model.addAttribute("scenicEntity",scenicEntity);
        model.addAttribute("scenicPictureList",scenicPictureList);
        return "scenic/scenic_detail";
    }

}
