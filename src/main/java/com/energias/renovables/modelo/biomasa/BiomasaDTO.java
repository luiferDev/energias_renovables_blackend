package com.energias.renovables.modelo.biomasa;

import java.math.BigDecimal;

public record BiomasaDTO(
        int id,
        String origen,
        BigDecimal cantidad,
        BigDecimal contenidoEnergetico,
        String metodoCoversion
) {
}
