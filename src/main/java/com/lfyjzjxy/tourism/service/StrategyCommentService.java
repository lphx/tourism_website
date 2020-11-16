package com.lfyjzjxy.tourism.service;

import com.lfyjzjxy.tourism.entity.StrategyCommentEntity;
import com.lfyjzjxy.tourism.vo.StrategyCommentVo;

import java.util.List;

public interface StrategyCommentService{

    List<StrategyCommentEntity> page(Integer pageSize, Integer pageCount);
    void update(StrategyCommentEntity strategyCommentEntity);
    int save(StrategyCommentEntity strategyCommentEntity);
    void remove(Integer id);
    int count();
    StrategyCommentEntity findOne(Integer id);
    List<StrategyCommentEntity> findAllList();


    List<StrategyCommentVo> findOneByStrategy(Integer strategyId);

    StrategyCommentVo findOneByUsename(Integer id);
}




