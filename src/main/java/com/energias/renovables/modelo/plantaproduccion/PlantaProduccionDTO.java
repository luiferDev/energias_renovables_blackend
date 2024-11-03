package com.energias.renovables.modelo.plantaproduccion;

import java.math.BigDecimal;

public record PlantaProduccionDTO(
        int id,
        String ubicacion,
        BigDecimal capacidad_instalada,
        BigDecimal eficiencia,
        java.util.Date fecha_creacion
) {
}
