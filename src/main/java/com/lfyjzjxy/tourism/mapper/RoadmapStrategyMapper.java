package com.lfyjzjxy.tourism.mapper;

import com.lfyjzjxy.tourism.entity.RoadmapStrategyEntity;
import com.lfyjzjxy.tourism.entity.RoadmapVo;
import com.lfyjzjxy.tourism.vo.RoadmapStrategyVo;
import org.apache.ibatis.annotations.*;
import java.util.List;

/**
 * RoadmapStrategyMapper接口
 */
@Mapper
public interface RoadmapStrategyMapper{

    /**
      *获取所有数据
      */
    @Select("SELECT strategy_id as strategyId,user_id as userId,roadmap_id as roadmapId,title as title,content as content,head_img as headImg,price_max as priceMax,price_min as priceMin,play_day as playDay, traffic as  traffic,state as state,create_time as createTime,short_content as shortContent FROM `roadmap_strategy`")
    List<RoadmapStrategyEntity> findAllList();

    /**
     * 查询一条数据
     */
    @Select("SELECT strategy_id as strategyId,user_id as userId,roadmap_id as roadmapId,title as title,content as content,head_img as headImg,price_max as priceMax,price_min as priceMin,play_day as playDay, traffic as  traffic,state as state,create_time as createTime,short_content as shortContent FROM `roadmap_strategy` WHERE strategy_id = #{strategyId}")
    RoadmapStrategyEntity findOne(@Param("strategyId") Integer strategyId);


    /**
     * 添加数据
     */
    @Options(useGeneratedKeys = true, keyProperty = "strategyId",keyColumn="strategy_id")
    @Insert("INSERT INTO  `roadmap_strategy` ( user_id,roadmap_id,title,content,head_img,price_max,price_min,play_day, traffic,state,create_time,short_content) VALUES(#{userId},#{roadmapId},#{title},#{content},#{headImg},#{priceMax},#{priceMin},#{playDay},#{traffic},1,now(),#{shortContent})")
    int save(RoadmapStrategyEntity roadmapStrategyEntity);

    /**
     * 分页查询数据
     */
    @Select("SELECT strategy_id as strategyId,user_id as userId,roadmap_id as roadmapId,title as title,content as content,head_img as headImg,price_max as priceMax,price_min as priceMin,play_day as playDay, traffic as  traffic,state as state,create_time as createTime,short_content as shortContent FROM  `roadmap_strategy` limit #{pageSize},#{pageCount})")
    List<RoadmapStrategyEntity> page(@Param("pageSize") Integer pageSize, @Param("pageCount") Integer pageCount);

    /**
     * 更新数据
     */
    @Update("UPDATE `roadmap_strategy` set strategy_id=#{strategyId},user_id=#{userId},roadmap_id=#{roadmapId},title=#{title},content=#{content},head_img=#{headImg},price_max=#{priceMax},price_min=#{priceMin},play_day=#{playDay}, traffic=#{ traffic},short_content=#{shortContent} where strategy_id = #{strategyId}")
    void update(RoadmapStrategyEntity roadmapStrategyEntity);


    /**
     * 删除数据
     */
    @Delete("DELETE FROM  `roadmap_strategy` where strategy_id = #{strategyId}")
    void remove(@Param("strategyId") Integer strategyId);

    /**
     * 表的数据条数
     */
    @Select("SELECT COUNT(*) FROM  `roadmap_strategy`")
    int count();


    @Select("<script> "+
            "SELECT rs.strategy_id as strategyId,rs.user_id as userId,rs.roadmap_id as roadmapId,rs.title as title,rs.content as content, " +
            "rs.head_img as headImg,rs.price_max as priceMax,rs.price_min as priceMin,rs.play_day as playDay, rs.traffic as  traffic, " +
            "rs.state as state,rs.create_time as createTime ,u.username as username ,u.photo as photo,left(rs.short_content,100) as shortContent, " +
            "ifnull((select count(*) from strategy_comment sc where sc.strategy_id = rs.strategy_id ),0) as commentNum, " +
            "ifnull((select count(*) from strategy_like sl where sl.strategy_id = rs.strategy_id),0) as likeNum " +
            "FROM `roadmap_strategy` rs " +
            "join `user` u on u.user_id = rs.user_id  "+
            " where rs.state = 1 " +
            "<if test='keyword != null'> and rs.title like '%${keyword}%' </if>"+
            "<if test='roadmapIds != null'> and rs.roadmap_id  in ((select roadmap_id from roadmap_scenic where scenic_id in((SELECT scenic_id as scenicId FROM `scenic` WHERE `name` like '%${roadmapIds}%')))) </if>" +
            "<if test='searchId == 1'> order by  createTime desc</if> "+
            "<if test='searchId == 2'> order by  commentNum desc</if> " +
            "<if test='searchId == 3'> order by  likeNum desc</if> " +
            "<if test='searchId == 4'> order by  commentNum desc,likeNum desc</if> " +
            " limit #{page},#{pageSize}"+
            "</script>")
    @Results({
            @Result(id = true, column = "strategyId", property = "strategyId"),
            @Result(column = "userId", property = "userId"),
            @Result(column = "roadmapId", property = "roadmapId"),
            @Result(column = "shortContent", property = "shortContent"),
            @Result(column = "title", property = "title"),
            @Result(column = "content", property = "content"),
            @Result(column = "headImg", property = "headImg"),
            @Result(column = "priceMax", property = "priceMax"),
            @Result(column = "priceMin", property = "priceMin"),
            @Result(column = "playDay", property = "playDay"),
            @Result(column = "traffic", property = "traffic"),
            @Result(column = "status", property = "status"),
            @Result(column = "createTime", property = "createTime"),
            @Result(column = "username", property = "username"),
            @Result(column = "photo", property = "photo"),
            @Result(column = "userNum", property = "userNum"),
            @Result(column = "commentNum", property = "commentNum"),
            @Result(column = "likeNum", property = "likeNum"),
            @Result(column = "roadmapId", property = "roadmapScenicList", many = @Many(select = "com.lfyjzjxy.tourism.mapper.RoadmapScenicMapper.findByRoadmapId"))
    })
    List<RoadmapStrategyVo> findAllAndScenicAndCommentAmdLikeList(String roadmapIds,String keyword,Integer searchId,Integer page,Integer pageSize);
}

