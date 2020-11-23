package com.lfyjzjxy.tourism.mapper;

import com.lfyjzjxy.tourism.entity.TravelEntity;
import com.lfyjzjxy.tourism.vo.TravelVo;
import org.apache.ibatis.annotations.*;
import java.util.List;

/**
 * TravelMapper接口
 */
@Mapper
public interface TravelMapper{

    /**
      *获取所有数据
      */
    @Select("SELECT travel_id as travelId,user_id as userId,title as title,picture as picture,content as content,shortContent as shortContent,create_time as createTime,update_time as updateTime,status as status FROM `travel`")
    List<TravelEntity> findAllList();

    /**
     * 查询一条数据
     */
    @Select("SELECT travel_id as travelId,user_id as userId,title as title,picture as picture,content as content,shortContent as shortContent,create_time as createTime,update_time as updateTime,status as status FROM `travel` WHERE travel_id = #{travelId}")
    TravelEntity findOne(@Param("travelId") Integer travelId);


    /**
     * 添加数据
     */
    @Options(useGeneratedKeys = true, keyProperty = "travelId",keyColumn="travel_id")
    @Insert("INSERT INTO  `travel` ( user_id,title,picture,content,shortContent,create_time,update_time,status) VALUES(#{userId},#{title},#{picture},#{content},#{shortContent},now(),#{updateTime},1)")
    int save(TravelEntity travelEntity);

    /**
     * 分页查询数据
     */
    @Select("SELECT travel_id as travelId,user_id as userId,title as title,picture as picture,content as content,shortContent as shortContent,create_time as createTime,update_time as updateTime,status as status FROM  `travel` limit #{pageSize},#{pageCount})")
    List<TravelEntity> page(@Param("pageSize") Integer pageSize, @Param("pageCount") Integer pageCount);

    /**
     * 更新数据
     */
    @Update("UPDATE `travel` set travel_id=#{travelId},user_id=#{userId},title=#{title},picture=#{picture},content=#{content},shortContent=#{shortContent},update_time=now() where travel_id = #{travelId}")
    void update(TravelEntity travelEntity);


    /**
     * 删除数据
     */
    @Delete("DELETE FROM  `travel` where travel_id = #{travelId}")
    void remove(@Param("travelId") Integer travelId);

    /**
     * 表的数据条数
     */
    @Select("SELECT COUNT(*) FROM  `travel`")
    int count();

    @Select("<script> "+
            "SELECT t.travel_id as travelId,t.user_id as userId,t.title as title,t.picture as picture,t.content as content,left(t.shortContent,100) as shortContent,t.create_time as createTime,t.update_time as updateTime,t.status as status," +
            "(select count(*) from travel_like tl where tl.travel_id = t.travel_id  ) as likeNum  ," +
            "u.username as username,u.photo as photo " +
            " FROM `travel` t " +
            " join `user` u on u.user_id = t.user_id " +
            "WHERE t.title like '%${keyword}%' and t.status =1 " +
            "<if test='num == 1'> order by  createTime desc</if> "+
            "<if test='num == 2'> order by  LikeNum desc</if> "+
            "</script> ")
    List<TravelVo> findAllListBySearch(String keyword, Integer num);

    @Select( "SELECT t.travel_id as travelId,t.user_id as userId,t.title as title,t.picture as picture,t.content as content,left(t.shortContent,100) as shortContent,t.create_time as createTime,t.update_time as updateTime,t.status as status," +
            "(select count(*) from travel_like tl where tl.travel_id = t.travel_id  ) as likeNum  ," +
            "u.username as username,u.photo as photo " +
            " FROM `travel` t " +
            " join `user` u on u.user_id = t.user_id " +
            "WHERE t.user_id = #{userId} and t.status =1  ")
    List<TravelVo> findAllListByUser(Integer userId);
}

