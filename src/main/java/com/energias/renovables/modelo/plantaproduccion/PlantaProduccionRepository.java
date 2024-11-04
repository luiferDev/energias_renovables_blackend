package com.energias.renovables.modelo.plantaproduccion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlantaProduccionRepository extends JpaRepository <PlantaProduccion, Integer> {
//    @Query ( "SELECT p  p.id, e e.nombre AS codigo, p.ubicacion, p.capacidad_instalada, p.eficiencia," +
//            " t t.nombre AS tipo_energia, s.radiacion_solar_promedio AS radiacion_solar" +
//            "s s.area_paneles, s.angulo_inclinacion, p.fecha_creacion" +
//            "FROM plantaproduccion p" +
//            "JOIN energiasrenovables e ON e.id = p.id" +
//            "JOIN tipoenergia t ON t.id = e.tipoenergiaid" +
//            "JOIN energiasolar s ON s.id = e.id" )
//    @Query( """
//            SELECT p, e, t, s FROM PlantaProduccion p
//            JOIN p.EnergiasRenovables e
//            JOIN e.TipoEnergia t
//            JOIN p.EnergiaSolar s
//            """)
//@Query("""
//            SELECT new com.energias.renovables.dto.PlantaProduccionSolarDTO(
//                p.id, e.nombre, p.ubicacion, p.capacidadInstalada, p.eficiencia,
//                t.nombre, s.radiacionSolarPromedio, s.areaPaneles, s.anguloInclinacion, p.fechaCreacion)
//            FROM PlantaProduccion p
//            JOIN p.EnergiasRenovables e
//            JOIN e.TipoEnergia t
//            JOIN e.EnergiaSolar s
//            """)
//    List<PlantaProduccionSolarDTO> findAllPlantaProduccionSolar ();
    
    @Query ( """
            SELECT p, e, s FROM PlantaProduccion p
            JOIN EnergiasRenovables e ON e.id = p.id
            JOIN EnergiaSolar s ON s.id = e.id
            """ )
    List <Object[]> findAllPlantaProduccionSolarWithEntities ();
    
    @Query ( """
            SELECT p, e, s FROM PlantaProduccion p
            JOIN EnergiasRenovables e ON e.id = p.id
            JOIN Biomasa s ON s.id = e.id
            """ )
    List <Object[]> findAllPlantaProduccionBiomasaWithEntities ();
    
}
