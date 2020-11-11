package com.lfyjzjxy.tourism.mapper;

import com.lfyjzjxy.tourism.entity.RoadmapScenicEntity;
import org.apache.ibatis.annotations.*;
import java.util.List;

/**
 * RoadmapScenicMapper接口
 */
@Mapper
public interface RoadmapScenicMapper{

    /**
      *获取所有数据
      */
    @Select("SELECT id as id,roadmap_id as roadmapId,scenic_id as scenicId FROM `roadmap_scenic`")
    List<RoadmapScenicEntity> findAllList();

    /**
     * 查询一条数据
     */
    @Select("SELECT id as id,roadmap_id as roadmapId,scenic_id as scenicId FROM `roadmap_scenic` WHERE id = #{id}")
    RoadmapScenicEntity findOne(@Param("id") Integer id);


    /**
     * 添加数据
     */
    @Insert("INSERT INTO  `roadmap_scenic` ( id,roadmap_id,scenic_id) VALUES(#{id},#{roadmapId},#{scenicId})")
    int save(RoadmapScenicEntity roadmapScenicEntity);

    /**
     * 分页查询数据
     */
    @Select("SELECT id as id,roadmap_id as roadmapId,scenic_id as scenicId FROM  `roadmap_scenic` limit #{pageSize},#{pageCount})")
    List<RoadmapScenicEntity> page(@Param("pageSize") Integer pageSize, @Param("pageCount") Integer pageCount);

    /**
     * 更新数据
     */
    @Update("UPDATE `roadmap_scenic` set id=#{id},roadmap_id=#{roadmapId},scenic_id=#{scenicId} where id = #{id}")
    void update(RoadmapScenicEntity roadmapScenicEntity);


    /**
     * 删除数据
     */
    @Delete("DELETE FROM  `roadmap_scenic` where id = #{id}")
    void remove(@Param("id") Integer id);

    /**
     * 表的数据条数
     */
    @Select("SELECT COUNT(*) FROM  `roadmap_scenic`")
    int count();


}

