package com.javiermoreno.springcloud;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import lombok.extern.apachecommons.CommonsLog;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ciberado
 */
@RestController
@CommonsLog
public class ProductoCtrl {

    private final ProductosService service;

    @Autowired
    public ProductoCtrl(ProductosService service) {
        this.service = service;
    }
        
    @RequestMapping(value="/productos/{referencia}", method=RequestMethod.GET)
    public Producto obtenerProductoDeFormaAsincrona(@PathVariable String referencia) 
    throws IOException, InterruptedException, ExecutionException {
        log.info(String.format("Recuperando catálogo de %s", referencia));
        Producto producto = service.obtenerProducto(referencia);
        return producto;
    }
    
    
}
