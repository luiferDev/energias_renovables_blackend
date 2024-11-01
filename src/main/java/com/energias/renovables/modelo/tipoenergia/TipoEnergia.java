package com.energias.renovables.modelo.tipoenergia;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table ( name = "tipoenergia" )
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TipoEnergia {
    
    @Id
    private int id;
    @Enumerated( EnumType.STRING )
    private Tipo nombre;
    
}
