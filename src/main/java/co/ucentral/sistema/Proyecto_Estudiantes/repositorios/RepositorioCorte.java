package co.ucentral.sistema.Proyecto_Estudiantes.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.ucentral.sistema.Proyecto_Estudiantes.entidades.Corte;

@Repository
public interface RepositorioCorte extends JpaRepository<Corte,Integer>{

    public Corte findByCodigo(int id);

}
