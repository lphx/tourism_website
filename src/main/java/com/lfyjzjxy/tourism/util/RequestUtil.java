package com.lfyjzjxy.tourism.util;

import com.lfyjzjxy.tourism.entity.UserEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author: Penghong Li
 * @Date: Create in 13:43 2020/11/11
 */

public class RequestUtil {

    public static UserEntity  getSession(HttpServletRequest request){
        HttpSession session = request.getSession();
        UserEntity user = (UserEntity)session.getAttribute("user");
        return user;
    }

    public static void  setSession(HttpServletRequest request,UserEntity userEntity){
        //登录成功保存session信息
        HttpSession session = request.getSession();
        session.setAttribute("user",userEntity);
        //session过期时间设置，以秒为单位，即在没有活动30分钟后，session将失效
        session.setMaxInactiveInterval(30 * 60);
    }

}
