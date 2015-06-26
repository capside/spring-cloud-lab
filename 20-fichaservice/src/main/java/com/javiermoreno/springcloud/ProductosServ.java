package com.javiermoreno.springcloud;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

/**
 *
 * @author ciberado
 */
TODO: Registrar como servicio
TODO: Indicar que es posible reiniciarlo mediante POST /refresh
public class ProductosServ {

    TODO: Recuperar valor desde configuración remota
    private boolean rebajas;
    TODO: Recuperar valor desde configuración remota
    private BigDecimal descuento;

    private final IntegracionWebservices integracion;

    @Autowired
    public ProductosServ(IntegracionWebservices integracion) {
        this.integracion = integracion;
    }
    
    
    public Producto obtenerProducto(String referencia) throws InterruptedException, ExecutionException, IOException {
        TODO: Implementar
    }

}
