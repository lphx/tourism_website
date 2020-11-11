package com.lfyjzjxy.tourism.api;

import com.lfyjzjxy.tourism.entity.RoadmapEntity;
import com.lfyjzjxy.tourism.entity.RoadmapVo;
import com.lfyjzjxy.tourism.service.RoadmapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/roadmap")
public class RoadmapApi {

    @Autowired
    private RoadmapService roadmapService;

    @PostMapping("/page")
    public List<RoadmapEntity> page(Integer pageSize, Integer pageCount) {
        return roadmapService.page(pageSize,pageCount);
    }

    @PutMapping("/update")
    public String update(RoadmapEntity roadmapEntity) {
        roadmapService.update(roadmapEntity);
        return "success";
    }

    @PostMapping("save")
    public int save(RoadmapVo roadmapVo) {
        int count = roadmapService.save(roadmapVo);
        return count;
    }

    @DeleteMapping("/remove")
    public String remove(Integer roadmapId) {
        roadmapService.remove(roadmapId);
        return "success";
    }

    @GetMapping("/count")
    public int count() {
        return roadmapService.count();
    }

    @GetMapping("findById")
    public RoadmapEntity findById(Integer roadmapId) {
        return roadmapService.findOne(roadmapId);
    }

    @GetMapping("/findAll")
    public List<RoadmapEntity> findAll() {
        return roadmapService.findAllList();
    }

}



