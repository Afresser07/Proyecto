package co.ucentral.sistema.Proyecto_Estudiantes.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.ucentral.sistema.Proyecto_Estudiantes.entidades.Profesor;
import co.ucentral.sistema.Proyecto_Estudiantes.operaciones.OperacionesProfesor;
import co.ucentral.sistema.Proyecto_Estudiantes.repositorios.RepositorioProfesor;;

@Service
public class ServicioProfesor implements OperacionesProfesor{


    @Autowired
    private RepositorioProfesor repositorioProfesor;

    @Override
    public List<Profesor> listarTodosLosProfesores() {
        return repositorioProfesor.findAll();
    }

    @Override
    public Profesor guardarProfesor(Profesor profesor) {
        return repositorioProfesor.save(profesor);
    }

}
