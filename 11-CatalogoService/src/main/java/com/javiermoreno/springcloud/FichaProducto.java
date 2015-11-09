package com.javiermoreno.springcloud;

import java.math.BigDecimal;
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
public class FichaProducto {
    
    private String referencia;
    private String modelo;
    private String sexo;
    private String color;
    private String imagen;
    private BigDecimal precio;

    
}
