package com.nntk.mapnews;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan(value = {"com.nntk.mapnews"}) // 扫描 Mapper 接口所在的包
public class Application {

    public static void main(String[] args) {




        SpringApplication.run(Application.class, args);



    }



}
