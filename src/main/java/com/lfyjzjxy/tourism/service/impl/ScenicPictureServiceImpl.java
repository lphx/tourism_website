package com.lfyjzjxy.tourism.service.impl;

import com.lfyjzjxy.tourism.entity.ScenicPictureEntity;
import com.lfyjzjxy.tourism.mapper.ScenicPictureMapper;
import com.lfyjzjxy.tourism.service.ScenicPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ScenicPictureServiceImpl implements ScenicPictureService {

    @Autowired
    private ScenicPictureMapper scenicPictureMapper;




    public int save(ScenicPictureEntity ScenicPictureEntity) {
        return scenicPictureMapper.save(ScenicPictureEntity);
    }

    public void remove(Integer id) {
        scenicPictureMapper.remove(id);
    }


    public ScenicPictureEntity findOne(Integer id) {
        return scenicPictureMapper.findOne(id);
    }

    public List<ScenicPictureEntity> findAllList() {
        return scenicPictureMapper.findAllList();
    }

    @Override
    public List<ScenicPictureEntity> findAllByScenicId(Integer scenicId) {
        return scenicPictureMapper.findAllByScenicId(scenicId);
    }

    @Override
    public List<ScenicPictureEntity> findAllByScenicIdLimitThree(Integer scenicId) {
        return scenicPictureMapper.findAllByScenicIdLimitThree(scenicId);
    }

}





