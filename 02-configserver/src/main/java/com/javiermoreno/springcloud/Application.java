package com.javiermoreno.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
/* TODO: Set the annotation for config server. */
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
