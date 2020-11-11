package com.lfyjzjxy.tourism.service;

import com.lfyjzjxy.tourism.entity.ScenicPictureEntity;

import java.util.List;

public interface ScenicPictureService {

    int save(ScenicPictureEntity scenicPictrueEntity);
    void remove(Integer id);

    ScenicPictureEntity findOne(Integer id);
    List<ScenicPictureEntity> findAllList();


    List<ScenicPictureEntity> findAllByScenicId(Integer scenicId);

    List<ScenicPictureEntity> findAllByScenicIdLimitThree(Integer scenicId);
}




