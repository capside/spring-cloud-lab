package com.javiermoreno.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
TODO: activar servidor de configuración
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
