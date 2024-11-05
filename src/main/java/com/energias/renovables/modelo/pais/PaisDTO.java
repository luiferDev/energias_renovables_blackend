package com.energias.renovables.modelo.pais;

import java.math.BigDecimal;

public record PaisDTO(
        int id,
        String nombre,
        BigDecimal energiarequerida,
        BigDecimal nivelcovertura,
        BigDecimal poblacion
) {
}
