package co.ucentral.sistema.Proyecto_Estudiantes.operaciones;

import java.util.List;

import co.ucentral.sistema.Proyecto_Estudiantes.entidades.Estudiante;

public interface OperacionesEstudiante {
    public List<Estudiante> listarTodosLosEstudiantes();

    public Estudiante guardarEstudiante(Estudiante estudiante);
}
