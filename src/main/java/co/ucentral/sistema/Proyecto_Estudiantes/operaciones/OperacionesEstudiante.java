package co.ucentral.sistema.Proyecto_Estudiantes.operaciones;

import java.util.List;

import co.ucentral.sistema.Proyecto_Estudiantes.entidades.Estudiante;

public interface OperacionesEstudiante{

    public Estudiante findByEmail(String email);

    public List<Estudiante> listarTodosLosEstudiantes();

    public Estudiante guardarEstudiante(Estudiante estudiante);

    public Estudiante findByCedula(int cedula);

    public List<Estudiante> findByAsignaturasCodigo(Integer asignaturaId);
}
