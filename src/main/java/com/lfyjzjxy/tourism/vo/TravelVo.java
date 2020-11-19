package com.lfyjzjxy.tourism.vo;

import lombok.Data;

import java.util.Date;


@Data
public class TravelVo {




    private Integer travelId;

    private Integer userId;

    private String title;

    private String picture;

    private String content;

    private String shortContent;

    private Date createTime;

    private Date updateTime;

    private Integer status;

    private String username;

    private String photo;

    private  Integer likeNum;

}

