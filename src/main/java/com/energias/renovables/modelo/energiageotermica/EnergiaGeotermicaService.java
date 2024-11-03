package com.energias.renovables.modelo.energiageotermica;

import com.energias.renovables.modelo.CalcularProduccionEnergia;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class EnergiaGeotermicaService implements CalcularProduccionEnergia {
    
    private final EnergiaGeotermicaRepository energiaGeotermicaRepository;
    
    public EnergiaGeotermicaService ( EnergiaGeotermicaRepository energiaGeotermicaRepository ) {
        this.energiaGeotermicaRepository = energiaGeotermicaRepository;
    }
    
    @Override
    public BigDecimal calcularProduccionEnergia () {
        return null;
    }
    
    @Override
    public BigDecimal calcularProduccionEnergiaId ( int id ) {
        return energiaGeotermicaRepository.findById( ( int ) id )
                .map( energiaGeotermica -> {
                    BigDecimal caudal = energiaGeotermica.getCaudal();
                    BigDecimal temperatura = energiaGeotermica.getTemperaturaFluidos();
                    BigDecimal pozos = BigDecimal.valueOf( energiaGeotermica.getNumeroPozos() );
                    
                    // Verificar si alguno de los valores es nulo
                    if ( caudal == null || temperatura == null || pozos == null ) {
                        return BigDecimal.ZERO; // O manejarlo según tu lógica
                    }
                    
                    // Calcular la energía generada
                    return caudal.multiply( temperatura )
                            .multiply( pozos ).multiply( BigDecimal.valueOf( 365 ) );
                } )
                .orElse( BigDecimal.ZERO );
    }
}
