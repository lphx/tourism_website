package com.lfyjzjxy.tourism.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;


@Data
public class StrategyCommentEntity {




    private Integer id;

    private Integer strategyId;

    private String content;

    private Integer userId;

    private Integer sendUserId;

    private Integer pid;

    private Date createTime;

    private Integer state;

}

