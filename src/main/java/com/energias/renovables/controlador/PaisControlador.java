package com.energias.renovables.controlador;

import com.energias.renovables.modelo.pais.PaisPlantaEnergiaBiomasa;
import com.energias.renovables.modelo.pais.PaisPlantaEnergiaSolarDTO;
import com.energias.renovables.modelo.pais.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ( "api/pais" )
public class PaisControlador {
    
    @Autowired
    PaisService paisService;
    
    @GetMapping ( "energia-solar" )
    public ResponseEntity <List <PaisPlantaEnergiaSolarDTO>> getPaisEnergiaSolar () {
        return ResponseEntity.ok( paisService.findAllPaisPlantaEnergiaSolar() );
    }
    
    @GetMapping ( "biomasa" )
    public ResponseEntity <List <PaisPlantaEnergiaBiomasa>> getPaisBiomasa () {
        return ResponseEntity.ok( paisService.findAllPaisPlantaEnergiaBiomasa() );
    }
}
