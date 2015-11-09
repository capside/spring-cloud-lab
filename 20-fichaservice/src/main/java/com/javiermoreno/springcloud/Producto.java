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
@EqualsAndHashCode(of="referencia")
public class Producto {
    
    private String referencia;
    private String modelo;
    private String sexo;
    private String color;
    private String imagen;
    private int unidadesDisponibles;
    private BigDecimal precio;

    public Producto() {
    }

    
    public void aplicarDescuento(BigDecimal descuento) {
        this.precio = this.precio.multiply(BigDecimal.ONE.subtract(descuento));
    }
    
}
