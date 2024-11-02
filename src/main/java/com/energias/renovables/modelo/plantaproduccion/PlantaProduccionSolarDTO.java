package com.energias.renovables.modelo.plantaproduccion;

import com.energias.renovables.modelo.energiasolar.EnergiaSolarDTO;
import com.energias.renovables.modelo.energiasrenovables.EnergiasRenovablesDTO;

import java.math.BigDecimal;
import java.util.Date;

public record PlantaProduccionSolarDTO(
        int id,
        String ubicacion,
        BigDecimal capacidad_instalada,
        BigDecimal eficiencia,
        EnergiasRenovablesDTO energia_renovable,
        EnergiaSolarDTO energia_solar,
        Date fecha_creacion
) {
    public PlantaProduccionSolarDTO ( PlantaProduccion plantaProduccion,
                                      EnergiasRenovablesDTO energiaRenovable,
                                      EnergiaSolarDTO energiaSolar ) {
        this(
                plantaProduccion.getId(),
                plantaProduccion.getUbicacion(),
                plantaProduccion.getCapacidadInstalada(),
                plantaProduccion.getEficiencia(),
                new EnergiasRenovablesDTO( energiaRenovable.id(),
                        energiaRenovable.nombre(), energiaRenovable.tipoEnergiaId() ),
                new EnergiaSolarDTO( energiaSolar.id(),
                        energiaSolar.radiacionSolarPromedio(),
                        energiaSolar.areaPaneles(),
                        energiaSolar.anguloInclinacion() ),
                plantaProduccion.getFechaCreacion()
        );
    }
}
