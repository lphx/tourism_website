package com.lfyjzjxy.tourism.service.impl;

import com.lfyjzjxy.tourism.entity.AdminEntity;
import com.lfyjzjxy.tourism.mapper.AdminMapper;
import com.lfyjzjxy.tourism.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;




    public int save(AdminEntity adminEntity) {
        return adminMapper.save(adminEntity);
    }

    public void remove(Integer adminId) {
        adminMapper.remove(adminId);
    }



    public AdminEntity findOne(Integer adminId) {
        return adminMapper.findOne(adminId);
    }

    public List<AdminEntity> findAllList() {
        return adminMapper.findAllList();
    }

    @Override
    public AdminEntity findByUsernamAndPassword(AdminEntity adminEntity) {
        return adminMapper.findByUsernamAndPassword(adminEntity);
    }




}





