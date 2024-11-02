package com.energias.renovables.modelo.energiasrenovables;

import com.energias.renovables.modelo.energiasolar.EnergiaSolar;
import com.energias.renovables.modelo.plantaproduccion.PlantaProduccion;
import com.energias.renovables.modelo.tipoenergia.TipoEnergia;
import jakarta.persistence.*;
import jakarta.persistence.CascadeType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table ( name = "energiasrenovables" )
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EnergiasRenovables {
    
    @Id
    private int id;
    private String nombre;
    @ManyToOne ( fetch = FetchType.LAZY )
    @JoinColumn ( name = "tipoenergiaid" )
    private TipoEnergia tipoEnergiaId;
    
    @MapsId
    @OneToOne ( fetch = FetchType.LAZY )
    @JoinColumn ( name = "id" )
    private PlantaProduccion plantaProduccion;
    @OneToOne ( mappedBy = "energiasRenovables", cascade = CascadeType.ALL, fetch = FetchType.LAZY )
    private EnergiaSolar energiaSolar;
    
}
