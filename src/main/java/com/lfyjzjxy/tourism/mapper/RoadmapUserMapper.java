package com.lfyjzjxy.tourism.mapper;

import com.lfyjzjxy.tourism.entity.RoadmapUserEntity;
import com.lfyjzjxy.tourism.vo.RoadmapUserVo;
import org.apache.ibatis.annotations.*;
import java.util.List;

/**
 * RoadmapUserMapper接口
 */
@Mapper
public interface RoadmapUserMapper{

    /**
      *获取所有数据
      */
    @Select("SELECT id as id,roadmap_id as roadmapId,user_id as userId,status as status FROM `roadmap_user`")
    List<RoadmapUserEntity> findAllList();

    /**
     * 查询一条数据
     */
    @Select("SELECT id as id,roadmap_id as roadmapId,user_id as userId,status as status FROM `roadmap_user` WHERE id = #{id}")
    RoadmapUserEntity findOne(@Param("id") Integer id);


    /**
     * 添加数据
     */
    @Options(useGeneratedKeys = true, keyProperty = "id",keyColumn="id")
    @Insert("INSERT INTO  `roadmap_user` ( roadmap_id,user_id,status) VALUES(#{roadmapId},#{userId},#{status})")
    int save(RoadmapUserEntity roadmapUserEntity);

    /**
     * 分页查询数据
     */
    @Select("SELECT id as id,roadmap_id as roadmapId,user_id as userId,status as status FROM  `roadmap_user` limit #{pageSize},#{pageCount})")
    List<RoadmapUserEntity> page(@Param("pageSize") Integer pageSize, @Param("pageCount") Integer pageCount);

    /**
     * 更新数据
     */
    @Update("UPDATE `roadmap_user` set id=#{id},roadmap_id=#{roadmapId},user_id=#{userId},status=#{status} where id = #{id}")
    void update(RoadmapUserEntity roadmapUserEntity);


    /**
     * 删除数据
     */
    @Delete("DELETE FROM  `roadmap_user` where id = #{id}")
    void remove(@Param("id") Integer id);

    /**
     * 表的数据条数
     */
    @Select("SELECT COUNT(*) FROM  `roadmap_user`")
    int count();


    @Select("SELECT ru.id as id,ru.roadmap_id as roadmapId,ru.user_id as userId,ru.status as status,u.username as username,u.photo as photo " +
            " FROM `roadmap_user` ru " +
            " join `user` u on u.user_id = ru.user_id " +
            " WHERE roadmap_id = #{roadmap_id}")
    List<RoadmapUserVo> findByRoadmapId(Integer roadmapId);

    @Select("SELECT id as id,roadmap_id as roadmapId,user_id as userId,status as status FROM `roadmap_user` WHERE user_id = #{userId} and roadmap_id = #{roadmapId}")
    RoadmapUserEntity findByUserAndId(Integer userId, Integer roadmapId);

    @Update("UPDATE `roadmap_user` set status=#{status} where roadmap_id=#{roadmapId}")
    void updateRoadmap(Integer roadmapId, Integer status);
}

