package com.energias.renovables.controlador;

import com.energias.renovables.modelo.energiasolar.EnergiaSolarDTO;
import com.energias.renovables.modelo.energiasolar.EnergiaSolarRepository;
import com.energias.renovables.modelo.energiasolar.EnergiaSolarService;
import com.energias.renovables.modelo.energiasolar.IngresarEnergiaSolarDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.math.BigDecimal;
import java.sql.Date;

@RestController
@RequestMapping ( "/api/energia-solar" )
@Tag ( name = "Energia Solar", description = "Api de energia solar" )
public class EnergiaSolarControlador {
    
    private final EnergiaSolarRepository energiaSolarRepository;
    
    private final EnergiaSolarService energiaSolarService;
    
    public EnergiaSolarControlador ( EnergiaSolarRepository energiaSolarRepository,
                                     EnergiaSolarService  energiaSolarService) {
        this.energiaSolarRepository = energiaSolarRepository;
        this.energiaSolarService = energiaSolarService;
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
    
    @DeleteMapping ( "/eliminar/{id}" )
    public ResponseEntity <String> eliminar ( @PathVariable Integer id ) {
        
        if ( !energiaSolarRepository.existsById( id) ) {
            return ResponseEntity.badRequest().body( "No existe el id" );
        }
        energiaSolarRepository.deleteEnergiaSolar( id );
        return ResponseEntity.ok( "Energía solar eliminada exitosamente" );
    }
    
    @PostMapping ( "/crear" )
    public ResponseEntity <String> crear (
            @RequestBody @Valid IngresarEnergiaSolarDTO energiaSolarDTO ) {
        // Retornar respuesta de éxito
        energiaSolarService.crearEnergiaSolar( energiaSolarDTO );
        return ResponseEntity.ok( "Energía solar creada exitosamente" );
    }
    
    @PutMapping ( "/actualizar/{id}" )
    public ResponseEntity <String> actualizar (
            @PathVariable Integer id,
            @RequestBody @Valid IngresarEnergiaSolarDTO energiaSolarDTO ) {
        // Verificar si el ID existe
        if ( !energiaSolarRepository.existsById( id ) ) {
            return ResponseEntity.badRequest().body( "No existe el id" );
        }
        energiaSolarService.actualizarEnergiaSolar( id, energiaSolarDTO );
        // Retornar respuesta de éxito
        return ResponseEntity.ok( "Energía solar actualizada exitosamente" );
    }
}

