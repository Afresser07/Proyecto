package co.ucentral.sistema.Proyecto_Estudiantes.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.ucentral.sistema.Proyecto_Estudiantes.entidades.Asignatura;
import co.ucentral.sistema.Proyecto_Estudiantes.operaciones.OperacionesAsignatura;
import co.ucentral.sistema.Proyecto_Estudiantes.repositorios.RepositorioAsignatura;

@Service
public class ServicioAsignatura implements OperacionesAsignatura{

    @Autowired
    private RepositorioAsignatura repositorioAsignatura;

    @Override
    public List<Asignatura> listarTodasLosAsignaturas() {
        return repositorioAsignatura.findAll();
    }

    @Override
    public Asignatura guardarAsignatura(Asignatura asignatura) {
        return repositorioAsignatura.save(asignatura);
    }

    @Override
    public Asignatura modificarAsignatura(Asignatura asignatura) {
        return repositorioAsignatura.save(asignatura);
    }

    @Override
    public Asignatura findByCodigo(int codigo) {
        return repositorioAsignatura.findByCodigo(codigo);
    }
    
}
