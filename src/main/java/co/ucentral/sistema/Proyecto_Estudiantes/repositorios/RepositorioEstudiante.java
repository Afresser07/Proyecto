package co.ucentral.sistema.Proyecto_Estudiantes.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.ucentral.sistema.Proyecto_Estudiantes.entidades.Estudiante;

@Repository
public interface RepositorioEstudiante extends JpaRepository<Estudiante, Integer>{

    public Estudiante findByEmail(String email);

    public Estudiante findByCedula(int cedula);

    public List<Estudiante> findByAsignaturasCodigo(Integer asignaturaId);
}