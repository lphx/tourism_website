package com.lfyjzjxy.tourism.service.impl;

import com.lfyjzjxy.tourism.entity.ProvincesEntity;
import com.lfyjzjxy.tourism.mapper.ProvincesMapper;
import com.lfyjzjxy.tourism.service.ProvincesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProvincesServiceImpl implements ProvincesService {

    @Autowired
    private ProvincesMapper provincesMapper;



    public List<ProvincesEntity> findAllList() {
        return provincesMapper.findAllList();
    }

    @Override
    public List<ProvincesEntity> findPid() {
        return provincesMapper.findPid();
    }

    @Override
    public List<ProvincesEntity> findCidByPid(Integer pid) {

        return  provincesMapper.findCidByPid(pid);
    }

}





