package com.energias.renovables.modelo.energiageotermica;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table ( name = "energiageotermica" )
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EnergiaGeotermica {
    
    @Id
    private int id;
    private BigDecimal caudal;
    private int numeroPozos;
    private BigDecimal temperaturaFluidos;
    
}
