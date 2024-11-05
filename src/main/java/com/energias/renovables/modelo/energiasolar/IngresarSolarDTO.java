package com.energias.renovables.modelo.energiasolar;

import java.math.BigDecimal;

public record IngresarSolarDTO(
        BigDecimal radiacionSolarPromedio,
        BigDecimal areaPaneles,
        BigDecimal anguloInclinacion
) {
}
