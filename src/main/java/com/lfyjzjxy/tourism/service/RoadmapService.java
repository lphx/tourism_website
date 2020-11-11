package com.lfyjzjxy.tourism.service;

import com.lfyjzjxy.tourism.entity.RoadmapEntity;
import com.lfyjzjxy.tourism.entity.RoadmapVo;

import java.util.List;

public interface RoadmapService{

    List<RoadmapEntity> page(Integer pageSize, Integer pageCount);
    void update(RoadmapEntity roadmapEntity);
    int save(RoadmapVo roadmapEntity);
    void remove(Integer roadmapId);
    RoadmapEntity findOne(Integer roadmapId);
    List<RoadmapEntity> findAllList();


}




