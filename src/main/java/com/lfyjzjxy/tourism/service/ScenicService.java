package com.lfyjzjxy.tourism.service;

import com.lfyjzjxy.tourism.entity.ScenicEntity;
import com.lfyjzjxy.tourism.entity.ScenicVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ScenicService{

    List<ScenicEntity> page(Integer pageSize, Integer pageCount);
    void update(ScenicEntity scenicEntity);
    int save(ScenicEntity scenicEntity, HttpServletRequest request);
    void remove(Integer scenicId);
    ScenicEntity findOne(Integer scenicId);
    List<ScenicEntity> findAllList();


    ScenicEntity findUserId(Integer userId, Integer scenicId);

    List<ScenicVo> findKeywordAndProvince(String keyword, Integer provinceId, Integer cityId);

    List<ScenicEntity> findScenicByProvince(Integer pid, Integer cid);

    void removeAll(String ids);

    void updateState(String ids, Integer status);

    List<ScenicEntity> findDataTokeywordAndStatus(String keyword, Integer status);
}




