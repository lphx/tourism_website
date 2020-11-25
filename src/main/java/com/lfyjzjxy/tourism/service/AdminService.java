package com.lfyjzjxy.tourism.service;

import com.lfyjzjxy.tourism.entity.AdminEntity;
import java.util.List;

public interface AdminService{

   /* List<AdminEntity> page(Integer pageSize, Integer pageCount);
    void update(AdminEntity adminEntity);*/
    int save(AdminEntity adminEntity);
    void remove(Integer adminId);
    AdminEntity findOne(Integer adminId);
    List<AdminEntity> findAllList();


    AdminEntity findByUsernamAndPassword(AdminEntity adminEntity);
}




