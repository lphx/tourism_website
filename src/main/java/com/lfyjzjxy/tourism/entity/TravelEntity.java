package com.lfyjzjxy.tourism.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;


@Data
public class TravelEntity {




    private Integer travelId;

    private Integer userId;

    private String title;

    private String picture;

    private String content;

    private String shortContent;

    private Date createTime;

    private Date updateTime;

    private Integer status;

}

