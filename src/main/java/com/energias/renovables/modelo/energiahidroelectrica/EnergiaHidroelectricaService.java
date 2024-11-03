package com.energias.renovables.modelo.energiahidroelectrica;

import com.energias.renovables.modelo.CalcularProduccionEnergia;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class EnergiaHidroelectricaService implements CalcularProduccionEnergia {
    
    private final EnergiaHidroelectricaRepository energiaHidroelectricaRepository;
    
    public EnergiaHidroelectricaService ( EnergiaHidroelectricaRepository energiaHidroelectricaRepository ) {
        this.energiaHidroelectricaRepository = energiaHidroelectricaRepository;
    }
    
    @Override
    public BigDecimal calcularProduccionEnergia () {
        return null;
    }
    
    @Override
    public BigDecimal calcularProduccionEnergiaId ( int id ) {
        return energiaHidroelectricaRepository.findById( ( int ) id )
                .map( energiaHidroelectrica -> {
                    BigDecimal salto = energiaHidroelectrica.getSalto();
                    BigDecimal caudal = energiaHidroelectrica.getCaudal();
                    BigDecimal turbinas = BigDecimal.valueOf( energiaHidroelectrica.getNumeroTurbinas() );
                    
                    // Verificar si alguno de los valores es nulo
                    if ( salto == null || caudal == null || turbinas == null ) {
                        return BigDecimal.ZERO; // O manejarlo según tu lógica
                    }
                    
                    // Calcular la energía generada
                    return salto.multiply( caudal )
                            .multiply( turbinas )
                            .multiply( BigDecimal.valueOf( 365 ) );
                } )
                .orElse( BigDecimal.ZERO );
    }
}
