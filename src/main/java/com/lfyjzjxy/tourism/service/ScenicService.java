package com.lfyjzjxy.tourism.service;

import com.lfyjzjxy.tourism.entity.ScenicEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ScenicService{

    List<ScenicEntity> page(Integer pageSize, Integer pageCount);
    void update(ScenicEntity scenicEntity);
    int save(ScenicEntity scenicEntity, HttpServletRequest request);
    void remove(Integer scenicId);
    ScenicEntity findOne(Integer scenicId);
    List<ScenicEntity> findAllList();


}




