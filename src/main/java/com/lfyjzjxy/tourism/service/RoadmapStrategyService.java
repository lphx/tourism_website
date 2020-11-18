package com.lfyjzjxy.tourism.service;

import com.lfyjzjxy.tourism.entity.RoadmapStrategyEntity;
import com.lfyjzjxy.tourism.entity.RoadmapVo;
import com.lfyjzjxy.tourism.vo.RoadmapStrategyVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface RoadmapStrategyService{

    List<RoadmapStrategyEntity> page(Integer pageSize, Integer pageCount);
    void update(RoadmapStrategyEntity roadmapStrategyEntity, HttpServletRequest request);
    int save(RoadmapStrategyEntity roadmapStrategyEntity, HttpServletRequest request);
    void remove(Integer strategyId);
    int count();
    RoadmapStrategyEntity findOne(Integer strategyId);
    List<RoadmapStrategyEntity> findAllList();


    List<RoadmapStrategyVo> findAllAndScenicAndCommentAmdLikeList(Integer num, String keyword, Integer searchId, Integer page, Integer pageSize);

    List<RoadmapStrategyVo> findByUser(Integer userId);
}




