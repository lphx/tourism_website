package com.lfyjzjxy.tourism.service;

import com.lfyjzjxy.tourism.entity.TravelEntity;
import com.lfyjzjxy.tourism.vo.TravelVo;

import java.util.List;

public interface TravelService{

    List<TravelEntity> page(Integer pageSize, Integer pageCount);
    void update(TravelEntity travelEntity);
    int save(TravelEntity travelEntity);
    void remove(Integer travelId);
    int count();
    TravelEntity findOne(Integer travelId);
    List<TravelEntity> findAllList();


    List<TravelVo> findAllListBySearch(String keyword, Integer num);
}




