package com.lfyjzjxy.tourism.service.impl;

import com.lfyjzjxy.tourism.entity.UserEntity;
import com.lfyjzjxy.tourism.mapper.UserMapper;
import com.lfyjzjxy.tourism.service.UserService;
import com.lfyjzjxy.tourism.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public  List<UserEntity> page(Integer pageSize,Integer pageCount) {
        return userMapper.page(pageSize,pageCount);
    }

    public void update(UserEntity userEntity) {
        userEntity.setPassword(MD5Util.MD5(userEntity.getPassword()));
        userMapper.update(userEntity);
    }

    public int save(UserEntity userEntity) {
        userEntity.setPassword(MD5Util.MD5(userEntity.getPassword()));
        userEntity.setStatus(1);
        return userMapper.save(userEntity);
    }

    public void remove(Integer userId) {
        userMapper.remove(userId);
    }

    public int count() {
        return userMapper.count();
    }

    public UserEntity findOne(Integer userId) {
        return userMapper.findOne(userId);
    }

    public List<UserEntity> findAllList() {
        return userMapper.findAllList();
    }

    @Override
    public UserEntity findOneUser(UserEntity userEntity) {
        userEntity.setPassword(MD5Util.MD5(userEntity.getPassword()));
        return userMapper.findOneUser(userEntity);
    }

    @Override
    public UserEntity findUsername(String username) {
        return userMapper.findUsername(username);
    }

    @Override
    public List<UserEntity> findDataTokeywordAndState(String keyword, Integer state) {
        return userMapper.findDataTokeywordAndState(keyword,state);
    }

    @Override
    public void removeAll(String ids) {
        String[] muchId = ids.split(",");
        for(int i = 0 ; i < muchId.length ; i ++){
            //逻辑删除
            userMapper.updateState(Integer.parseInt(muchId[i]),2);
        }
    }

    @Override
    public void updateState(String ids,Integer state) {
        String[] muchId = ids.split(",");
        for(int i = 0 ; i < muchId.length ; i ++){
            userMapper.updateState(Integer.parseInt(muchId[i]),state);
        }
    }

    @Override
    public void updateJurisdiction(String ids, Integer jurisdiction) {
        String[] muchId = ids.split(",");
        for(int i = 0 ; i < muchId.length ; i ++){
            userMapper.updateJurisdiction(Integer.parseInt(muchId[i]),jurisdiction);
        }
    }

}





