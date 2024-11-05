package com.energias.renovables.modelo.plantaproduccion;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.sql.Date;

public record IngresaPlantaProduccionDTO(
        @NotBlank
        String ubicacion,
        @NotNull
        BigDecimal capacidad_instalada,
        @NotNull
        BigDecimal eficiencia,
        @DateTimeFormat ( pattern = "yyyy-MM-dd" )
        Date fecha_creacion
) {
    public IngresaPlantaProduccionDTO ( @NotBlank String ubicacion,
                                        @NotNull BigDecimal bigDecimal,
                                        @NotNull BigDecimal eficiencia,
                                        Object o, Object o1, Date date ) {
        this(
                ubicacion,
                bigDecimal,
                eficiencia,
                date
        );
    }
}
