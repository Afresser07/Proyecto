package co.ucentral.sistema.Proyecto_Estudiantes.operaciones;

import java.util.List;

import co.ucentral.sistema.Proyecto_Estudiantes.entidades.Asignatura;

public interface OperacionesAsignatura {
    
    public List<Asignatura> listarTodasLosAsignaturas();

    public Asignatura guardarAsignatura(Asignatura asignatura);

    public Asignatura modificarAsignatura(Asignatura asignatura);
}
