package co.ucentral.sistema.Proyecto_Estudiantes.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.ucentral.sistema.Proyecto_Estudiantes.entidades.Actividad;

@Repository
public interface RepositorioActividad extends JpaRepository<Actividad,Integer>{

    public Actividad findByCodigo(int codigo);

    List<Actividad> findByAsignaturaId(Integer asignaturaId);
}
