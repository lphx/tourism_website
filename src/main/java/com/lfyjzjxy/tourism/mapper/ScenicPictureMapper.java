package com.lfyjzjxy.tourism.mapper;

import com.lfyjzjxy.tourism.entity.ScenicPictureEntity;
import org.apache.ibatis.annotations.*;
import java.util.List;

/**
 * ScenicPictrueMapper接口
 */
@Mapper
public interface ScenicPictureMapper {

    /**
      *获取所有数据
      */
    @Select("SELECT id as id,img as img,scenic_id as scenicId,status as status FROM `scenic_picture`")
    List<ScenicPictureEntity> findAllList();

    /**
     * 查询一条数据
     */
    @Select("SELECT id as id,img as img,scenic_id as scenicId,status as status FROM `scenic_picture` WHERE id = #{id}")
    ScenicPictureEntity findOne(@Param("id") Integer id);


    /**
     * 添加数据
     */
    @Insert("INSERT INTO  `scenic_picture` (img,scenic_id,status) VALUES(#{img},#{scenicId},#{status})")
    int save(ScenicPictureEntity scenicPictrueEntity);

    /**
     * 分页查询数据
     */
    @Select("SELECT id as id,img as img,scenic_id as scenicId,status as status FROM  `scenic_picture` limit #{pageSize},#{pageCount})")
    List<ScenicPictureEntity> page(@Param("pageSize") Integer pageSize, @Param("pageCount") Integer pageCount);


    /**
     * 删除数据
     */
    @Delete("DELETE FROM  `scenic_picture` where id = #{id}")
    void remove(@Param("id") Integer id);



}

