package com.lfyjzjxy.tourism.service;

import com.lfyjzjxy.tourism.entity.StrategyLikeEntity;

import java.util.List;

public interface StrategyLikeService{

    List<StrategyLikeEntity> page(Integer pageSize, Integer pageCount);
    void update(StrategyLikeEntity strategyLikeEntity);
    int save(StrategyLikeEntity strategyLikeEntity);
    void remove(Integer id);
    int count();
    StrategyLikeEntity findOne(Integer id);
    List<StrategyLikeEntity> findAllList();


}




