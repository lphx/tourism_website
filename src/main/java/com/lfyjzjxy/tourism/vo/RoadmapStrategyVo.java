package com.lfyjzjxy.tourism.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@Data
public class RoadmapStrategyVo {




    private Integer strategyId;

    private Integer userId;

    private Integer roadmapId;

    private String title;

    private String content;

    private String headImg;

    private BigDecimal priceMax;

    private BigDecimal priceMin;

    private Integer playDay;

    private Integer  traffic;

    private Integer state;

    private Date createTime;

    //用户
    private String username;

    private String photo;

    //路线景点
    private List<RoadmapScenicVo> roadmapScenicList;

    //评论数
    private Integer commentNum;

    //点赞数
    private Integer likeNum;

}

