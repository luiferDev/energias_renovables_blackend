package com.energias.renovables.modelo.energiaeolica;

import com.energias.renovables.modelo.CalcularProduccionEnergia;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class EnergiaEolicaService implements CalcularProduccionEnergia {
    private final EnergiaEolicaRepository energiaEolicaRepository;
    
    public EnergiaEolicaService ( EnergiaEolicaRepository energiaEolicaRepository ) {
        this.energiaEolicaRepository = energiaEolicaRepository;
    }
    @Override
    public BigDecimal calcularProduccionEnergia () {
        return null;
    }
    
    @Override
    public BigDecimal calcularProduccionEnergiaId ( int id ) {
        // W=1/2 *d*v^3  ; donde d es la densidad del viento (1,293) y v la velocidad
        // de este en m/s. Esta fórmula nos da la densidad de potencia que produce el aerogenerador en watios.
        return energiaEolicaRepository.findById( (int) id )
                .map( energiaEolica -> {
                    BigDecimal velocidadViento = energiaEolica.getVelocidadViento();
                    BigDecimal densidadViento = BigDecimal.valueOf( 1.293 );
                    
                    // Verificar si alguno de los valores es nulo
                    if ( velocidadViento == null || densidadViento == null ) {
                        return BigDecimal.ZERO; // O manejarlo según tu lógica
                    }
                    
                    // Calcular la energía generada
                    return BigDecimal.valueOf( 0.5 )
                            .multiply( densidadViento )
                            .multiply( velocidadViento.pow( 3 ) )
                            .multiply( BigDecimal.valueOf( 365 ) );
                } )
                .orElse( BigDecimal.ZERO );
    }
}
