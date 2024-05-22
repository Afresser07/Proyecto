package co.ucentral.sistema.Proyecto_Estudiantes.operaciones;

import java.util.List;

import co.ucentral.sistema.Proyecto_Estudiantes.entidades.Actividad;

public interface OperacionesActividad {

    public List<Actividad> listarTodasLosActividades();

    public Actividad guardarActividad(Actividad actividad);

    public Actividad modificarActividad(Actividad actividad);
    
    public Actividad findByCodigo(int codigo);
}
