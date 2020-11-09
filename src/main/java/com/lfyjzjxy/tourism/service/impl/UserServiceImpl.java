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

}





