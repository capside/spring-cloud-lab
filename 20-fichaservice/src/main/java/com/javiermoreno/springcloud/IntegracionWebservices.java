/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javiermoreno.springcloud;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.concurrent.Future;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author ciberado
 */
TODO: Registrar componente
public class IntegracionWebservices {
    
    private final ObjectMapper objectMapper;
    private final RestTemplate restTemplate;

    @Autowired
    public IntegracionWebservices(ObjectMapper objectMapper, RestTemplate restTemplate) {
        this.objectMapper = objectMapper;
        this.restTemplate = restTemplate;
    }
   

    TODO: Activar asincronía
    public Future<Integer> obtenerStockAsync(String referencia) throws IOException {
        TODO: Invocar stocks
    }


    TODO: Activar asincronía
    public Future<Producto> obtenerFichaCatalogoAsync(String referencia) {
        TODO: Invocar catálogo
    }
    
}
