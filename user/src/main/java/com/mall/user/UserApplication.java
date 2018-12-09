package com.mall.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商城系统-用户系统
 *
 * @author Daoyuan
 * @version 1.0.0
 */
@EnableEurekaClient
@SpringBootApplication
@RestController
public class UserApplication {

    @GetMapping("actuator/info")
    public String info() {
        return "用户系统";
    }

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}