package com.energias.renovables.modelo.energiasolar;

import com.energias.renovables.modelo.CalcularProduccionEnergia;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class EnergiaSolarService implements CalcularProduccionEnergia {
    
    private final EnergiaSolarRepository energiaSolarRepository;
    
    public EnergiaSolarService ( EnergiaSolarRepository energiaSolarRepository ) {
        this.energiaSolarRepository = energiaSolarRepository;
    }
    
    @Override
    public BigDecimal calcularProduccionEnergia () {
        return energiaSolarRepository.findAll().stream()
                .map( energiaSolar -> {
                    // Obtener los valores y verificar si son nulos
                    BigDecimal radiacionSolarPromedio = energiaSolar.getRadiacionSolarPromedio();
                    BigDecimal areaPaneles = energiaSolar.getAreaPaneles();
                    BigDecimal anguloInclinacion = energiaSolar.getAnguloInclinacion();
                    BigDecimal eficienciaPaneles = energiaSolar.getEficienciaPaneles();
                    
                    // Verificar si alguno de los valores es nulo
                    if ( radiacionSolarPromedio == null || areaPaneles == null ||
                            anguloInclinacion == null || eficienciaPaneles == null ) {
                        return BigDecimal.ZERO; // O manejarlo según tu lógica
                    }
                    
                    // Calcular la energía generada
                    return radiacionSolarPromedio
                            .multiply( areaPaneles )
                            .multiply( anguloInclinacion )
                            .multiply( eficienciaPaneles )
                            .multiply( BigDecimal.valueOf( 365 ) );
                } )
                .reduce( BigDecimal.ZERO, BigDecimal::add );
    }
    
    @Override
    public BigDecimal calcularProduccionEnergiaId ( int id ) {
        return energiaSolarRepository.findById( id )
                .map( energiaSolar -> {
                    // Obtener los valores y verificar si son nulos
                    BigDecimal radiacionSolarPromedio = energiaSolar.getRadiacionSolarPromedio();
                    BigDecimal areaPaneles = energiaSolar.getAreaPaneles();
                    BigDecimal anguloInclinacion = energiaSolar.getAnguloInclinacion();
                    BigDecimal eficienciaPaneles = energiaSolar.getEficienciaPaneles();
                    
                    // Verificar si alguno de los valores es nulo
                    if ( radiacionSolarPromedio == null || areaPaneles == null ||
                            anguloInclinacion == null || eficienciaPaneles == null ) {
                        return BigDecimal.ZERO; // O manejarlo según tu lógica
                    }
                    
                    // Calcular la energía generada
                    return radiacionSolarPromedio
                            .multiply( areaPaneles )
                            .multiply( anguloInclinacion )
                            .multiply( eficienciaPaneles )
                            .multiply( BigDecimal.valueOf( 365 ) );
                } )
                .orElse( BigDecimal.ZERO );
    }
}
