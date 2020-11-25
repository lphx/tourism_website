package com.lfyjzjxy.tourism.entity;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class AdminEntity {

    
    private Integer adminId;

    private String username;

    private String password;

    private LocalDateTime createTime;

    private Integer status;

}

