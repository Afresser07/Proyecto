package co.ucentral.sistema.Proyecto_Estudiantes.dto;

import java.util.Collection;
import java.util.Date;

import co.ucentral.sistema.Proyecto_Estudiantes.entidades.Estudiante;
import co.ucentral.sistema.Proyecto_Estudiantes.entidades.Profesor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoAsignatura {
    private int codigo;
    private String nombre;
    private Date periodoApertura;
    private Date periodoCierre;
    private Collection<Estudiante> estudiante;
    private Profesor profesor;
}
