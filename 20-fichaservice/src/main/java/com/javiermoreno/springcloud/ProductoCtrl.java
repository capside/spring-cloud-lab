package com.javiermoreno.springcloud;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ciberado
 */
TODO: Registrar como controlador
public class ProductoCtrl {

    private final ProductosServ service;

    @Autowired
    public ProductoCtrl(ProductosServ service) {
        this.service = service;
    }
    
    
    TODO: Publicar como operación
    public Producto obtenerProductoParalelo(@PathVariable String referencia) 
    throws IOException, InterruptedException, ExecutionException {
        return service.obtenerProducto(referencia);
    }
    
    
}
