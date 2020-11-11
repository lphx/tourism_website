package com.lfyjzjxy.tourism.mapper;

import com.lfyjzjxy.tourism.entity.RoadmapEntity;
import org.apache.ibatis.annotations.*;
import java.util.List;

/**
 * RoadmapMapper接口
 */
@Mapper
public interface RoadmapMapper{

    /**
      *获取所有数据
      */
    @Select("SELECT roadmap_id as roadmapId,user_id as userId,title as title,content as content,status as status,create_time as createTime FROM `roadmap`")
    List<RoadmapEntity> findAllList();

    /**
     * 查询一条数据
     */
    @Select("SELECT roadmap_id as roadmapId,user_id as userId,title as title,content as content,status as status,create_time as createTime FROM `roadmap` WHERE roadmap_id = #{roadmapId}")
    RoadmapEntity findOne(@Param("roadmapId") Integer roadmapId);


    /**
     * 添加数据
     */
    @Options(useGeneratedKeys = true, keyProperty = "roadmapId",keyColumn="roadmap_id")
    @Insert("INSERT INTO  `roadmap` ( user_id,title,content,status,create_time) VALUES(#{userId},#{title},#{content},#{status},#{createTime})")
    int save(RoadmapEntity roadmapEntity);

    /**
     * 分页查询数据
     */
    @Select("SELECT roadmap_id as roadmapId,user_id as userId,title as title,content as content,status as status,create_time as createTime FROM  `roadmap` limit #{pageSize},#{pageCount})")
    List<RoadmapEntity> page(@Param("pageSize") Integer pageSize, @Param("pageCount") Integer pageCount);

    /**
     * 更新数据
     */
    @Update("UPDATE `roadmap` set roadmap_id=#{roadmapId},user_id=#{userId},title=#{title},content=#{content},status=#{status},create_time=#{createTime} where roadmap_id = #{roadmapId}")
    void update(RoadmapEntity roadmapEntity);


    /**
     * 删除数据
     */
    @Delete("DELETE FROM  `roadmap` where roadmap_id = #{roadmapId}")
    void remove(@Param("roadmapId") Integer roadmapId);

    /**
     * 表的数据条数
     */
    @Select("SELECT COUNT(*) FROM  `roadmap`")
    int count();


}

