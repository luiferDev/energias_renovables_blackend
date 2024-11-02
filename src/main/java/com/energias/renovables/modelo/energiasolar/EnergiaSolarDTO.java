package com.energias.renovables.modelo.energiasolar;

public record EnergiaSolarDTO(
        int id,
        java.math.BigDecimal radiacionSolarPromedio,
        java.math.BigDecimal areaPaneles,
        java.math.BigDecimal anguloInclinacion
) {
}
