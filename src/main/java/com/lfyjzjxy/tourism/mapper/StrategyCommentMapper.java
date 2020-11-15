package com.lfyjzjxy.tourism.mapper;

import com.lfyjzjxy.tourism.entity.StrategyCommentEntity;
import org.apache.ibatis.annotations.*;
import java.util.List;

/**
 * StrategyCommentMapper接口
 */
@Mapper
public interface StrategyCommentMapper{

    /**
      *获取所有数据
      */
    @Select("SELECT id as id,strategy_id as strategyId,content as content,user_id as userId,send_user_id as sendUserId,pid as pid,create_time as createTime,state as state FROM `strategy_comment`")
    List<StrategyCommentEntity> findAllList();

    /**
     * 查询一条数据
     */
    @Select("SELECT id as id,strategy_id as strategyId,content as content,user_id as userId,send_user_id as sendUserId,pid as pid,create_time as createTime,state as state FROM `strategy_comment` WHERE id = #{id}")
    StrategyCommentEntity findOne(@Param("id") Integer id);


    /**
     * 添加数据
     */
    @Insert("INSERT INTO  `strategy_comment` ( id,strategy_id,content,user_id,send_user_id,pid,create_time,state) VALUES(#{id},#{strategyId},#{content},#{userId},#{sendUserId},#{pid},#{createTime},#{state})")
    int save(StrategyCommentEntity strategyCommentEntity);

    /**
     * 分页查询数据
     */
    @Select("SELECT id as id,strategy_id as strategyId,content as content,user_id as userId,send_user_id as sendUserId,pid as pid,create_time as createTime,state as state FROM  `strategy_comment` limit #{pageSize},#{pageCount})")
    List<StrategyCommentEntity> page(@Param("pageSize") Integer pageSize, @Param("pageCount") Integer pageCount);

    /**
     * 更新数据
     */
    @Update("UPDATE `strategy_comment` set id=#{id},strategy_id=#{strategyId},content=#{content},user_id=#{userId},send_user_id=#{sendUserId},pid=#{pid},create_time=#{createTime},state=#{state} where id = #{id}")
    void update(StrategyCommentEntity strategyCommentEntity);


    /**
     * 删除数据
     */
    @Delete("DELETE FROM  `strategy_comment` where id = #{id}")
    void remove(@Param("id") Integer id);

    /**
     * 表的数据条数
     */
    @Select("SELECT COUNT(*) FROM  `strategy_comment`")
    int count();


}

