package com.energias.renovables.modelo;

import java.math.BigDecimal;

public interface CalcularProduccionEnergia {
    
    BigDecimal calcularProduccionEnergia ();
    
    BigDecimal calcularProduccionEnergiaId ( int id );
}
