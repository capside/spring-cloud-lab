package com.javiermoreno.springcloud;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author ciberado
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode(of = "referencia")
public class StockProducto {
    private String referencia;
    private int unidadesDisponibles;
    
}
