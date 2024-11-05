package com.energias.renovables.modelo.energiasolar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import java.math.BigDecimal;
import java.sql.Date;

public interface EnergiaSolarRepository extends JpaRepository <EnergiaSolar, Integer> {
    
    @Procedure ( procedureName = "insertar_energia_solar" )
    void insertEnergiaSolar ( BigDecimal radiacionSolarPromedio,
                              BigDecimal areaPaneles,
                              BigDecimal anguloInclinacion,
                              String ubicacion,
                              String s, 
                              BigDecimal capacidadInstalada,
                              BigDecimal eficiencia,
                              Date time, String nombrePais,
                              BigDecimal energia,
                              BigDecimal nivel,
                              BigDecimal poblacion );
    
    @Procedure ( procedureName = "borrar_energia_solar" )
    void deleteEnergiaSolar ( Integer id );
}
