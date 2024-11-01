package com.energias.renovables.modelo.pais;

import com.energias.renovables.modelo.plantaproduccion.PlantaProduccion;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table ( name = "pais" )
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pais {
    
    @Id
    private int id;
    private String nombre;
    private BigDecimal energiarequerida;
    private BigDecimal nivelcovertura;
    private BigDecimal poblacion;
    @ManyToOne ( fetch = FetchType.LAZY )
    @JoinColumn ( name = "planta_produccion_id")
    private PlantaProduccion plantaproduccionid;
    
}
