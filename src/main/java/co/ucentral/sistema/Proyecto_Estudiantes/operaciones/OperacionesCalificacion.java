package co.ucentral.sistema.Proyecto_Estudiantes.operaciones;

import java.util.List;
import java.util.Set;

import co.ucentral.sistema.Proyecto_Estudiantes.entidades.Calificacion;
import co.ucentral.sistema.Proyecto_Estudiantes.entidades.Estudiante;

public interface OperacionesCalificacion {

    public List<Calificacion> listarTodasLosCalificaciones();

    public Calificacion guardarCalificacion(Calificacion Calificacion);

    public Calificacion modificarCalificacion(Calificacion Calificacion);

    public Calificacion findByCodigo(int codigo);

    public List<Calificacion> findByAsignaturaIdAndCorteId(Integer asignaturaId, Integer corteId);

    public Integer sumarPuntosPerdidos(Set<Estudiante> estudiantes, List<Calificacion> calificaciones);
}
