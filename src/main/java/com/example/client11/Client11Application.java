package com.example.client11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class Client11Application {

    public static void main(String[] args) {
        SpringApplication.run(Client11Application.class, args);
    }

}
