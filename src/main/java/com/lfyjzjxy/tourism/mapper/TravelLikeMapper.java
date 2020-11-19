package com.lfyjzjxy.tourism.mapper;

import com.lfyjzjxy.tourism.entity.TravelLikeEntity;
import org.apache.ibatis.annotations.*;
import java.util.List;

/**
 * TravelLikeMapper接口
 */
@Mapper
public interface TravelLikeMapper{

    /**
      *获取所有数据
      */
    @Select("SELECT like_id as likeId,user_id as userId,travel_id as travelId FROM `travel_like`")
    List<TravelLikeEntity> findAllList();

    /**
     * 查询一条数据
     */
    @Select("SELECT like_id as likeId,user_id as userId,travel_id as travelId FROM `travel_like` WHERE like_id = #{likeId}")
    TravelLikeEntity findOne(@Param("likeId") Integer likeId);


    /**
     * 添加数据
     */
    @Insert("INSERT INTO  `travel_like` ( user_id,travel_id) VALUES(#{userId},#{travelId})")
    int save(TravelLikeEntity travelLikeEntity);

    /**
     * 分页查询数据
     */
    @Select("SELECT like_id as likeId,user_id as userId,travel_id as travelId FROM  `travel_like` limit #{pageSize},#{pageCount})")
    List<TravelLikeEntity> page(@Param("pageSize") Integer pageSize, @Param("pageCount") Integer pageCount);

    /**
     * 更新数据
     */
    @Update("UPDATE `travel_like` set like_id=#{likeId},user_id=#{userId},travel_id=#{travelId} where like_id = #{likeId}")
    void update(TravelLikeEntity travelLikeEntity);


    /**
     * 删除数据
     */
    @Delete("DELETE FROM  `travel_like` where like_id = #{likeId}")
    void remove(@Param("likeId") Integer likeId);

    /**
     * 表的数据条数
     */
    @Select("SELECT COUNT(*) FROM  `travel_like`")
    int count();


    @Select("SELECT like_id as likeId,user_id as userId,travel_id as travelId FROM  `travel_like` where user_id=#{userId} and travel_id=#{travelId}")
    TravelLikeEntity findOneByUserAndTravel(Integer userId, Integer travelId);
}

