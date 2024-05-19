package co.ucentral.sistema.Proyecto_Estudiantes.dto;
import java.util.Collection;

import co.ucentral.sistema.Proyecto_Estudiantes.entidades.Actividad;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoCorte {
    private int codigo;
    private Collection<Actividad> actividades;
}
