package com.lfyjzjxy.tourism;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lfyjzjxy.tourism.mapper")
public class TourismWebsiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(TourismWebsiteApplication.class, args);
    }

}
