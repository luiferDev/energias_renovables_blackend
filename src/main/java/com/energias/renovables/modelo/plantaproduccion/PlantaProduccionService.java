package com.energias.renovables.modelo.plantaproduccion;

import com.energias.renovables.modelo.biomasa.Biomasa;
import com.energias.renovables.modelo.biomasa.BiomasaDTO;
import com.energias.renovables.modelo.energiasolar.EnergiaSolar;
import com.energias.renovables.modelo.energiasolar.EnergiaSolarDTO;
import com.energias.renovables.modelo.energiasrenovables.EnergiasRenovables;
import com.energias.renovables.modelo.energiasrenovables.EnergiasRenovablesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlantaProduccionService {
    
    @Autowired
    private PlantaProduccionRepository plantaProduccionRepository;
    
    public List <PlantaProduccionSolarDTO> findAllPlantaProduccionSolar () {
        List <Object[]> results = plantaProduccionRepository.findAllPlantaProduccionSolarWithEntities();
        
        return results.stream().map( row -> {
            PlantaProduccion plantaProduccion = ( PlantaProduccion ) row[ 0 ];
            EnergiasRenovablesDTO energiaRenovable = new EnergiasRenovablesDTO(
                    ( ( EnergiasRenovables ) row[ 1 ] ).getId(),
                    ( ( EnergiasRenovables ) row[ 1 ] ).getNombre(),
                    ( ( EnergiasRenovables ) row[ 1 ] ).getTipoEnergiaId().getId()
            );
            EnergiaSolarDTO energiaSolar = new EnergiaSolarDTO(
                    ( ( EnergiaSolar ) row[ 2 ] ).getId(),
                    ( ( EnergiaSolar ) row[ 2 ] ).getRadiacionSolarPromedio(),
                    ( ( EnergiaSolar ) row[ 2 ] ).getAreaPaneles(),
                    ( ( EnergiaSolar ) row[ 2 ] ).getAnguloInclinacion()
            );
            
            return new PlantaProduccionSolarDTO(
                    plantaProduccion.getId(),
                    plantaProduccion.getUbicacion(),
                    plantaProduccion.getCapacidadInstalada(),
                    plantaProduccion.getEficiencia(),
                    energiaRenovable,
                    energiaSolar,
                    plantaProduccion.getFechaCreacion()
            );
        } ).collect( Collectors.toList() );
    }
    public List <PlantaProduccionBiomasaDTO> findAllPlantaProduccionBiomasa () {
        List <Object[]> results = plantaProduccionRepository.findAllPlantaProduccionBiomasaWithEntities();

        return results.stream().map( row -> {
            PlantaProduccion plantaProduccion = ( PlantaProduccion ) row[ 0 ];
            EnergiasRenovablesDTO energiaRenovable = new EnergiasRenovablesDTO(
                    ( ( EnergiasRenovables ) row[ 1 ] ).getId(),
                    ( ( EnergiasRenovables ) row[ 1 ] ).getNombre(),
                    ( ( EnergiasRenovables ) row[ 1 ] ).getTipoEnergiaId().getId()
            );
            BiomasaDTO biomasa = new BiomasaDTO(
                    ( ( Biomasa ) row[ 2 ] ).getId(),
                    ( ( Biomasa ) row[ 2 ] ).getOrigen(),
                    ( ( Biomasa ) row[ 2 ] ).getContenidoEnergetico(),
                    ( ( Biomasa ) row[ 2 ] ).getCantidad(),
                    ( ( Biomasa ) row[ 2 ] ).getMetodoCoversion()
            );

            return new PlantaProduccionBiomasaDTO(
                    plantaProduccion.getId(),
                    plantaProduccion.getUbicacion(),
                    plantaProduccion.getCapacidadInstalada(),
                    plantaProduccion.getEficiencia(),
                    energiaRenovable,
                    biomasa,
                    plantaProduccion.getFechaCreacion()
            );
        } ).collect( Collectors.toList() );
    }
}
