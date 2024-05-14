package co.ucentral.sistema.Proyecto_Estudiantes.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.ucentral.sistema.Proyecto_Estudiantes.entidades.Calificacion;

@Repository
public interface RepositorioCalificacion extends JpaRepository<Calificacion,Integer>{

    
}