package com.lfyjzjxy.tourism.api;


import com.lfyjzjxy.tourism.service.UserService;
import com.lfyjzjxy.tourism.entity.UserEntity;
import com.lfyjzjxy.tourism.util.HttpCode;
import com.lfyjzjxy.tourism.util.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


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
        userEntity.setPhoto(getPhotot().get(new Random().nextInt(10)+1));
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
        RequestUtil.setSession(request,oneUser);
        return new HttpCode(200,"",null);
    }


    private Map<Integer,String> getPhotot(){
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"https://n1-q.mafengwo.net/s10/M00/02/E2/wKgBZ1l0qvSAb5EdAACCJaW3yqE78.jpeg?imageMogr2%2Fthumbnail%2F%21200x200r%2Fgravity%2FCenter%2Fcrop%2F%21200x200%2Fquality%2F90");
        map.put(2,"https://b1-q.mafengwo.net/s10/M00/73/96/wKgBZ1kSsyKAa_91AACgQYkA64o659.png?imageMogr2%2Fthumbnail%2F%21200x200r%2Fgravity%2FCenter%2Fcrop%2F%21200x200%2Fquality%2F90");
        map.put(3,"https://b1-q.mafengwo.net/s15/M00/CF/AE/CoUBGV2tko-ANmj7AByibJhTMmI867.png?imageMogr2%2Fthumbnail%2F%2148x48r%2Fgravity%2FCenter%2Fcrop%2F%2148x48%2Fquality%2F90");
        map.put(4,"https://b1-q.mafengwo.net/s11/M00/10/2B/wKgBEFszebyAKva-AAAJ2_cfM9g23.jpeg?imageMogr2%2Fthumbnail%2F%2180x80r%2Fgravity%2FCenter%2Fcrop%2F%2180x80%2Fquality%2F90");
        map.put(5,"https://p1-q.mafengwo.net/s8/M00/EE/86/wKgBpVWDw_uAPwQ9AAU4xXzKMDI57.jpeg?imageMogr2%2Fthumbnail%2F%2180x80r%2Fgravity%2FCenter%2Fcrop%2F%2180x80%2Fquality%2F90");
        map.put(6,"https://b1-q.mafengwo.net/s12/M00/A6/CC/wKgED1vysNCAKjjOAArv9qt0fwA27.jpeg?imageMogr2%2Fthumbnail%2F%2180x80r%2Fgravity%2FCenter%2Fcrop%2F%2180x80%2Fquality%2F90");
        map.put(7,"https://n1-q.mafengwo.net/s10/M00/1F/13/wKgBZ1iusGOAfYpxAAB9PGlZZlk37.jpeg?imageMogr2%2Fthumbnail%2F%2148x48r%2Fgravity%2FCenter%2Fcrop%2F%2148x48%2Fquality%2F90");
        map.put(8,"https://b1-q.mafengwo.net/s17/M00/BE/84/CoUBXl-5JNyADl8lAAB6Z_v6FhI31.jpeg?imageMogr2%2Fthumbnail%2F%2180x80r%2Fgravity%2FCenter%2Fcrop%2F%2180x80%2Fquality%2F90");
        map.put(9,"https://n1-q.mafengwo.net/s9/M00/75/9A/wKgBs1dSfE6AFmDaAAEJzHvg_JM07.jpeg?imageMogr2%2Fthumbnail%2F%2148x48r%2Fgravity%2FCenter%2Fcrop%2F%2148x48%2Fquality%2F90");
        map.put(10,"https://p1-q.mafengwo.net/s16/M00/1F/5A/CoUBUl8HGS2AbRyNAABLzAW61WM26.jpeg?imageMogr2%2Fthumbnail%2F%2148x48r%2Fgravity%2FCenter%2Fcrop%2F%2148x48%2Fquality%2F90");
        return map;
    }

}



