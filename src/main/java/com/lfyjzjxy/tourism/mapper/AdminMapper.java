package com.lfyjzjxy.tourism.mapper;

import com.lfyjzjxy.tourism.entity.AdminEntity;
import org.apache.ibatis.annotations.*;
import java.util.List;

/**
 * AdminMapper接口
 */
@Mapper
public interface AdminMapper{

    /**
      *获取所有数据
      */
    @Select("SELECT admin_id as adminId,username as username,password as password,create_time as createTime,status as status FROM `admin`")
    List<AdminEntity> findAllList();

    /**
     * 查询一条数据
     */
    @Select("SELECT admin_id as adminId,username as username,password as password,create_time as createTime,status as status FROM `admin` WHERE admin_id = #{adminId}")
    AdminEntity findOne(@Param("adminId") Integer adminId);


            /**
             * 添加数据
             */
    @Insert("INSERT INTO  `admin` (admin_id,username,password,create_time,status) VALUES(#{adminId},#{username},#{password},#{createTime},#{status})")
    int save(AdminEntity adminEntity);


    void remove(Integer adminId);

    @Select("SELECT admin_id as adminId,username as username,password as password,create_time as createTime,status as status " +
            "FROM `admin` WHERE username = #{username} and password =#{password} ")
    AdminEntity findByUsernamAndPassword(AdminEntity adminEntity);
}

