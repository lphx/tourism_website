package com.lfyjzjxy.tourism.mapper;

import com.lfyjzjxy.tourism.entity.ScenicEntity;
import org.apache.ibatis.annotations.*;
import java.util.List;

/**
 * ScenicMapper接口
 */
@Mapper
public interface ScenicMapper{

    /**
      *获取所有数据
      */
    @Select("SELECT scenic_id as scenicId,name as name,picture as picture,content as content,province_id as provinceId,city_id as cityId FROM `scenic`")
    List<ScenicEntity> findAllList();

    /**
     * 查询一条数据
     */
    @Select("SELECT scenic_id as scenicId,name as name,picture as picture,content as content,province_id as provinceId,city_id as cityIdFROM `scenic` WHERE scenic_id = #{scenicId}")
    ScenicEntity findOne(@Param("scenicId") Integer scenicId);


    @Options(useGeneratedKeys = true, keyProperty = "scenicId",keyColumn="scenic_id")
    @Insert("INSERT INTO  `scenic` ( name,picture,content,province_id,city_id) VALUES(#{name},#{picture},#{content},#{provinceId},#{cityId})")
    Integer  save(ScenicEntity scenicEntity);

    /**
     * 分页查询数据
     */
    @Select("SELECT scenic_id as scenicId,name as name,picture as picture,content as content,province_id as provinceId,city_id as cityId FROM  `scenic` limit #{pageSize},#{pageCount})")
    List<ScenicEntity> page(@Param("pageSize") Integer pageSize, @Param("pageCount") Integer pageCount);

    /**
     * 更新数据
     */
    @Update("UPDATE `scenic` set scenic_id=#{scenicId},name=#{name},picture=#{picture},content=#{content},province_id=#{provinceId},city_id=#{cityId} where scenic_id = #{scenicId}")
    void update(ScenicEntity scenicEntity);


    /**
     * 删除数据
     */
    @Delete("DELETE FROM  `scenic` where scenic_id = #{scenicId}")
    void remove(@Param("scenicId") Integer scenicId);

            /**
             * 表的数据条数
             */
    @Select("SELECT COUNT(*) FROM  `scenic`")
    int count();


}

