package com.javiermoreno.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
TODO: Activar servidor zuul
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
