package com.lfyjzjxy.tourism.entity;

import lombok.Data;

import java.util.Date;


@Data
public class RoadmapEntity {




    private Integer roadmapId;

    private Integer userId;

    private String title;

    private String content;
    private String picture;

    private Integer status;

    private Date createTime;
    

}

