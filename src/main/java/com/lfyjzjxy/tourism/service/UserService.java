package com.lfyjzjxy.tourism.service;

import com.lfyjzjxy.tourism.entity.UserEntity;
import java.util.List;

public interface UserService{

    List<UserEntity> page(Integer pageSize,Integer pageCount);
    void update(UserEntity userEntity);
    int save(UserEntity userEntity);
    void remove(Integer userId);
    int count();
    UserEntity findOne(Integer userId);
    List<UserEntity> findAllList();


    UserEntity findOneUser(UserEntity userEntity);

    UserEntity findUsername(String username);

    List<UserEntity> findDataTokeywordAndState(String keyword, Integer state);

    void removeAll(String ids);

    void updateState(String ids, Integer state);

    void updateJurisdiction(String ids, Integer jurisdiction);
}




