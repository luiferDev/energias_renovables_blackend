package com.energias.renovables.modelo.energiasrenovables;

import org.springframework.stereotype.Service;

@Service
public class EnergiaPrincipalService {
    private final EnergiaRenovableFactoryService energiaRenovableFactoryService;
    
    public EnergiaPrincipalService ( EnergiaRenovableFactoryService energiaRenovableFactoryService ) {
        this.energiaRenovableFactoryService = energiaRenovableFactoryService;
    }
    
    public void calcularProduccionEnergia ( String tipoEnergia, int id ) {
        energiaRenovableFactoryService.calcularProduccionPorTipo( tipoEnergia, id );
    }
}
