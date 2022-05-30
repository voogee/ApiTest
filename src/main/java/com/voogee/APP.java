package com.voogee;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Auther: bruceliu
 * @Date: 2019/12/23 11:04
 * @QQ:1241488705
 * @Description: 启动类  @SpringBootApplication
 */
@SpringBootApplication
public class APP {

    public static void main(String[] args) {

//        启动SpringBoot
//        SpringApplication.run(APP.class,args);
        SpringApplication app = new SpringApplication(APP.class);
        app.setBannerMode(Banner.Mode.CONSOLE);//关闭Banner
        app.run(args);
    }

}
