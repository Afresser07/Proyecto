package co.ucentral.sistema.Proyecto_Estudiantes.repositorios;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.ucentral.sistema.Proyecto_Estudiantes.entidades.Corte;

@Repository
public interface RepositorioCorte extends JpaRepository<Corte,Integer>{

    public Corte findByCodigo(int id);

    @Query("SELECT c FROM Corte c WHERE :fechaActual BETWEEN c.fechaApertura AND c.fechaCierre")
    Corte findByFechaActual(@Param("fechaActual") LocalDate fechaActual);
}
