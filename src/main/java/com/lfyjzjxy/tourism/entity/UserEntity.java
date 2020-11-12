package com.lfyjzjxy.tourism.entity;

import lombok.Data;

import java.sql.Blob;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;


@Data
public class UserEntity {

    private Integer userId;

    private String username;

    private String password;

    private Integer status;

    private Integer jurisdiction;

    private Date createTime;
    private String photo;
}

