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
}
