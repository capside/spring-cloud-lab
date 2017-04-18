package com.javiermoreno.springcloud;

import lombok.extern.apachecommons.CommonsLog;
import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
/* TODO: Enable discovery client. */
@RestController
@CommonsLog
public class StockApplication {

    @RequestMapping(value = "/productos/{referencia}/stock", method = RequestMethod.GET)
    public StockProducto obtenerStockProducto(@PathVariable String referencia) {
        /* TODO: Create a fake implemenation. */
    }

    public static void main(String[] args) {
        SpringApplication.run(StockApplication.class, args);
    }
}
