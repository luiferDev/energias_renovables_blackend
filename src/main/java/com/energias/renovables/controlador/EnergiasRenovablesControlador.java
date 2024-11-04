package com.energias.renovables.controlador;

import com.energias.renovables.modelo.energiasrenovables.EnergiaRenovableFactoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;

@RestController
@RequestMapping ( "/api/energias-renovables" )
public class EnergiasRenovablesControlador {
    private final EnergiaRenovableFactoryService energiaRenovableFactoryService;
    
    public EnergiasRenovablesControlador ( EnergiaRenovableFactoryService energiaRenovableFactoryService ) {
        this.energiaRenovableFactoryService = energiaRenovableFactoryService;
    }
    
    //    @GetMapping ( "/calcular-total" )
//    public ResponseEntity <BigDecimal> calcularProduccionEnergia ( @RequestParam String tipoenergia ) {
//        var s = energiaRenovableFactoryService.getCalculadoraEnergia( tipoenergia )
//                .calcularProduccionEnergia();
//        return ResponseEntity.ok( s );
//    }
//
    @GetMapping ( "/calcular" )
    public ResponseEntity <BigDecimal> calcularProduccionEnergia ( @RequestParam String tipoenergia,
                                                                   @RequestParam int id ) {
        var s = energiaRenovableFactoryService.calcularProduccionPorTipo( tipoenergia, id );
        BigDecimal resultadoCompacto = s.divide( new BigDecimal( "1000000" ),
                2, RoundingMode.HALF_UP );
        return ResponseEntity.ok( resultadoCompacto );
    }
}
