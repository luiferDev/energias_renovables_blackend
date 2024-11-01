package com.energias.renovables.modelo.energiahidroelectrica;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table ( name = "energiahidroelectrica" )
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EnergiaHidroelectrica {
    
    @Id
    private int id;
    private BigDecimal salto;
    private BigDecimal caudal;
    private int numeroTurbinas;
    
}
