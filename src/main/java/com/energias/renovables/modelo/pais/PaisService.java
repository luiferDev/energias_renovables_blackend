package com.energias.renovables.modelo.pais;

import com.energias.renovables.modelo.energiasolar.EnergiaSolar;
import com.energias.renovables.modelo.energiasolar.EnergiaSolarDTO;
import com.energias.renovables.modelo.energiasrenovables.EnergiasRenovables;
import com.energias.renovables.modelo.energiasrenovables.EnergiasRenovablesDTO;
import com.energias.renovables.modelo.plantaproduccion.PlantaProduccion;
import com.energias.renovables.modelo.plantaproduccion.PlantaProduccionDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaisService {
    
    private final PaisRepository paisRepository;
    
    public PaisService ( PaisRepository paisRepository ) {
        this.paisRepository = paisRepository;
    }
    
    public List <PaisPlantaEnergiaSolarDTO> findAllPaisPlantaEnergiaSolar () {
        List <Object[]> results = paisRepository.findAllPaisPlantaEnergiaSolar();
        
        return results.stream().map( row -> {
            Pais pais = ( Pais ) row[ 0 ];
            PlantaProduccionDTO plantaProduccionSolar = new PlantaProduccionDTO(
                    ( ( PlantaProduccion ) row[ 1 ] ).getId(),
                    ( ( PlantaProduccion ) row[ 1 ] ).getUbicacion(),
                    ( ( PlantaProduccion ) row[ 1 ] ).getCapacidadInstalada(),
                    ( ( PlantaProduccion ) row[ 1 ] ).getEficiencia(),
                    ( ( PlantaProduccion ) row[ 1 ] ).getFechaCreacion()
            );
            EnergiasRenovablesDTO energiaRenovable = new EnergiasRenovablesDTO(
                    ( ( EnergiasRenovables ) row[ 2 ] ).getId(),
                    ( ( EnergiasRenovables ) row[ 2 ] ).getNombre(),
                    ( ( EnergiasRenovables ) row[ 2 ] ).getTipoEnergiaId().getId()
            );
            EnergiaSolarDTO energiaSolar = new EnergiaSolarDTO(
                    ( ( EnergiaSolar ) row[ 3 ] ).getId(),
                    ( ( EnergiaSolar ) row[ 3 ] ).getRadiacionSolarPromedio(),
                    ( ( EnergiaSolar ) row[ 3 ] ).getAreaPaneles(),
                    ( ( EnergiaSolar ) row[ 3 ] ).getAnguloInclinacion()
            );
            return new PaisPlantaEnergiaSolarDTO(
                    pais.getId(),
                    pais.getNombre(),
                    pais.getEnergiarequerida(),
                    pais.getNivelcovertura(),
                    pais.getPoblacion(),
                    plantaProduccionSolar,
                    energiaRenovable,
                    energiaSolar
            );
        } ).collect( Collectors.toList() );
        
    }
}
