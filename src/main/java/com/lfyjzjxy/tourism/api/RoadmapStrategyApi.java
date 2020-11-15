package com.lfyjzjxy.tourism.api;

import com.lfyjzjxy.tourism.entity.RoadmapStrategyEntity;
import com.lfyjzjxy.tourism.service.RoadmapStrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@RequestMapping("/roadmapStrategy")
public class RoadmapStrategyApi {

    @Autowired
    private RoadmapStrategyService roadmapStrategyService;

    @PostMapping("/page")
    public List<RoadmapStrategyEntity> page(Integer pageSize, Integer pageCount) {
        return roadmapStrategyService.page(pageSize,pageCount);
    }

    @PutMapping("/update")
    public String update(RoadmapStrategyEntity roadmapStrategyEntity, HttpServletRequest request) {
        roadmapStrategyService.update(roadmapStrategyEntity,request);
        return "success";
    }

    @PostMapping("save")
    public int save(RoadmapStrategyEntity roadmapStrategyEntity, HttpServletRequest request) {
        int count = roadmapStrategyService.save(roadmapStrategyEntity,request);
        return count;
    }

    @DeleteMapping("/remove")
    public String remove(Integer strategyId) {
        roadmapStrategyService.remove(strategyId);
        return "success";
    }

    @GetMapping("/count")
    public int count() {
        return roadmapStrategyService.count();
    }

    @GetMapping("findById")
    public RoadmapStrategyEntity findById(Integer strategyId) {
        return roadmapStrategyService.findOne(strategyId);
    }

    @GetMapping("/findAll")
    public List<RoadmapStrategyEntity> findAll() {
        return roadmapStrategyService.findAllList();
    }

}



