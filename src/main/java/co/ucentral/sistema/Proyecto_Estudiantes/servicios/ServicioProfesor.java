package co.ucentral.sistema.Proyecto_Estudiantes.servicios;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.ucentral.sistema.Proyecto_Estudiantes.entidades.Profesor;
import co.ucentral.sistema.Proyecto_Estudiantes.repositorios.RepositorioProfesor;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ServicioProfesor implements Serializable{

    @Autowired
    private RepositorioProfesor repositorioProfesor;

    //public Profesor guardarProfesor(Profesor profesor){
      //  return repositorioProfesor.save(profesor);
    //}
}
