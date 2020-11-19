package com.lfyjzjxy.tourism.service;

import com.lfyjzjxy.tourism.entity.TravelLikeEntity;
import java.util.List;

public interface TravelLikeService{

    List<TravelLikeEntity> page(Integer pageSize, Integer pageCount);
    void update(TravelLikeEntity travelLikeEntity);
    int save(TravelLikeEntity travelLikeEntity);
    void remove(Integer likeId);
    int count();
    TravelLikeEntity findOne(Integer likeId);
    List<TravelLikeEntity> findAllList();


    TravelLikeEntity findOneByUserAndTravel(Integer userId, Integer travelId);
}




