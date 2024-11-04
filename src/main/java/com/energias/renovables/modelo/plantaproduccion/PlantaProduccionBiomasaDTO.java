package com.energias.renovables.modelo.plantaproduccion;

import com.energias.renovables.modelo.biomasa.BiomasaDTO;
import com.energias.renovables.modelo.energiasolar.EnergiaSolarDTO;
import com.energias.renovables.modelo.energiasrenovables.EnergiasRenovablesDTO;

import java.math.BigDecimal;
import java.util.Date;

public record PlantaProduccionBiomasaDTO(
        int id,
        String ubicacion,
        BigDecimal capacidad_instalada,
        BigDecimal eficiencia,
        EnergiasRenovablesDTO energia_renovable,
        BiomasaDTO biomasa,
        Date fecha_creacion
) {
    public PlantaProduccionBiomasaDTO ( PlantaProduccion plantaProduccion,
                                        EnergiasRenovablesDTO energiaRenovable,
                                        BiomasaDTO biomasa ) {
        this(
                plantaProduccion.getId(),
                plantaProduccion.getUbicacion(),
                plantaProduccion.getCapacidadInstalada(),
                plantaProduccion.getEficiencia(),
                new EnergiasRenovablesDTO( energiaRenovable.id(),
                        energiaRenovable.nombre(), energiaRenovable.tipoEnergiaId() ),
                new BiomasaDTO( biomasa.id(),
                        biomasa.origen(),
                        biomasa.cantidad(),
                        biomasa.contenidoEnergetico(),
                        biomasa.metodoCoversion() ),
                plantaProduccion.getFechaCreacion()
        );
    }
}
