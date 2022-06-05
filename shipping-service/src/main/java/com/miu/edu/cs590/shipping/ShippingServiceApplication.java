package com.miu.edu.cs590.shipping;

import com.miu.edu.cs590.shipping.service.ShippingService;
import com.miu.edu.cs590.shipping.service.ShippingServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class ShippingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShippingServiceApplication.class, args);
    }

    @Bean
    ShippingService shippingService(){ return new ShippingServiceImpl();}

}
