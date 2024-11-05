package com.energias.renovables.controlador;

import com.energias.renovables.modelo.energiasolar.EnergiaSolar;
import com.energias.renovables.modelo.energiasolar.EnergiaSolarDTO;
import com.energias.renovables.modelo.energiasolar.EnergiaSolarRepository;
import com.energias.renovables.modelo.energiasolar.IngresarEnergiaSolarDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.Date;

@RestController
@RequestMapping ( "/api/energia-solar" )
@Tag ( name = "Energia Solar", description = "Api de energia solar" )
public class EnergiaSolarControlador {
    
    private final EnergiaSolarRepository energiaSolarRepository;
    
    public EnergiaSolarControlador ( EnergiaSolarRepository energiaSolarRepository ) {
        this.energiaSolarRepository = energiaSolarRepository;
    }
    
    @GetMapping ( "/saludar" )
    public String saludar () {
        return "Hola Mundo";
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
        
        // Llamar al procedimiento almacenado usando el repositorio
        energiaSolarRepository.insertEnergiaSolar(
                radiacionSolarPromedio,
                areaPaneles,
                anguloInclinacion,
                nombreEnergia,
                ubicacion,
                capacidadInstalada,
                eficiencia,
                fechaCreacion,
                nombrePais,
                energiaRequerida,
                nivelCovertura,
                poblacion
        );
        
        // Retornar respuesta de éxito
        return ResponseEntity.ok( "Energía solar creada exitosamente" );
    }
    
}

