package com.lfyjzjxy.tourism.api;

import com.alibaba.fastjson.JSONObject;
import com.lfyjzjxy.tourism.entity.RoadmapStrategyEntity;
import com.lfyjzjxy.tourism.entity.RoadmapVo;
import com.lfyjzjxy.tourism.service.RoadmapStrategyService;
import com.lfyjzjxy.tourism.util.HttpCode;
import com.lfyjzjxy.tourism.vo.RoadmapStrategyVo;
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
    public HttpCode update(RoadmapStrategyEntity roadmapStrategyEntity, HttpServletRequest request) {
        roadmapStrategyService.update(roadmapStrategyEntity,request);
        return HttpCode.success(roadmapStrategyEntity.getStrategyId().toString());
    }

    @PostMapping("save")
    public HttpCode save(RoadmapStrategyEntity roadmapStrategyEntity, HttpServletRequest request) {
        int count = roadmapStrategyService.save(roadmapStrategyEntity,request);
        return HttpCode.success(roadmapStrategyEntity.getStrategyId()+"");
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

    @GetMapping("/listAjax")
    public HttpCode listAjax(Integer num, String keyword, Integer searchId , Integer page){
        JSONObject jsonObject = new JSONObject();
        List<RoadmapStrategyVo> strategyList = roadmapStrategyService.findAllAndScenicAndCommentAmdLikeList(num, keyword, searchId, page, 10);
        jsonObject.put("strategyList",strategyList);
        return HttpCode.success(jsonObject);
    }

}



