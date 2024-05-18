package co.ucentral.sistema.Proyecto_Estudiantes.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.ucentral.sistema.Proyecto_Estudiantes.entidades.Estudiante;
import co.ucentral.sistema.Proyecto_Estudiantes.operaciones.OperacionesEstudiante;
import co.ucentral.sistema.Proyecto_Estudiantes.repositorios.RepositorioEstudiante;

@Service
public class ServicioEstudiante implements OperacionesEstudiante{

    @Autowired
    private RepositorioEstudiante repositorioEstudiante;

    @Override
    public List<Estudiante> listarTodosLosEstudiantes() {
        return repositorioEstudiante.findAll();
    }

    @Override
    public Estudiante guardarEstudiante(Estudiante estudiante) {
        return repositorioEstudiante.save(estudiante);
    }

    @Override
    public Estudiante findByEmail(String email) {
        return repositorioEstudiante.findByEmail(email);
    }
}
