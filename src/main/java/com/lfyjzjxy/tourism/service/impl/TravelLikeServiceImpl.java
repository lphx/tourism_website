package com.lfyjzjxy.tourism.service.impl;

import com.lfyjzjxy.tourism.entity.TravelLikeEntity;
import com.lfyjzjxy.tourism.mapper.TravelLikeMapper;
import com.lfyjzjxy.tourism.service.TravelLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TravelLikeServiceImpl implements TravelLikeService {

    @Autowired
    private TravelLikeMapper travelLikeMapper;

    public  List<TravelLikeEntity> page(Integer pageSize,Integer pageCount) {
        return travelLikeMapper.page(pageSize,pageCount);
    }

    public void update(TravelLikeEntity travelLikeEntity) {
        travelLikeMapper.update(travelLikeEntity);
    }

    public int save(TravelLikeEntity travelLikeEntity) {
        return travelLikeMapper.save(travelLikeEntity);
    }

    public void remove(Integer likeId) {
        travelLikeMapper.remove(likeId);
    }

    public int count() {
        return travelLikeMapper.count();
    }

    public TravelLikeEntity findOne(Integer likeId) {
        return travelLikeMapper.findOne(likeId);
    }

    public List<TravelLikeEntity> findAllList() {
        return travelLikeMapper.findAllList();
    }

    @Override
    public TravelLikeEntity findOneByUserAndTravel(Integer userId, Integer travelId) {
        return travelLikeMapper.findOneByUserAndTravel(userId,travelId);
    }

}





