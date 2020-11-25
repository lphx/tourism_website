package com.lfyjzjxy.tourism.mapper;

import com.lfyjzjxy.tourism.entity.ScenicEntity;
import com.lfyjzjxy.tourism.entity.ScenicVo;
import com.lfyjzjxy.tourism.entity.UserEntity;
import org.apache.ibatis.annotations.*;
import java.util.List;

/**
 * ScenicMapper接口
 */
@Mapper
public interface ScenicMapper{

    /**
      *获取所有数据
      */
    @Select("SELECT scenic_id as scenicId,name as name,user_id as userId,content as content,province_id as provinceId,city_id as cityId FROM `scenic` where and status = 1")
    List<ScenicEntity> findAllList();

    /**
     * 查询一条数据
     */
    @Select("SELECT scenic_id as scenicId,name as name,user_id as userId,content as content,province_id as provinceId,city_id as cityId FROM `scenic` WHERE scenic_id = #{scenicId} and status = 1")
    ScenicEntity findOne(@Param("scenicId") Integer scenicId);


    @Options(useGeneratedKeys = true, keyProperty = "scenicId",keyColumn="scenic_id")
    @Insert("INSERT INTO  `scenic` ( name,user_id,content,province_id,city_id,status) VALUES(#{name},#{userId},#{content},#{provinceId},#{cityId},1)")
    Integer  save(ScenicEntity scenicEntity);

    /**
     * 分页查询数据
     */
    @Select("SELECT scenic_id as scenicId,name as name,user_id as userId,content as content,province_id as provinceId,city_id as cityId FROM  `scenic` limit #{pageSize},#{pageCount})")
    List<ScenicEntity> page(@Param("pageSize") Integer pageSize, @Param("pageCount") Integer pageCount);

    /**
     * 更新数据
     */
    @Update("UPDATE `scenic` set scenic_id=#{scenicId},name=#{name},user_id=#{userId},content=#{content},province_id=#{provinceId},city_id=#{cityId} where scenic_id = #{scenicId}")
    void update(ScenicEntity scenicEntity);


    /**
     * 删除数据
     */
    @Delete("DELETE FROM  `scenic` where scenic_id = #{scenicId}")
    void remove(@Param("scenicId") Integer scenicId);

            /**
             * 表的数据条数
             */
    @Select("SELECT COUNT(*) FROM  `scenic`")
    int count();


    @Select("SELECT scenic_id as scenicId,name as name,user_id as userId,content as content,province_id as provinceId,city_id as cityId FROM `scenic` WHERE scenic_id = #{scenicId} and user_id=#{userId} and status = 1")
    ScenicEntity findUserId(Integer userId, Integer scenicId);

    @Select("<script> "+
            " SELECT c.scenic_id as scenicId,`name` as `name`,user_id as userId,content as content,province_id as provinceId,city_id as cityId , " +
            " (select img from scenic_picture p where p.scenic_id = c.scenic_id limit 0,1) as img " +
            " FROM `scenic` c  WHERE   `name` like '%${keyword}%' and c.status = 1 " +
            "<if test='provinceId != null'>and province_id = #{provinceId} </if>" +
            "<if test='cityId != null'>and city_id  = #{cityId} </if>"+
            "</script>")
    List<ScenicVo> findKeywordAndProvince(@Param("keyword")String keyword,@Param("provinceId")Integer provinceId,@Param("cityId")Integer cityId);

    @Select("<script> "+
            " SELECT scenic_id as scenicId,`name` as `name`,user_id as userId,content as content,province_id as provinceId,city_id as cityId  " +
            " FROM `scenic`  WHERE    province_id = #{pid} and status = 1 " +
            "<if test='cid != null'> or city_id  = #{cid} </if>"+
            "</script>")
    List<ScenicEntity> findScenicByProvince(@Param("pid")Integer pid,@Param("cid") Integer cid);

    @Select("SELECT scenic_id as scenicId FROM `scenic` WHERE `name` like '%${keyword}%' and status = 1")
    List<Integer> findLikeName(String keyword);

    @Select("<script>" +
            "SELECT scenic_id as scenicId,name as name,user_id as userId,left(content,100) as content,province_id as provinceId,city_id as cityId,status as status " +
            "FROM `scenic` WHERE   `name` like '%${keyword}%'" +
            "<if test='status != null'> and status in(#{status}) </if> " +
            "</script>")
    List<ScenicEntity> findDataTokeywordAndStatus(@Param("keyword") String keyword, @Param("status") Integer status);

    @Update("UPDATE `scenic` set status=#{status} where scenic_id = #{scenicId}")
    void updateState(int scenicId, Integer status);

}

