package com.lfyjzjxy.tourism.service;

import com.lfyjzjxy.tourism.entity.ProvincesEntity;

import java.util.List;

public interface ProvincesService{


    List<ProvincesEntity> findAllList();


    List<ProvincesEntity> findPid();
    List<ProvincesEntity> findCidByPid(Integer pid);
}




