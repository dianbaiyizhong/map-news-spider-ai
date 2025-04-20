package com.nntk.mapnews;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = {"com.nntk.mapnews.mp"}) // 扫描 Mapper 接口所在的包
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

}
