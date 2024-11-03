package com.energias.renovables.controlador;

import com.energias.renovables.modelo.plantaproduccion.PlantaProduccion;
import com.energias.renovables.modelo.plantaproduccion.PlantaProduccionRepository;
import com.energias.renovables.modelo.plantaproduccion.PlantaProduccionService;
import com.energias.renovables.modelo.plantaproduccion.PlantaProduccionSolarDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ( "api/planta-produccion" )
public class PlantaProduccionControlador {
    
    @Autowired
    PlantaProduccionService plantaProduccionService;
    
    @GetMapping
    public ResponseEntity <List <PlantaProduccionSolarDTO>> getPlantaProduccion () {
        return ResponseEntity.ok( plantaProduccionService.findAllPlantaProduccionSolar() );
    }
    
}
