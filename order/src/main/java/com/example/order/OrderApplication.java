package com.example.order;

import com.example.order.config.CustomRibbonConfig;
import com.example.order.config.ExcludeRibbonConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@EnableEurekaClient   //Netflix
//@EnableDiscoveryClient //spring 自己的
@RibbonClient(name = "microservice-user",configuration = CustomRibbonConfig.class)
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = ExcludeRibbonConfig.class)})
@EnableFeignClients
@MapperScan(basePackages = "com.example.order.mapper")
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

}
