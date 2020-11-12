package com.lfyjzjxy.tourism.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author: Penghong Li
 * @Date: Create in 23:53 2020/11/11
 */

@Data
public class RoadmapVo {

    private String scenicSpan;

    private Integer roadmapId;

    private Integer userId;

    private String title;

    private String content;

    private Integer status;

    private Date createTime;

    private String username;

    private String photo;

    public String getStatusName(){
        if (this.status == 1){
            return "招募中";
        }else if(this.status == 2){
            return "招募结束";
        }else if(this.status == 3){
            return "旅行结束";
        }else{
            return "起草";
        }
    }
}
