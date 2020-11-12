package com.lfyjzjxy.tourism.mapper;

import com.lfyjzjxy.tourism.entity.UserEntity;
import org.apache.ibatis.annotations.*;
import java.util.List;

/**
 * UserMapper接口
 */
@Mapper
public interface UserMapper{

    /**
     *获取所有数据
     */
    @Select("SELECT user_id as userId,username as username,password as password,status as status , jurisdiction as jurisdiction,create_time as createTimeid,photo as photo FROM `user`")
    List<UserEntity> findAllList();

    /**
     * 查询一条数据
     */
    @Select("SELECT user_id as userId,username as username,password as password,status as status , jurisdiction as jurisdiction,create_time as createTime,photo as photo FROM `user` WHERE user_id = #{userId}")
    UserEntity findOne(@Param("userId") Integer userId);


    /**
     * 添加数据
     */
    @Insert("INSERT INTO  `user` ( username,password,status,jurisdiction,create_time) VALUES(#{username},#{password},#{status},#{jurisdiction},now())")
    int save(UserEntity userEntity);

    /**
     * 分页查询数据
     */
    @Select("SELECT user_id as userId,username as username,password as password,status as status , jurisdiction as jurisdiction,create_time as createTime,photo as photo FROM  `user` limit #{pageSize},#{pageCount})")
    List<UserEntity> page(@Param("pageSize")Integer pageSize,@Param("pageCount")Integer pageCount);

    /**
     * 更新数据
     */
    @Update("UPDATE `user` set password=#{password} where username=#{username}")
    void update(UserEntity userEntity);


    /**
     * 删除数据
     */
    @Delete("DELETE FROM  `user` where user_id = #{userId}")
    void remove(@Param("userId") Integer userId);

    /**
     * 表的数据条数
     */
    @Select("SELECT COUNT(*) FROM  `user`")
    int count();

    @Select("SELECT user_id as userId,username as username,password as password,status as status,photo as photo , jurisdiction as jurisdiction,create_time as createTime FROM `user` WHERE username = #{username} and password = #{password}")
    UserEntity findOneUser(UserEntity userEntity);

    @Select("SELECT user_id as userId,username as username,password as password,status as status ,photo as photo, jurisdiction as jurisdiction,create_time as createTime FROM  `user` where username = #{username} ")
    UserEntity findUsername(String username);
}

