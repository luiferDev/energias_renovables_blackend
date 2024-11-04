package com.energias.renovables.modelo.pais;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Arrays;
import java.util.List;

public interface PaisRepository extends JpaRepository <Pais, Integer> {
    @Query ( """
            SELECT c, p, e, s FROM Pais c
            JOIN PlantaProduccion p ON p.id = c.id
            JOIN EnergiasRenovables e ON e.id = p.id
            JOIN EnergiaSolar s ON s.id = e.id
            """ )
    List <Object[]> findAllPaisPlantaEnergiaSolar ();
    
    @Query ( """
            SELECT c, p, e, s FROM Pais c
            JOIN PlantaProduccion p ON p.id = c.id
            JOIN EnergiasRenovables e ON e.id = p.id
            JOIN Biomasa s ON s.id = e.id
            """ )
    List<Object[]> findAllPaisPlantaEnergiaBiomasa ();
}
