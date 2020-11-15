package com.lfyjzjxy.tourism.entity;

import com.lfyjzjxy.tourism.vo.RoadmapScenicVo;
import lombok.Data;

import java.util.Date;
import java.util.List;

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

    private String picture;

    private Integer status;

    private Integer userNum;

    private Date createTime;

    private String username;

    private String photo;

    private List<RoadmapScenicVo> roadmapScenicList;

    public String getStatusName(){
        if (this.status == 1){
            return "结伴中";
        }else if(this.status == 2){
            return "结伴结束";
        }else if(this.status == 3){
            return "旅行结束";
        }else if(this.status == 4){
            return "取消";
        }else{
            return "起草";
        }
    }
}
