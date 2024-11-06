package com.energias.renovables.modelo.pais;

import com.energias.renovables.modelo.energiasolar.EnergiaSolarDTO;
import com.energias.renovables.modelo.energiasrenovables.EnergiasRenovablesDTO;
import com.energias.renovables.modelo.plantaproduccion.PlantaProduccionDTO;
import com.energias.renovables.modelo.plantaproduccion.PlantaProduccionSolarDTO;

import java.math.BigDecimal;

public record PaisPlantaEnergiaSolarDTO(
        PaisDTO pais,
        PlantaProduccionDTO plantaProduccion,
        EnergiasRenovablesDTO energia_renovable,
        EnergiaSolarDTO energia_solar
) {
    public PaisPlantaEnergiaSolarDTO ( PaisDTO pais,
                                       PlantaProduccionSolarDTO plantaProduccion,
                                       EnergiasRenovablesDTO energiaRenovable,
                                       EnergiaSolarDTO energiaSolar ) {
        this(
                new PaisDTO(
                        pais.id(),
                        pais.nombre(),
                        pais.energiarequerida(),
                        pais.nivelcovertura(),
                        pais.poblacion()
                ),
                new PlantaProduccionDTO( plantaProduccion.id(),
                        plantaProduccion.ubicacion(),
                        plantaProduccion.capacidad_instalada(),
                        plantaProduccion.eficiencia(),
                        plantaProduccion.fecha_creacion() ),
                new EnergiasRenovablesDTO( energiaRenovable.id(),
                        energiaRenovable.nombre(),
                        energiaRenovable.tipoEnergiaId() ),
                new EnergiaSolarDTO( energiaSolar.id(),
                        energiaSolar.radiacionSolarPromedio(),
                        energiaSolar.areaPaneles(),
                        energiaSolar.anguloInclinacion() )
        );
    }
}
