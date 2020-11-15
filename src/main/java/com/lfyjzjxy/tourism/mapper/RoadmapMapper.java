package com.lfyjzjxy.tourism.mapper;

import com.lfyjzjxy.tourism.entity.RoadmapEntity;
import com.lfyjzjxy.tourism.entity.RoadmapVo;
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
    @Select("<script> "+
            " SELECT rp.roadmap_id as roadmapId,rp.user_id as userId,rp.title as title,left(rp.content,100) as content,rp.`status` as `status`,rp.create_time as createTime,picture as picture,u.username as username,u.photo as photo ,ifnull((select count(*) from roadmap_user ru where ru.roadmap_id = rp.roadmap_id),0) as userNum " +
            " FROM `roadmap` rp " +
            " join `user` u on u.user_id = rp.user_id " +
            " where rp.status in(1,2) " +
            "<if test='keyword != null'> and title like '%${keyword}%' </if>"+
            "<if test='roadmapIds != null'> and rp.roadmap_id  in ((select roadmap_id from roadmap_scenic where scenic_id in((SELECT scenic_id as scenicId FROM `scenic` WHERE `name` like '%${roadmapIds}%')))) </if>" +
            "<if test='searchId == 1'> order by  createTime desc</if> "+
            "<if test='searchId == 2'> order by  userNum desc</if> " +
            " limit #{page},#{pageSize}"+
            "</script>")
    @Results({
            @Result(id = true, column = "roadmapId", property = "roadmapId"),
            @Result(column = "userId", property = "userId"),
            @Result(column = "title", property = "title"),
            @Result(column = "content", property = "content"),
            @Result(column = "status", property = "status"),
            @Result(column = "createTime", property = "createTime"),
            @Result(column = "picture", property = "picture"),
            @Result(column = "username", property = "username"),
            @Result(column = "photo", property = "photo"),
            @Result(column = "userNum", property = "userNum"),
            @Result(column = "roadmapId", property = "roadmapScenicList", many = @Many(select = "com.lfyjzjxy.tourism.mapper.RoadmapScenicMapper.findByRoadmapId"))
    })
    List<RoadmapVo> findAllAndScnicList(String roadmapIds,String keyword,Integer searchId,Integer page,Integer pageSize);

    /**
     * 查询一条数据
     */
    @Select("SELECT roadmap_id as roadmapId,user_id as userId,title as title,content as content,status as status,create_time as createTime,picture as picture FROM `roadmap` WHERE roadmap_id = #{roadmapId}")
    RoadmapEntity findOne(@Param("roadmapId") Integer roadmapId);


    /**
     * 添加数据
     */
    @Options(useGeneratedKeys = true, keyProperty = "roadmapId",keyColumn="roadmap_id")
    @Insert("INSERT INTO  `roadmap` ( user_id,title,content,status,create_time,picture) VALUES(#{userId},#{title},#{content},#{status},now(),#{picture})")
    int save(RoadmapEntity roadmapEntity);

    /**
     * 分页查询数据
     */
    @Select("SELECT roadmap_id as roadmapId,user_id as userId,title as title,content as content,status as status,create_time as createTime,picture as picture FROM  `roadmap` limit #{pageSize},#{pageCount})")
    List<RoadmapEntity> page(@Param("pageSize") Integer pageSize, @Param("pageCount") Integer pageCount);

    /**
     * 更新数据
     */
    @Update("UPDATE `roadmap` set roadmap_id=#{roadmapId},user_id=#{userId},title=#{title},content=#{content},status=#{status},picture=#{picture} where roadmap_id = #{roadmapId}")
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


    @Select("SELECT rp.roadmap_id as roadmapId,rp.user_id as userId,rp.title as title,rp.content as content,rp.status as status,rp.create_time as createTime,picture as picture,u.username as username,u.photo as photo  " +
            " FROM `roadmap` rp " +
            " join `user` u on u.user_id = rp.user_id " +
            " WHERE roadmap_id = #{roadmapId}")
    RoadmapVo findById(Integer roadmapId);


}

