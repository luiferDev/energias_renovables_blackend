package com.energias.renovables.modelo.pais;

import com.energias.renovables.modelo.biomasa.BiomasaDTO;
import com.energias.renovables.modelo.energiasrenovables.EnergiasRenovablesDTO;
import com.energias.renovables.modelo.plantaproduccion.PlantaProduccionDTO;

import java.math.BigDecimal;

public record PaisPlantaEnergiaBiomasa(
        int id,
        String nombre,
        BigDecimal energiarequerida,
        BigDecimal nivelcovertura,
        BigDecimal poblacion,
        PlantaProduccionDTO plantaProduccion,
        EnergiasRenovablesDTO energia_renovable,
        BiomasaDTO biomasa
) {
    public PaisPlantaEnergiaBiomasa ( Pais pais,
                                      PlantaProduccionDTO plantaProduccion,
                                      EnergiasRenovablesDTO energiaRenovable,
                                      BiomasaDTO biomasa ) {
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
                new EnergiasRenovablesDTO( energiaRenovable.id(),
                        energiaRenovable.nombre(),
                        energiaRenovable.tipoEnergiaId() ),
                new BiomasaDTO( biomasa.id(),
                        biomasa.origen(),
                        biomasa.cantidad(),
                        biomasa.contenidoEnergetico(),
                        biomasa.metodoCoversion() )
        );
    }
}
