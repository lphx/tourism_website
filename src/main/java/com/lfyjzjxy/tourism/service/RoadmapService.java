package com.lfyjzjxy.tourism.service;

import com.lfyjzjxy.tourism.entity.RoadmapEntity;
import com.lfyjzjxy.tourism.entity.RoadmapVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface RoadmapService{

    List<RoadmapEntity> page(Integer pageSize, Integer pageCount);
    int save(RoadmapVo roadmapEntity, HttpServletRequest request);
    void remove(Integer roadmapId);
    RoadmapEntity findOne(Integer roadmapId);


    void update(RoadmapVo roadmapVo, HttpServletRequest request);

   RoadmapVo findById(Integer roadmapId);

    List<RoadmapVo> findAllAndScnicList(Integer num, String keyword,Integer searchId,Integer page,Integer pageSize);

    List<RoadmapVo> findByUser(Integer userId);
}




