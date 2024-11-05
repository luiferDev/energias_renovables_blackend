package com.energias.renovables.modelo.energiasolar;

import com.energias.renovables.modelo.energiasrenovables.IngresarEnergiasRenovablesDTO;
import com.energias.renovables.modelo.pais.IngresarPaisDTO;
import com.energias.renovables.modelo.plantaproduccion.IngresaPlantaProduccionDTO;


public record IngresarEnergiaSolarDTO(
        IngresaPlantaProduccionDTO plantaProduccion,
        IngresarEnergiasRenovablesDTO energia_renovable,
        IngresarSolarDTO energia_solar,
        IngresarPaisDTO pais
) {
    public IngresarEnergiaSolarDTO ( IngresarPaisDTO pais,
                                     IngresaPlantaProduccionDTO plantaProduccion,
                                     IngresarEnergiasRenovablesDTO energiaRenovable,
                                     IngresarSolarDTO energiaSolar ) {
        this(
                new IngresaPlantaProduccionDTO(
                        plantaProduccion.ubicacion(),
                        plantaProduccion.capacidad_instalada(),
                        plantaProduccion.eficiencia(),
                        plantaProduccion.fecha_creacion()
                ),
                new IngresarEnergiasRenovablesDTO(
                        energiaRenovable.nombre()
                ),
                new IngresarSolarDTO(
                        energiaSolar.radiacionSolarPromedio(),
                        energiaSolar.areaPaneles(),
                        energiaSolar.anguloInclinacion()
                ),
                new IngresarPaisDTO(
                        pais.nombre(),
                        pais.energiarequerida(),
                        pais.nivelcovertura(),
                        pais.poblacion() )
        );
    }
}
