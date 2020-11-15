package com.lfyjzjxy.tourism.mapper;

import com.lfyjzjxy.tourism.entity.StrategyLikeEntity;
import org.apache.ibatis.annotations.*;
import java.util.List;

/**
 * StrategyLikeMapper接口
 */
@Mapper
public interface StrategyLikeMapper{

    /**
      *获取所有数据
      */
    @Select("SELECT id as id,strategy_id as strategyId,user_id as userId FROM `strategy_like`")
    List<StrategyLikeEntity> findAllList();

    /**
     * 查询一条数据
     */
    @Select("SELECT id as id,strategy_id as strategyId,user_id as userId FROM `strategy_like` WHERE id = #{id}")
    StrategyLikeEntity findOne(@Param("id") Integer id);


    /**
     * 添加数据
     */
    @Insert("INSERT INTO  `strategy_like` ( id,strategy_id,user_id) VALUES(#{id},#{strategyId},#{userId})")
    int save(StrategyLikeEntity strategyLikeEntity);

    /**
     * 分页查询数据
     */
    @Select("SELECT id as id,strategy_id as strategyId,user_id as userId FROM  `strategy_like` limit #{pageSize},#{pageCount})")
    List<StrategyLikeEntity> page(@Param("pageSize") Integer pageSize, @Param("pageCount") Integer pageCount);

    /**
     * 更新数据
     */
    @Update("UPDATE `strategy_like` set id=#{id},strategy_id=#{strategyId},user_id=#{userId} where id = #{id}")
    void update(StrategyLikeEntity strategyLikeEntity);


    /**
     * 删除数据
     */
    @Delete("DELETE FROM  `strategy_like` where id = #{id}")
    void remove(@Param("id") Integer id);

    /**
     * 表的数据条数
     */
    @Select("SELECT COUNT(*) FROM  `strategy_like`")
    int count();


}

