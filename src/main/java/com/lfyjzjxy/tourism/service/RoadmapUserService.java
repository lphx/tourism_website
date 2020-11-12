package com.lfyjzjxy.tourism.service;

import com.lfyjzjxy.tourism.entity.RoadmapUserEntity;
import com.lfyjzjxy.tourism.vo.RoadmapScenicVo;
import com.lfyjzjxy.tourism.vo.RoadmapUserVo;

import java.util.List;

public interface RoadmapUserService{

    List<RoadmapUserEntity> page(Integer pageSize, Integer pageCount);
    void update(RoadmapUserEntity roadmapUserEntity);
    int save(RoadmapUserEntity roadmapUserEntity);
    void remove(Integer id);
    int count();
    RoadmapUserEntity findOne(Integer id);
    List<RoadmapUserEntity> findAllList();


    List<RoadmapUserVo> findByRoadmapId(Integer roadmapId);

    RoadmapUserEntity findByUserAndId(Integer userId, Integer roadmapId);
}




