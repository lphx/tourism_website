package com.lfyjzjxy.tourism.service.impl;

import com.lfyjzjxy.tourism.entity.RoadmapEntity;
import com.lfyjzjxy.tourism.entity.RoadmapScenicEntity;
import com.lfyjzjxy.tourism.entity.RoadmapUserEntity;
import com.lfyjzjxy.tourism.entity.RoadmapVo;
import com.lfyjzjxy.tourism.mapper.RoadmapMapper;
import com.lfyjzjxy.tourism.mapper.RoadmapScenicMapper;
import com.lfyjzjxy.tourism.mapper.RoadmapUserMapper;
import com.lfyjzjxy.tourism.mapper.ScenicMapper;
import com.lfyjzjxy.tourism.service.RoadmapService;
import com.lfyjzjxy.tourism.util.RequestUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@Service
public class RoadmapServiceImpl implements RoadmapService {

    @Autowired
    private RoadmapMapper roadmapMapper;

    @Autowired
    private RoadmapScenicMapper roadmapScenicMapper;

    @Autowired
    RoadmapUserMapper roadmapUserMapper;



    public  List<RoadmapEntity> page(Integer pageSize,Integer pageCount) {
        return roadmapMapper.page(pageSize,pageCount);
    }


    public int save(RoadmapVo roadmapVo, HttpServletRequest request) {
        Integer userId = RequestUtil.getSession(request).getUserId();
        RoadmapEntity roadmapEntity = new RoadmapEntity();
        BeanUtils.copyProperties(roadmapVo,roadmapEntity);
        roadmapEntity.setUserId(userId);
        roadmapMapper.save(roadmapEntity);
        String scenicSpan = roadmapVo.getScenicSpan();
        if (!StringUtils.isEmpty(scenicSpan)){
            scenicSpan = scenicSpan.substring(0,scenicSpan.length()-1);
            String[] split = scenicSpan.split(",");
            Arrays.stream(split).forEach(item ->{
                RoadmapScenicEntity roadmapScenicEntity = new RoadmapScenicEntity();
                roadmapScenicEntity.setRoadmapId(roadmapEntity.getRoadmapId());
                roadmapScenicEntity.setScenicId(Integer.parseInt(item));
                roadmapScenicMapper.save(roadmapScenicEntity);
            });
        }

        RoadmapUserEntity roadmapUserEntity = new RoadmapUserEntity();
        roadmapUserEntity.setRoadmapId(roadmapEntity.getRoadmapId());
        roadmapUserEntity.setUserId(userId);
        roadmapUserEntity.setStatus(roadmapVo.getStatus());
        roadmapUserMapper.save(roadmapUserEntity);

        return roadmapEntity.getRoadmapId();
    }

    public void remove(Integer roadmapId) {
        roadmapMapper.remove(roadmapId);
    }


    public RoadmapEntity findOne(Integer roadmapId) {
        return roadmapMapper.findOne(roadmapId);
    }


    @Override
    public void update(RoadmapVo roadmapVo, HttpServletRequest request) {
        RoadmapEntity roadmapEntity = new RoadmapEntity();
        BeanUtils.copyProperties(roadmapVo,roadmapEntity);
        roadmapEntity.setUserId(RequestUtil.getSession(request).getUserId());
        roadmapMapper.update(roadmapEntity);
        String scenicSpan = roadmapVo.getScenicSpan();
        roadmapScenicMapper.removeByRoadmapId(roadmapEntity.getRoadmapId());
        if (!StringUtils.isEmpty(scenicSpan)){
            scenicSpan = scenicSpan.substring(0,scenicSpan.length()-1);
            String[] split = scenicSpan.split(",");
            Arrays.stream(split).forEach(item ->{
                RoadmapScenicEntity roadmapScenicEntity = new RoadmapScenicEntity();
                roadmapScenicEntity.setRoadmapId(roadmapEntity.getRoadmapId());
                roadmapScenicEntity.setScenicId(Integer.parseInt(item));
                roadmapScenicMapper.save(roadmapScenicEntity);
            });
        }
        roadmapUserMapper.updateRoadmap(roadmapVo.getRoadmapId(),roadmapVo.getStatus());
    }

    @Override
    public RoadmapVo findById(Integer roadmapId) {
        return  roadmapMapper.findById(roadmapId);
    }

    @Override
    public List<RoadmapVo> findAllAndScnicList(Integer num, String keyword,Integer searchId,Integer page,Integer pageSize) {

        if (page == null){
            page = 1;
        }
        page = (page-1)*pageSize;

        if (num != null){
            if (num == 0){
                return roadmapMapper.findAllAndScnicList(null,keyword,searchId,page,pageSize);
            }
            if (num == 1){
                return roadmapMapper.findAllAndScnicList(keyword,null,searchId,page,pageSize);
            }
        }

        return roadmapMapper.findAllAndScnicList(null,null,searchId,page,pageSize);
    }

    @Override
    public List<RoadmapVo> findByUser(Integer userId) {
        return roadmapMapper.findByUser(userId);
    }


}





