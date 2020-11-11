package com.lfyjzjxy.tourism.api;

import com.lfyjzjxy.tourism.entity.RoadmapUserEntity;
import com.lfyjzjxy.tourism.service.RoadmapUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/roadmapUser")
public class RoadmapUserApi {

    @Autowired
    private RoadmapUserService roadmapUserService;

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
    public int save(RoadmapUserEntity roadmapUserEntity) {
        int count = roadmapUserService.save(roadmapUserEntity);
        return count;
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



