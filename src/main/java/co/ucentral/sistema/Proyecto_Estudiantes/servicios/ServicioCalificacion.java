package co.ucentral.sistema.Proyecto_Estudiantes.servicios;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.ucentral.sistema.Proyecto_Estudiantes.entidades.Calificacion;
import co.ucentral.sistema.Proyecto_Estudiantes.entidades.Estudiante;
import co.ucentral.sistema.Proyecto_Estudiantes.operaciones.OperacionesCalificacion;
import co.ucentral.sistema.Proyecto_Estudiantes.repositorios.RepositorioCalificacion;

@Service
public class ServicioCalificacion implements OperacionesCalificacion{

    @Autowired
    private RepositorioCalificacion repositorioCalificacion;

    @Override
    public List<Calificacion> listarTodasLosCalificaciones() {
        return repositorioCalificacion.findAll();
    }

    @Override
    public Calificacion guardarCalificacion(Calificacion calificacion) {
        return repositorioCalificacion.save(calificacion);
    }

    @Override
    public Calificacion modificarCalificacion(Calificacion calificacion) {
        return repositorioCalificacion.save(calificacion);
    }

    @Override
    public Calificacion findByCodigo(int codigo) {
        return repositorioCalificacion.findByCodigo(codigo);
    }

    @Override
    public List<Calificacion> findByAsignaturaIdAndCorteId(Integer asignaturaId, Integer corteId) {
        return repositorioCalificacion.findByAsignaturaIdAndCorteId(asignaturaId, corteId);
    }

    @Override
    public Integer sumarPuntosPerdidos(Set<Estudiante> estudiantes, List<Calificacion> calificaciones) {
        int totalPuntosPerdidos = 0;
        for (Estudiante estudiante : estudiantes) {
            int puntosPerdidosEstudiante = calificaciones.stream()
                    .filter(c -> c.getEstudiante().getCedula() == estudiante.getCedula())
                    .mapToInt(Calificacion::getNota)
                    .sum();
            totalPuntosPerdidos += puntosPerdidosEstudiante;
        }
        return totalPuntosPerdidos;
    }
    
}
