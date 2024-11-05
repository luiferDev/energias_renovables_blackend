package com.energias.renovables.modelo.energiasolar;

import java.math.BigDecimal;

public record EnergiaSolarDTO(
        int id,
        BigDecimal radiacionSolarPromedio,
        BigDecimal areaPaneles,
        BigDecimal anguloInclinacion
) {
}
