package com.lfyjzjxy.tourism.service.impl;

import com.lfyjzjxy.tourism.entity.RoadmapStrategyEntity;
import com.lfyjzjxy.tourism.entity.RoadmapVo;
import com.lfyjzjxy.tourism.entity.UserEntity;
import com.lfyjzjxy.tourism.mapper.RoadmapStrategyMapper;
import com.lfyjzjxy.tourism.service.RoadmapStrategyService;
import com.lfyjzjxy.tourism.util.RequestUtil;
import com.lfyjzjxy.tourism.vo.RoadmapStrategyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class RoadmapStrategyServiceImpl implements RoadmapStrategyService {

    @Autowired
    private RoadmapStrategyMapper roadmapStrategyMapper;

    public  List<RoadmapStrategyEntity> page(Integer pageSize,Integer pageCount) {
        return roadmapStrategyMapper.page(pageSize,pageCount);
    }

    public void update(RoadmapStrategyEntity roadmapStrategyEntity, HttpServletRequest request) {
        UserEntity session = RequestUtil.getSession(request);
        roadmapStrategyEntity.setUserId(session.getUserId());
        roadmapStrategyMapper.update(roadmapStrategyEntity);
    }

    public int save(RoadmapStrategyEntity roadmapStrategyEntity, HttpServletRequest request) {
        UserEntity session = RequestUtil.getSession(request);
        roadmapStrategyEntity.setUserId(session.getUserId());
        return roadmapStrategyMapper.save(roadmapStrategyEntity);
    }

    public void remove(Integer strategyId) {
        roadmapStrategyMapper.remove(strategyId);
    }

    public int count() {
        return roadmapStrategyMapper.count();
    }

    public RoadmapStrategyEntity findOne(Integer strategyId) {
        return roadmapStrategyMapper.findOne(strategyId);
    }

    public List<RoadmapStrategyEntity> findAllList() {
        return roadmapStrategyMapper.findAllList();
    }

    @Override
    public List<RoadmapStrategyVo> findAllAndScenicAndCommentAmdLikeList(Integer num, String keyword, Integer searchId, Integer page, Integer pageSize) {

        if (page == null){
            page = 1;
        }
        page = (page-1)*pageSize;

        if (num != null){
            if (num == 0){
                return roadmapStrategyMapper.findAllAndScenicAndCommentAmdLikeList(null,keyword,searchId,page,pageSize);
            }
            if (num == 1){
                return roadmapStrategyMapper.findAllAndScenicAndCommentAmdLikeList(keyword,null,searchId,page,pageSize);
            }
        }

        return roadmapStrategyMapper.findAllAndScenicAndCommentAmdLikeList(null,null,searchId,page,pageSize);
    }

}





