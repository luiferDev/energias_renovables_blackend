package com.energias.renovables.controlador;

import com.energias.renovables.modelo.plantaproduccion.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ( "api/planta-produccion" )
public class PlantaProduccionControlador {
    
    private final PlantaProduccionService plantaProduccionService;

    public PlantaProduccionControlador ( PlantaProduccionService plantaProduccionService ) {
        this.plantaProduccionService = plantaProduccionService;
    }
    
    @GetMapping( "energia-solar" )
    public ResponseEntity <List <PlantaProduccionSolarDTO>> getPlantaProduccionSolar () {
        return ResponseEntity.ok( plantaProduccionService.findAllPlantaProduccionSolar() );
    }
    
    @GetMapping ( "biomasa" )
    public ResponseEntity <List <PlantaProduccionBiomasaDTO>> getPlantaProduccionBiomasa () {
        return ResponseEntity.ok( plantaProduccionService.findAllPlantaProduccionBiomasa() );
    }
    
}
