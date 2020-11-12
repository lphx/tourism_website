package com.lfyjzjxy.tourism.api;

import com.alibaba.fastjson.JSONObject;
import com.lfyjzjxy.tourism.entity.RoadmapEntity;
import com.lfyjzjxy.tourism.entity.RoadmapVo;
import com.lfyjzjxy.tourism.service.RoadmapScenicService;
import com.lfyjzjxy.tourism.service.RoadmapService;
import com.lfyjzjxy.tourism.service.RoadmapUserService;
import com.lfyjzjxy.tourism.util.HttpCode;
import com.lfyjzjxy.tourism.vo.RoadmapScenicVo;
import com.lfyjzjxy.tourism.vo.RoadmapUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@RequestMapping("/roadmap")
public class RoadmapApi {

    @Autowired
    private RoadmapService roadmapService;

    @Autowired
    RoadmapScenicService roadmapScenicService;

    @Autowired
    RoadmapUserService roadmapUserService;

    @PostMapping("/page")
    public List<RoadmapEntity> page(Integer pageSize, Integer pageCount) {
        return roadmapService.page(pageSize,pageCount);
    }

    @PutMapping("/update")
    public HttpCode update(RoadmapVo roadmapVo, HttpServletRequest request) {
        roadmapService.update(roadmapVo,request);
        return HttpCode.success(roadmapVo.getRoadmapId()+"");
    }

    @PostMapping("/save")
    public HttpCode save(RoadmapVo roadmapVo, HttpServletRequest request) {
        int count = roadmapService.save(roadmapVo,request);
        if (count<0){
            return HttpCode.fail();
        }
        return HttpCode.success(count+"");
    }

    @DeleteMapping("/remove")
    public String remove(Integer roadmapId) {
        roadmapService.remove(roadmapId);
        return "success";
    }



    @GetMapping("/findById")
    public HttpCode findById(Integer roadmapId) {
        JSONObject jsonObject = new JSONObject();
        List<RoadmapScenicVo> roadmapScenicVos = roadmapScenicService.findByRoadmapId(roadmapId);
        RoadmapEntity roadmapEntity = roadmapService.findOne(roadmapId);
        jsonObject.put("roadmapScenicVos",roadmapScenicVos);
        jsonObject.put("roadmapEntity",roadmapEntity);
        return HttpCode.success(jsonObject);
    }

    @GetMapping("/findRoadmapAndUserById")
    public HttpCode findRoadmapAndUserById(Integer roadmapId) {
        JSONObject jsonObject = new JSONObject();
        List<RoadmapUserVo> roadmapUserVos = roadmapUserService.findByRoadmapId(roadmapId);
        RoadmapEntity roadmapEntity = roadmapService.findOne(roadmapId);
        jsonObject.put("roadmapUserVos",roadmapUserVos);
        jsonObject.put("roadmapEntity",roadmapEntity);
        return HttpCode.success(jsonObject);
    }

    @GetMapping("/findAll")
    public List<RoadmapEntity> findAll() {
        return roadmapService.findAllList();
    }

}



