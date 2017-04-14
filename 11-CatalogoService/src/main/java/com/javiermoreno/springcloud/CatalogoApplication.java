package com.javiermoreno.springcloud;

import java.math.BigDecimal;
import lombok.extern.apachecommons.CommonsLog;
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
@CommonsLog
public class CatalogoApplication {

    @RequestMapping(value = "/referencias/{referencia}", method = RequestMethod.GET)
    public FichaProducto obtenerFichaProducto(@PathVariable String referencia) {
        log.info(String.format("Recuperando ficha del producto %s.", referencia));
        FichaProducto ficha = new FichaProducto(referencia, "Camiseta",
                "hombre", "negro",
                "http://www.vivefiestas.com/blog/wp-content/uploads/2015/05/camiseta-orgullo-friki-2008.png",
                new BigDecimal("100"));
        return ficha;
    }

    public static void main(String[] args) {
        SpringApplication.run(CatalogoApplication.class, args);
    }
}
