package com.energias.renovables.modelo.energiasolar;

import com.energias.renovables.modelo.energiasrenovables.EnergiasRenovables;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table ( name = "energiasolar" )
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EnergiaSolar {
    
    @Id
    private int id;
    private BigDecimal radiacionSolarPromedio;
    private BigDecimal areaPaneles;
    private BigDecimal anguloInclinacion;
    private BigDecimal eficienciaPaneles;
    
    @MapsId
    @OneToOne
    @JoinColumn ( name = "id" )
    private EnergiasRenovables energiasRenovables;
    
}
