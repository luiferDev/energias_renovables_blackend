package com.energias.renovables.modelo.energiasrenovables;

import com.energias.renovables.modelo.CalcularProduccionEnergia;
import com.energias.renovables.modelo.biomasa.BiomasaService;
import com.energias.renovables.modelo.energiaeolica.EnergiaEolicaService;
import com.energias.renovables.modelo.energiageotermica.EnergiaGeotermicaService;
import com.energias.renovables.modelo.energiahidroelectrica.EnergiaHidroelectricaService;
import com.energias.renovables.modelo.energiasolar.EnergiaSolarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class EnergiaRenovableFactoryService {
    
    private final Map <String, CalcularProduccionEnergia> calculadoraEnergia = new HashMap <>();
    
    @Autowired
    public EnergiaRenovableFactoryService ( EnergiaSolarService energiaSolarService,
                                            BiomasaService biomasaService,
                                            EnergiaEolicaService energiaEolicaService,
                                            EnergiaGeotermicaService energiaGeotermicaService,
                                            EnergiaHidroelectricaService energiaHidroelectrica ) {
        calculadoraEnergia.put( "solar", energiaSolarService );
        calculadoraEnergia.put( "biomasa", biomasaService );
        calculadoraEnergia.put( "eolica", energiaEolicaService );
        calculadoraEnergia.put( "geotermica", energiaGeotermicaService );
        calculadoraEnergia.put( "hidroelectrica", energiaHidroelectrica );
    }
    
    public BigDecimal calcularProduccionPorTipo ( String tipoEnergia, int id ) {
        CalcularProduccionEnergia calculadora = calculadoraEnergia.get( tipoEnergia );
        if ( calculadora == null ) {
            throw new IllegalArgumentException( "Tipo de energía no válido: " + tipoEnergia );
        }
        return calculadora.calcularProduccionEnergiaId( id );
    }
}