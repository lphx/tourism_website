package com.lfyjzjxy.tourism.service.impl;

import com.lfyjzjxy.tourism.entity.RoadmapUserEntity;
import com.lfyjzjxy.tourism.mapper.RoadmapUserMapper;
import com.lfyjzjxy.tourism.service.RoadmapUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoadmapUserServiceImpl implements RoadmapUserService {

    @Autowired
    private RoadmapUserMapper roadmapUserMapper;

    public  List<RoadmapUserEntity> page(Integer pageSize,Integer pageCount) {
        return roadmapUserMapper.page(pageSize,pageCount);
    }

    public void update(RoadmapUserEntity roadmapUserEntity) {
        roadmapUserMapper.update(roadmapUserEntity);
    }

    public int save(RoadmapUserEntity roadmapUserEntity) {
        return roadmapUserMapper.save(roadmapUserEntity);
    }

    public void remove(Integer id) {
        roadmapUserMapper.remove(id);
    }

    public int count() {
        return roadmapUserMapper.count();
    }

    public RoadmapUserEntity findOne(Integer id) {
        return roadmapUserMapper.findOne(id);
    }

    public List<RoadmapUserEntity> findAllList() {
        return roadmapUserMapper.findAllList();
    }

}





