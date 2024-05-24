package co.ucentral.sistema.Proyecto_Estudiantes.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.ucentral.sistema.Proyecto_Estudiantes.entidades.Calificacion;

@Repository
public interface RepositorioCalificacion extends JpaRepository<Calificacion,Integer>{

    public Calificacion findByCodigo(int codigo);

    @Query("SELECT c FROM Calificacion c WHERE c.actividad.asignatura.codigo = :asignaturaId AND c.actividad.corte.codigo = :corteId")
    List<Calificacion> findByAsignaturaIdAndCorteId(@Param("asignaturaId") int asignaturaId, @Param("corteId") int corteId);

    @Query("SELECT c FROM Calificacion c WHERE c.estudiante.cedula = :estudianteId AND c.actividad.asignatura.codigo = :asignaturaId")
    List<Calificacion> findByEstudianteAndAsignatura(@Param("estudianteId") Integer estudianteId, @Param("asignaturaId") Integer asignaturaId);

}