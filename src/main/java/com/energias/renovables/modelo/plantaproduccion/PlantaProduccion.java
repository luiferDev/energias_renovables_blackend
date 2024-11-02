package com.energias.renovables.modelo.plantaproduccion;

import com.energias.renovables.modelo.energiasrenovables.EnergiasRenovables;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table ( name = "plantaproduccion" )
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PlantaProduccion {
    
    @Id
    private int id;
    private String ubicacion;
    private BigDecimal capacidadInstalada;
    private BigDecimal eficiencia;
    private Date fechaCreacion;
    
    @OneToOne ( mappedBy = "plantaProduccion", cascade = CascadeType.ALL, fetch = FetchType.LAZY )
    private EnergiasRenovables energiasRenovables;
}
