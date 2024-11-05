package com.energias.renovables.modelo.pais;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

import java.math.BigDecimal;

public record IngresarPaisDTO(
        @NotBlank
        String nombre,
        @NotNull
        BigDecimal energiarequerida,
        @NotNull
        BigDecimal nivelcovertura,
        @NotNull
        BigDecimal poblacion
) {
}
