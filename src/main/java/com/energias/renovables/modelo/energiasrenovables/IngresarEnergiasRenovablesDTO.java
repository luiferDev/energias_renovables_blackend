package com.energias.renovables.modelo.energiasrenovables;

import jakarta.validation.constraints.NotBlank;

public record IngresarEnergiasRenovablesDTO(
        @NotBlank
        String nombre
) {
}
