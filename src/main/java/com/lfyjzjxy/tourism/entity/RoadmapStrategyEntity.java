package com.lfyjzjxy.tourism.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;


@Data
public class RoadmapStrategyEntity {




    private Integer strategyId;

    private Integer userId;

    private Integer roadmapId;

    private String title;

    private String content;

    private String headImg;
    private String shortContent;

    private BigDecimal priceMax;

    private BigDecimal priceMin;

    private Integer playDay;

    private Integer  traffic;

    private Integer state;

    private Date createTime;

}

