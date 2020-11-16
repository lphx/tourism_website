package com.lfyjzjxy.tourism.vo;

import lombok.Data;

import java.util.Date;
import java.util.List;


@Data
public class StrategyCommentVo {




    private Integer id;

    private Integer strategyId;

    private String content;

    private Integer userId;

    private Integer sendUserId;

    private Integer pid;

    private Date createTime;

    private Integer state;

    private String username1;

    private String username2;

    List<StrategyCommentVo> childList;

}

