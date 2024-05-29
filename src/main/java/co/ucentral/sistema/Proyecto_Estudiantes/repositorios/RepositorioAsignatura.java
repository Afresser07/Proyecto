package co.ucentral.sistema.Proyecto_Estudiantes.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.ucentral.sistema.Proyecto_Estudiantes.entidades.Asignatura;

@Repository
public interface RepositorioAsignatura extends JpaRepository<Asignatura,Integer>{

    public Asignatura findByCodigo(int codigo);
}
