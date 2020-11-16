package com.lfyjzjxy.tourism.mapper;

import com.lfyjzjxy.tourism.entity.StrategyCommentEntity;
import com.lfyjzjxy.tourism.vo.StrategyCommentVo;
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
    @Options(useGeneratedKeys = true, keyProperty = "id",keyColumn="id")
    @Insert("INSERT INTO  `strategy_comment` ( strategy_id,content,user_id,send_user_id,pid,create_time,state) VALUES(#{strategyId},#{content},#{userId},#{sendUserId},#{pid},now(),1)")
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

    @Select("SELECT sc.id as id,sc.strategy_id as strategyId,sc.content as content,sc.user_id as userId,sc.send_user_id as sendUserId,sc.pid as pid,sc.create_time as createTime,sc.state as state," +
            "(select `username` from `user` u where u.user_id = sc.user_id) as username1," +
            "(select `username` from `user` u where u.user_id = sc.send_user_id) as username2 " +
            "FROM `strategy_comment` sc " +
            "where strategy_id=#{strategyId} and sc.pid = #{pid}")
    List<StrategyCommentVo> findOneByStrategy(Integer strategyId,Integer pid);

    @Select("SELECT sc.id as id,sc.strategy_id as strategyId,sc.content as content,sc.user_id as userId,sc.send_user_id as sendUserId,sc.pid as pid,sc.create_time as createTime,sc.state as state," +
            "(select `username` from `user` u where u.user_id = sc.user_id) as username1," +
            "(select `username` from `user` u where u.user_id = sc.send_user_id) as username2 " +
            "FROM `strategy_comment` sc " +
            "where  sc.id = #{id}")
    StrategyCommentVo findOneByUsename(Integer id);
}

