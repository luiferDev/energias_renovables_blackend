package com.energias.renovables.modelo.biomasa;

import com.energias.renovables.modelo.CalcularProduccionEnergia;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class BiomasaService implements CalcularProduccionEnergia {
    
    private final BiomasaRepository biomasaRepository;
    
    public BiomasaService ( BiomasaRepository biomasaRepository ) {
        this.biomasaRepository = biomasaRepository;
    }
    
    @Override
    public BigDecimal calcularProduccionEnergia () {
        return biomasaRepository.findAll().stream()
                .map( biomasa -> {
                    BigDecimal cantidad = biomasa.getCantidad();
                    BigDecimal contenidoEnergetico = biomasa.getContenidoEnergetico();
                    
                    // Verificar si el contenido energético es cero para evitar división por cero
                    if ( contenidoEnergetico.compareTo( BigDecimal.ZERO ) == 0 ) {
                        return BigDecimal.ZERO; // o manejarlo según tu lógica
                    }
                    
                    // Realizar la división con un modo de redondeo
                    return cantidad.divide( contenidoEnergetico, RoundingMode.HALF_UP )
                            .multiply( BigDecimal.valueOf( 100 ) );
                } )
                .reduce( BigDecimal.ZERO, BigDecimal::add );
    }
    
    @Override
    public BigDecimal calcularProduccionEnergiaId ( int id ) {
        
        return biomasaRepository.findById( ( int ) id )
                .map( biomasa -> {
                    int idBiomasa = biomasa.getId();
                    BigDecimal cantidad = biomasa.getCantidad();
                    BigDecimal contenidoEnergetico = biomasa.getContenidoEnergetico();
                    
                    // Verificar si el contenido energético es cero para evitar división por cero
                    if ( contenidoEnergetico.compareTo( BigDecimal.ZERO ) == 0 ) {
                        return BigDecimal.ZERO; // o manejarlo según tu lógica
                    }
                    if ( idBiomasa != id ) {
                        return BigDecimal.ZERO;
                    }
                    
                    // Realizar la división con un modo de redondeo
                    return cantidad.divide( contenidoEnergetico, RoundingMode.HALF_UP )
                            .multiply( BigDecimal.valueOf( 100 )
                                    .multiply( BigDecimal.valueOf( 365 ) ) );
                } )
                .orElse( BigDecimal.ZERO );
    }
}
