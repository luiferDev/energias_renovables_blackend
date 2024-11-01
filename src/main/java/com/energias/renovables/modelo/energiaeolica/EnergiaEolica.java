package com.energias.renovables.modelo.energiaeolica;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table ( name = "energiaeolica" )
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EnergiaEolica {
    
    @Id
    private int id;
    private int numeroTurbinas;
    private BigDecimal velocidadViento;
    private BigDecimal alturaTurbinas;
    private BigDecimal diametroTurbina;
    
}
