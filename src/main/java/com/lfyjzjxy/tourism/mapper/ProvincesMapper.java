package com.lfyjzjxy.tourism.mapper;

import com.lfyjzjxy.tourism.entity.ProvincesEntity;
import org.apache.ibatis.annotations.*;
import java.util.List;

/**
 * ProvincesMapper接口
 */
@Mapper
public interface ProvincesMapper{

    /**
      *获取所有数据
      */
    @Select("SELECT id as id,pid as pid,name as name,cid as cid FROM `provinces`")
    List<ProvincesEntity> findAllList();

    /**
     * 查询一条数据
     */
    @Select("SELECT id as id,pid as pid,name as name,cid as cid FROM `provinces` WHERE id = #{id}")
    ProvincesEntity findOne(@Param("id") Integer id);


    /**
     * 添加数据
     */
    @Insert("INSERT INTO  `provinces` ( id,pid,name,cid) VALUES(#{id},#{pid},#{name},#{cid})")
    int save(ProvincesEntity provincesEntity);

    /**
     * 分页查询数据
     */
    @Select("SELECT id as id,pid as pid,name as name,cid as cid FROM  `provinces` limit #{pageSize},#{pageCount})")
    List<ProvincesEntity> page(@Param("pageSize") Integer pageSize, @Param("pageCount") Integer pageCount);

    /**
     * 更新数据
     */
    @Update("UPDATE `provinces` set id=#{id},pid=#{pid},name=#{name},cid=#{cid} where id = #{id}")
    void update(ProvincesEntity provincesEntity);


    /**
     * 删除数据
     */
    @Delete("DELETE FROM  `provinces` where id = #{id}")
    void remove(@Param("id") Integer id);

    /**
     * 表的数据条数
     */
    @Select("SELECT COUNT(*) FROM  `provinces`")
    int count();


    @Select("SELECT id as id,pid as pid,name as name,cid as cid FROM `provinces` WHERE cid = #{pid}")
    List<ProvincesEntity> findCidByPid(Integer pid);

    @Select("SELECT id as id,pid as pid,name as name,cid as cid FROM `provinces` WHERE pid = 0")
    List<ProvincesEntity> findPid();
}

