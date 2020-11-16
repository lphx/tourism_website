package com.lfyjzjxy.tourism.service.impl;

import com.lfyjzjxy.tourism.entity.StrategyCommentEntity;
import com.lfyjzjxy.tourism.mapper.StrategyCommentMapper;
import com.lfyjzjxy.tourism.service.StrategyCommentService;
import com.lfyjzjxy.tourism.vo.StrategyCommentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StrategyCommentServiceImpl implements StrategyCommentService {

    @Autowired
    private StrategyCommentMapper strategyCommentMapper;

    public  List<StrategyCommentEntity> page(Integer pageSize, Integer pageCount) {
        return strategyCommentMapper.page(pageSize,pageCount);
    }

    public void update(StrategyCommentEntity strategyCommentEntity) {
        strategyCommentMapper.update(strategyCommentEntity);
    }

    public int save(StrategyCommentEntity strategyCommentEntity) {
        return strategyCommentMapper.save(strategyCommentEntity);
    }

    public void remove(Integer id) {
        strategyCommentMapper.remove(id);
    }

    public int count() {
        return strategyCommentMapper.count();
    }

    public StrategyCommentEntity findOne(Integer id) {
        return strategyCommentMapper.findOne(id);
    }

    public List<StrategyCommentEntity> findAllList() {
        return strategyCommentMapper.findAllList();
    }

    @Override
    public List<StrategyCommentVo> findOneByStrategy(Integer strategyId) {

        List<StrategyCommentVo> pList = strategyCommentMapper.findOneByStrategy(strategyId, 0);
        pList.stream().forEach(item ->{
            List<StrategyCommentVo> childList = strategyCommentMapper.findOneByStrategy(strategyId, item.getId());
            item.setChildList(childList);
        });


        return pList;
    }

    @Override
    public StrategyCommentVo findOneByUsename(Integer id) {
        return strategyCommentMapper.findOneByUsename(id);
    }

}





