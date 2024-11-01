package com.energias.renovables.modelo.biomasa;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table ( name = "biomasa" )
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Biomasa {
    
    @Id
    private int id;
    private String origen;
    private BigDecimal cantidad;
    private BigDecimal contenidoEnergetico;
    private String metodoCoversion;
    
}
