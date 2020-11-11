package com.lfyjzjxy.tourism.service;

import com.lfyjzjxy.tourism.entity.RoadmapUserEntity;
import java.util.List;

public interface RoadmapUserService{

    List<RoadmapUserEntity> page(Integer pageSize, Integer pageCount);
    void update(RoadmapUserEntity roadmapUserEntity);
    int save(RoadmapUserEntity roadmapUserEntity);
    void remove(Integer id);
    int count();
    RoadmapUserEntity findOne(Integer id);
    List<RoadmapUserEntity> findAllList();


}




