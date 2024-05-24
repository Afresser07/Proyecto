package co.ucentral.sistema.Proyecto_Estudiantes.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.ucentral.sistema.Proyecto_Estudiantes.entidades.Actividad;
import co.ucentral.sistema.Proyecto_Estudiantes.operaciones.OperacionesActividad;
import co.ucentral.sistema.Proyecto_Estudiantes.repositorios.RepositorioActividad;

@Service
public class ServicioActividad implements OperacionesActividad{

    @Autowired
    private RepositorioActividad repositorioActividad;

    @Override
    public List<Actividad> listarTodasLosActividades() {
        return repositorioActividad.findAll();
    }

    @Override
    public Actividad guardarActividad(Actividad actividad) {
        return repositorioActividad.save(actividad);
    }

    @Override
    public Actividad modificarActividad(Actividad actividad) {
        return repositorioActividad.save(actividad);
    }
    
    @Override
    public Actividad findByCodigo(int codigo) {
        return repositorioActividad.findByCodigo(codigo);
    }

    @Override
    public List<Actividad> findByAsignaturaId(Integer asignaturaId) {
        return repositorioActividad.findByAsignaturaCodigo(asignaturaId);
    }
}
