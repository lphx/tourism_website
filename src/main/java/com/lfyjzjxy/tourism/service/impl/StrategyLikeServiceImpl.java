package com.lfyjzjxy.tourism.service.impl;

import com.lfyjzjxy.tourism.entity.StrategyLikeEntity;
import com.lfyjzjxy.tourism.mapper.StrategyLikeMapper;
import com.lfyjzjxy.tourism.service.StrategyLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StrategyLikeServiceImpl implements StrategyLikeService {

    @Autowired
    private StrategyLikeMapper strategyLikeMapper;

    public  List<StrategyLikeEntity> page(Integer pageSize, Integer pageCount) {
        return strategyLikeMapper.page(pageSize,pageCount);
    }

    public void update(StrategyLikeEntity strategyLikeEntity) {
        strategyLikeMapper.update(strategyLikeEntity);
    }

    public int save(StrategyLikeEntity strategyLikeEntity) {
        return strategyLikeMapper.save(strategyLikeEntity);
    }

    public void remove(Integer id) {
        strategyLikeMapper.remove(id);
    }

    public int count() {
        return strategyLikeMapper.count();
    }

    public StrategyLikeEntity findOne(Integer id) {
        return strategyLikeMapper.findOne(id);
    }

    public List<StrategyLikeEntity> findAllList() {
        return strategyLikeMapper.findAllList();
    }

    @Override
    public StrategyLikeEntity findOneByUserAndStrategy(Integer userId, Integer strategyId) {
        return strategyLikeMapper.findOneByUserAndStrategy(userId,strategyId);
    }

}





