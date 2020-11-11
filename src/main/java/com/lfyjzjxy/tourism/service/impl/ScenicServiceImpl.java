package com.lfyjzjxy.tourism.service.impl;


import com.lfyjzjxy.tourism.entity.ProvincesEntity;
import com.lfyjzjxy.tourism.entity.ScenicEntity;
import com.lfyjzjxy.tourism.entity.ScenicPictureEntity;
import com.lfyjzjxy.tourism.entity.ScenicVo;
import com.lfyjzjxy.tourism.mapper.ProvincesMapper;
import com.lfyjzjxy.tourism.mapper.ScenicMapper;
import com.lfyjzjxy.tourism.mapper.ScenicPictureMapper;
import com.lfyjzjxy.tourism.service.ScenicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class ScenicServiceImpl implements ScenicService {

    @Autowired
    private ScenicMapper scenicMapper;

    @Autowired
    private ScenicPictureMapper scenicPictureMapper;

    @Autowired
    ProvincesMapper provincesMapper;

    public  List<ScenicEntity> page(Integer pageSize, Integer pageCount) {
        return scenicMapper.page(pageSize,pageCount);
    }

    public void update(ScenicEntity scenicEntity) {
        scenicMapper.update(scenicEntity);
    }

    public int save(ScenicEntity scenicEntity, HttpServletRequest request) {
        //保存景点数据
        scenicMapper.save(scenicEntity);
        Integer scenicId = scenicEntity.getScenicId();
        //从session取出来保存景点图片
        HttpSession session = request.getSession();
        List<String> list = (List<String>)session.getAttribute("scenic");
        if (null != list && list.size()>0){
           for(String img : list){
               if (img.equals("continue")){
                   continue;
               }
               ScenicPictureEntity scenicPicture = new ScenicPictureEntity();
               scenicPicture.setImg(img);
               scenicPicture.setScenicId(scenicId);
               scenicPictureMapper.save(scenicPicture);
           }
        }
        return scenicId;
    }

    public void remove(Integer scenicId) {
        scenicMapper.remove(scenicId);
    }


    public ScenicEntity findOne(Integer scenicId) {
        return scenicMapper.findOne(scenicId);
    }

    public List<ScenicEntity> findAllList() {
        return scenicMapper.findAllList();
    }

    @Override
    public ScenicEntity findUserId(Integer userId, Integer scenicId) {
        return scenicMapper.findUserId(userId,scenicId);
    }

    @Override
    public List<ScenicVo> findKeywordAndProvince(String keyword, Integer provinceId, Integer cityId) {

        return scenicMapper.findKeywordAndProvince(keyword,provinceId,cityId);
    }

    @Override
    public List<ScenicEntity> findScenicByProvince(Integer pid, Integer cid) {
        if (pid == null){
            ProvincesEntity pidByCid = provincesMapper.findPidByCid(cid);
            pid = pidByCid.getPid();
        }
        return scenicMapper.findScenicByProvince(pid,cid);
    }

}





