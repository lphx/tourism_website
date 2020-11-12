package com.lfyjzjxy.tourism.api;

import com.lfyjzjxy.tourism.entity.RoadmapUserEntity;
import com.lfyjzjxy.tourism.entity.UserEntity;
import com.lfyjzjxy.tourism.service.RoadmapUserService;
import com.lfyjzjxy.tourism.service.UserService;
import com.lfyjzjxy.tourism.util.RequestUtil;
import com.lfyjzjxy.tourism.vo.RoadmapUserVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@RequestMapping("/roadmapUser")
public class RoadmapUserApi {

    @Autowired
    private RoadmapUserService roadmapUserService;

    @Autowired
    UserService userService;

    @PostMapping("/page")
    public List<RoadmapUserEntity> page(Integer pageSize, Integer pageCount) {
        return roadmapUserService.page(pageSize,pageCount);
    }

    @PutMapping("/update")
    public String update(RoadmapUserEntity roadmapUserEntity) {
        roadmapUserService.update(roadmapUserEntity);
        return "success";
    }

    @PostMapping("save")
    public RoadmapUserVo save(RoadmapUserEntity roadmapUserEntity, HttpServletRequest request) {

        UserEntity session = RequestUtil.getSession(request);
        roadmapUserEntity.setUserId(session.getUserId());
        int count = roadmapUserService.save(roadmapUserEntity);

        UserEntity userEntity = userService.findOne(session.getUserId());
        RoadmapUserVo roadmapUserVo = new RoadmapUserVo();

        BeanUtils.copyProperties(userEntity,roadmapUserVo);
        BeanUtils.copyProperties(roadmapUserEntity,roadmapUserVo);

        return roadmapUserVo;
    }

    @DeleteMapping("/remove")
    public String remove(Integer id) {
        roadmapUserService.remove(id);
        return "success";
    }

    @GetMapping("/count")
    public int count() {
        return roadmapUserService.count();
    }

    @GetMapping("findById")
    public RoadmapUserEntity findById(Integer id) {
        return roadmapUserService.findOne(id);
    }

    @GetMapping("/findAll")
    public List<RoadmapUserEntity> findAll() {
        return roadmapUserService.findAllList();
    }

}



