package com.energias.renovables.modelo.energiasolar;

import com.energias.renovables.modelo.CalcularProduccionEnergia;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Date;

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
    
    public void crearEnergiaSolar ( IngresarEnergiaSolarDTO energiaSolarDTO ) {
        // Validación y asignación de valores a partir del DTO
        BigDecimal radiacionSolarPromedio = energiaSolarDTO.energia_solar().radiacionSolarPromedio();
        BigDecimal areaPaneles = energiaSolarDTO.energia_solar().areaPaneles();
        BigDecimal anguloInclinacion = energiaSolarDTO.energia_solar().anguloInclinacion();
        String nombreEnergia = energiaSolarDTO.energia_renovable().nombre();
        String ubicacion = energiaSolarDTO.plantaProduccion().ubicacion();
        BigDecimal capacidadInstalada = energiaSolarDTO.plantaProduccion().capacidad_instalada();
        BigDecimal eficiencia = energiaSolarDTO.plantaProduccion().eficiencia();
        Date fechaCreacion = ( Date ) energiaSolarDTO.plantaProduccion().fecha_creacion();
        String nombrePais = energiaSolarDTO.pais().nombre();
        BigDecimal energiaRequerida = energiaSolarDTO.pais().energiarequerida();
        System.out.println(energiaRequerida);
        BigDecimal nivelCovertura = energiaSolarDTO.pais().nivelcovertura();
        System.out.println(nivelCovertura);
        BigDecimal poblacion = energiaSolarDTO.pais().poblacion();
        BigDecimal eficienciaPaneles = energiaSolarDTO.energia_solar().eficienciaPaneles();
        
        // Llamar al procedimiento almacenado usando el repositorio
       energiaSolarRepository.insertEnergiaSolar(
                radiacionSolarPromedio,
                areaPaneles,
                anguloInclinacion,
                eficienciaPaneles,
                nombreEnergia,
                ubicacion,
                capacidadInstalada,
                eficiencia,
                fechaCreacion,
                nombrePais,
                energiaRequerida,
                nivelCovertura,
                poblacion );
    }
    
    public void actualizarEnergiaSolar ( int id, IngresarEnergiaSolarDTO energiaSolarDTO ) {
        // Validación y asignación de valores a partir del DTO
        BigDecimal radiacionSolarPromedio = energiaSolarDTO.energia_solar().radiacionSolarPromedio();
        BigDecimal areaPaneles = energiaSolarDTO.energia_solar().areaPaneles();
        BigDecimal anguloInclinacion = energiaSolarDTO.energia_solar().anguloInclinacion();
        String nombreEnergia = energiaSolarDTO.energia_renovable().nombre();
        String ubicacion = energiaSolarDTO.plantaProduccion().ubicacion();
        BigDecimal capacidadInstalada = energiaSolarDTO.plantaProduccion().capacidad_instalada();
        BigDecimal eficiencia = energiaSolarDTO.plantaProduccion().eficiencia();
        Date fechaCreacion = ( Date ) energiaSolarDTO.plantaProduccion().fecha_creacion();
        String nombrePais = energiaSolarDTO.pais().nombre();
        BigDecimal energiaRequerida = energiaSolarDTO.pais().energiarequerida();
        BigDecimal nivelCovertura = energiaSolarDTO.pais().nivelcovertura();
        BigDecimal poblacion = energiaSolarDTO.pais().poblacion();
        BigDecimal eficienciaPaneles = energiaSolarDTO.energia_solar().eficienciaPaneles();

        // Llamar al procedimiento almacenado usando el repositorio
        energiaSolarRepository.updateEnergiaSolar(
                id,
                radiacionSolarPromedio,
                areaPaneles,
                anguloInclinacion,
                eficienciaPaneles,
                nombreEnergia,
                ubicacion,
                capacidadInstalada,
                eficiencia,
                fechaCreacion,
                nombrePais,
                energiaRequerida,
                nivelCovertura,
                poblacion );
    }
}
