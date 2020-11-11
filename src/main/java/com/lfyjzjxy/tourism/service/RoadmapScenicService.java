package com.lfyjzjxy.tourism.service;

import com.lfyjzjxy.tourism.entity.RoadmapScenicEntity;
import java.util.List;

public interface RoadmapScenicService{

    List<RoadmapScenicEntity> page(Integer pageSize, Integer pageCount);
    void update(RoadmapScenicEntity roadmapScenicEntity);
    int save(RoadmapScenicEntity roadmapScenicEntity);
    void remove(Integer id);
    int count();
    RoadmapScenicEntity findOne(Integer id);
    List<RoadmapScenicEntity> findAllList();


}




