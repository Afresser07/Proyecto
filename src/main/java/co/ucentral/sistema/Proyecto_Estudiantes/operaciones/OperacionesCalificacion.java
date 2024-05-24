package co.ucentral.sistema.Proyecto_Estudiantes.operaciones;

import java.util.List;

import co.ucentral.sistema.Proyecto_Estudiantes.entidades.Calificacion;

public interface OperacionesCalificacion {

    public List<Calificacion> listarTodasLosCalificaciones();

    public Calificacion guardarCalificacion(Calificacion Calificacion);

    public Calificacion modificarCalificacion(Calificacion Calificacion);

    public Calificacion findByCodigo(int codigo);

    public List<Calificacion> findByAsignaturaIdAndCorteId(Integer asignaturaId, Integer corteId);
}
