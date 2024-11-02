package com.energias.renovables.controlador;

import com.energias.renovables.modelo.energiasolar.EnergiaSolar;
import com.energias.renovables.modelo.energiasolar.EnergiaSolarDTO;
import com.energias.renovables.modelo.energiasolar.EnergiaSolarRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ( "/api/energia-solar" )
public class EnergiaSolarControlador {
    
    private final EnergiaSolarRepository energiaSolarRepository;
    
    public EnergiaSolarControlador ( EnergiaSolarRepository energiaSolarRepository ) {
        this.energiaSolarRepository = energiaSolarRepository;
    }
    
    @GetMapping ( "/saludar" )
    public String saludar () {
        return "Hola Mundo";
    }
    
    @PostMapping
    public EnergiaSolar crear ( EnergiaSolar energiaSolar ) {
        return energiaSolarRepository.save( energiaSolar );
    }
    
    @GetMapping
    public ResponseEntity <EnergiaSolarDTO> obtenerTodos () {
        return ResponseEntity.ok( energiaSolarRepository.findAll()
                .stream()
                .map( energiaSolar -> new EnergiaSolarDTO(
                        energiaSolar.getId(),
                        energiaSolar.getRadiacionSolarPromedio(),
                        energiaSolar.getAreaPaneles(),
                        energiaSolar.getAnguloInclinacion()
                ) ).findFirst().orElseThrow() );
    }
}
