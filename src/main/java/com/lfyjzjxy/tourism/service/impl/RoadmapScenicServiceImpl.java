package com.lfyjzjxy.tourism.service.impl;

import com.lfyjzjxy.tourism.entity.RoadmapScenicEntity;
import com.lfyjzjxy.tourism.mapper.RoadmapScenicMapper;
import com.lfyjzjxy.tourism.service.RoadmapScenicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoadmapScenicServiceImpl implements RoadmapScenicService {

    @Autowired
    private RoadmapScenicMapper roadmapScenicMapper;

    public  List<RoadmapScenicEntity> page(Integer pageSize,Integer pageCount) {
        return roadmapScenicMapper.page(pageSize,pageCount);
    }

    public void update(RoadmapScenicEntity roadmapScenicEntity) {
        roadmapScenicMapper.update(roadmapScenicEntity);
    }

    public int save(RoadmapScenicEntity roadmapScenicEntity) {
        return roadmapScenicMapper.save(roadmapScenicEntity);
    }

    public void remove(Integer id) {
        roadmapScenicMapper.remove(id);
    }

    public int count() {
        return roadmapScenicMapper.count();
    }

    public RoadmapScenicEntity findOne(Integer id) {
        return roadmapScenicMapper.findOne(id);
    }

    public List<RoadmapScenicEntity> findAllList() {
        return roadmapScenicMapper.findAllList();
    }

}





