package com.lfyjzjxy.tourism.service.impl;

import com.lfyjzjxy.tourism.entity.TravelEntity;
import com.lfyjzjxy.tourism.mapper.TravelMapper;
import com.lfyjzjxy.tourism.service.TravelService;
import com.lfyjzjxy.tourism.vo.TravelVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TravelServiceImpl implements TravelService {

    @Autowired
    private TravelMapper travelMapper;

    public  List<TravelEntity> page(Integer pageSize,Integer pageCount) {
        return travelMapper.page(pageSize,pageCount);
    }

    public void update(TravelEntity travelEntity) {
        travelMapper.update(travelEntity);
    }

    public int save(TravelEntity travelEntity) {
        return travelMapper.save(travelEntity);
    }

    public void remove(Integer travelId) {
        travelMapper.remove(travelId);
    }

    public int count() {
        return travelMapper.count();
    }

    public TravelEntity findOne(Integer travelId) {
        return travelMapper.findOne(travelId);
    }

    public List<TravelEntity> findAllList() {
        return travelMapper.findAllList();
    }

    @Override
    public List<TravelVo> findAllListBySearch(String keyword, Integer num) {

        num = num==null?3:num;
        return travelMapper.findAllListBySearch(keyword,num);


    }

    @Override
    public List<TravelVo> findAllListByUser(Integer userId) {
        return travelMapper.findAllListByUser(userId);
    }

}





