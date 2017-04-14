package com.javiermoreno.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class StockApplication {

    @RequestMapping(value = "/productos/{referencia}/stock", method = RequestMethod.GET)
    public StockProducto obtenerStockProducto(@PathVariable String referencia) {
        StockProducto prod = new StockProducto(referencia, (int) (Math.random() * 10));
        return prod;
    }

    public static void main(String[] args) {
        SpringApplication.run(StockApplication.class, args);
    }
}
