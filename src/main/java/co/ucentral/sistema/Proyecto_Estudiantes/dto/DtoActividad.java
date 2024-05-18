package co.ucentral.sistema.Proyecto_Estudiantes.dto;

import java.util.Date;

import co.ucentral.sistema.Proyecto_Estudiantes.entidades.Asignatura;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class DtoActividad {
    private int codigo;
    private int corte;
    private int puntos;
    private Date fecha;
    private Asignatura asignatura;
}
