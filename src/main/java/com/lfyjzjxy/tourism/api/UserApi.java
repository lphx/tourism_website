package com.lfyjzjxy.tourism.api;


import com.lfyjzjxy.tourism.service.UserService;
import com.lfyjzjxy.tourism.entity.UserEntity;
import com.lfyjzjxy.tourism.util.HttpCode;
import com.lfyjzjxy.tourism.util.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserApi {

    @Autowired
    private UserService userService;

    @PostMapping("/page")
    public  List<UserEntity> page(Integer pageSize,Integer pageCount) {
        return userService.page(pageSize,pageCount);
    }

    @PutMapping("/update")
    public HttpCode update(UserEntity userEntity) {
        //1.查询账号是否存在--存在就可以修改密码
        UserEntity user = userService.findUsername(userEntity.getUsername());
        if (user == null){
            return new HttpCode(501,"注册失败,用户名已存在",null);
        }
        userService.update(userEntity);
        return new HttpCode(200,"",null);
    }

    @PostMapping("/save")
    public HttpCode save(UserEntity userEntity,HttpServletRequest request) {
        //查找账号是否存在，存在就不能注册
        UserEntity countUsername = userService.findUsername(userEntity.getUsername());
        if (countUsername != null){
            return new HttpCode(501,"注册失败,用户名已存在",null);
        }
        int count = userService.save(userEntity);
        if (count<0){
           return new HttpCode(500,"注册失败",null);
        }

        //登录成功保存session信息
        RequestUtil.setSession(request,userEntity);
        return new HttpCode(200,"",null);
    }

    @DeleteMapping("/remove")
    public String remove(Integer userId) {
        userService.remove(userId);
        return "success";
    }


    @PostMapping("/findByUsernameAndPassword")
    public HttpCode findByUsernameAndPassword(UserEntity userEntity,HttpServletRequest request) {
        //按照账号和密码去查询，null表示用户不存在，不允许登录
        UserEntity oneUser = userService.findOneUser(userEntity);
        if (null == oneUser){
            return new HttpCode(500,"账号或者密码错误",null);
        }

        //登录成功保存session信息
        RequestUtil.setSession(request,userEntity);
        return new HttpCode(200,"",null);
    }


}



