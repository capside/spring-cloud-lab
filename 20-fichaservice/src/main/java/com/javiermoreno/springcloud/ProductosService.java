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
 * Permite invocar los webservices de los que depende el actual.
 *
 * @author ciberado
 */
@Service
@RefreshScope
public class ProductosService {

    @Value("${promociones.rebajas}")
    private boolean rebajas;
    @Value("${promociones.descuento}")
    private BigDecimal descuento;

    private final IntegracionWebservices integracion;

    @Autowired
    public ProductosService(IntegracionWebservices integracion) {
        this.integracion = integracion;
    }

    /* Alternativamente, si no se requiere un proceso sofisticado de la respuesta,
       es posible evitar @async utilizando AsyncRestTemplate.
    */
    
    /*  Versión síncrona ******************************************************************************
     public Producto obtenerProducto(@PathVariable String referencia) throws IOException {
     // Atiende qué bonito: indicas el nombre del servicio y restTemplate es capaz de recuperar su @
     String catalogoURL = "http://catalogo-service/catalogo/referencias/" + referencia;
     Producto producto = restTemplate.getForObject(catalogoURL, Producto.class);
        
     String stockURL = "http://stock-service/productos/" + referencia + "/stock";
     String stockResponseBody = restTemplate.getForObject(stockURL, String.class);
     JsonNode stockJson = objectMapper.readTree(stockResponseBody);
     int unidadesDisponibles = stockJson.get("unidadesDisponibles").asInt();
     producto.setUnidadesDisponibles(unidadesDisponibles);
    
     if (rebajas == true) {
     producto.aplicarDescuento(descuento);
     }
        
     return producto;
     }
     */
    public Producto obtenerProducto(String referencia)
            throws InterruptedException, ExecutionException, IOException {
        Future<Producto> futureProducto
                = integracion.obtenerFichaCatalogoAsync(referencia);
        Future<Integer> futureUnidadesDisponibles
                = integracion.obtenerStockAsync(referencia);

        Producto producto = futureProducto.get();
        producto.setUnidadesDisponibles(futureUnidadesDisponibles.get());

        if (rebajas == true) {
            producto.aplicarDescuento(descuento);
        }

        return producto;
    }

}
