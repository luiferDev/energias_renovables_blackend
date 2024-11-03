package com.energias.renovables.modelo.pais;

import com.energias.renovables.modelo.energiasolar.EnergiaSolarDTO;
import com.energias.renovables.modelo.energiasrenovables.EnergiasRenovablesDTO;
import com.energias.renovables.modelo.plantaproduccion.PlantaProduccionDTO;
import com.energias.renovables.modelo.plantaproduccion.PlantaProduccionSolarDTO;

import java.math.BigDecimal;

public record PaisPlantaEnergiaSolarDTO(
        int id,
        String nombre,
        BigDecimal energiarequerida,
        BigDecimal nivelcovertura,
        BigDecimal poblacion,
        PlantaProduccionDTO plantaProduccion,
        EnergiasRenovablesDTO energia_renovable,
        EnergiaSolarDTO energia_solar
) {
    public PaisPlantaEnergiaSolarDTO ( Pais pais,
                                       PlantaProduccionSolarDTO plantaProduccion,
                                       EnergiasRenovablesDTO energiaRenovable,
                                       EnergiaSolarDTO energiaSolar ) {
        this(
                pais.getId(),
                pais.getNombre(),
                pais.getEnergiarequerida(),
                pais.getNivelcovertura(),
                pais.getPoblacion(),
                new PlantaProduccionDTO( plantaProduccion.id(),
                        plantaProduccion.ubicacion(),
                        plantaProduccion.capacidad_instalada(),
                        plantaProduccion.eficiencia(),
                        plantaProduccion.fecha_creacion() ),
                new EnergiasRenovablesDTO( plantaProduccion.energia_renovable().id(),
                        plantaProduccion.energia_renovable().nombre(),
                        plantaProduccion.energia_renovable().tipoEnergiaId() ),
                new EnergiaSolarDTO( plantaProduccion.energia_solar().id(),
                        plantaProduccion.energia_solar().radiacionSolarPromedio(),
                        plantaProduccion.energia_solar().areaPaneles(),
                        plantaProduccion.energia_solar().anguloInclinacion() )
        );
    }
}
