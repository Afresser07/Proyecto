package co.ucentral.sistema.Proyecto_Estudiantes.dto;

import java.util.Date;

import co.ucentral.sistema.Proyecto_Estudiantes.entidades.Estudiante;
import co.ucentral.sistema.Proyecto_Estudiantes.entidades.Profesor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoCalificacion {
    private int codigo;
    private int nota;
    private Date fecha;
    private Estudiante estudiante;
    private Profesor profesor;
}
