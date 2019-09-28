package com.liuyuan.gmall.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
//指定扫描的包
@MapperScan(basePackages = "com.liuyuan.gmall.user.mapper")
@ComponentScan(basePackages = "com.liuyuan.gmall")
public class GmallUserManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(GmallUserManageApplication.class, args);
    }

}
