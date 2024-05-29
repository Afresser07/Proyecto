package co.ucentral.sistema.Proyecto_Estudiantes.servicios;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.ucentral.sistema.Proyecto_Estudiantes.entidades.Actividad;
import co.ucentral.sistema.Proyecto_Estudiantes.entidades.Corte;
import co.ucentral.sistema.Proyecto_Estudiantes.operaciones.OperacionesCorte;
import co.ucentral.sistema.Proyecto_Estudiantes.repositorios.RepositorioActividad;
import co.ucentral.sistema.Proyecto_Estudiantes.repositorios.RepositorioCorte;

@Service
public class ServicioCorte implements OperacionesCorte{

    @Autowired
    RepositorioCorte repositorioCorte;

    @Autowired
    RepositorioActividad repositorioActividad;

    @Override
    public Corte guardarCorte(Corte corte) {
        return repositorioCorte.save(corte);
    }

    @Override
    public List<Corte> listarTodosLosCortes() {
        return repositorioCorte.findAll();
    }

    @Override
    public void agregarActividadesCorte(Integer corteId, Actividad actividad) {
        Corte corte = repositorioCorte.findByCodigo(corteId);
        actividad.setCorte(corte);
        repositorioActividad.save(actividad);
    }

    @Override
    public Corte findByCodigo(int id) {
        return repositorioCorte.findByCodigo(id);
    }

    @Override
    public Corte obtenerCorteFecha(LocalDate fecha) {
        List<Corte> cortes = repositorioCorte.findAll();
        for (Corte corte : cortes) {
            if ((fecha.isEqual(corte.getFechaApertura()) || fecha.isAfter(corte.getFechaApertura())) &&
                (fecha.isEqual(corte.getFechaCierre()) || fecha.isBefore(corte.getFechaCierre()))) {
                return corte;
            }
        }
        throw new IllegalArgumentException("No hay corte válido para la fecha ingresada");
    }

    @Override
    public void establecerFechasCorte(Integer corteId, LocalDate fechaApertura, LocalDate fechaCierre) {
        Corte corte = repositorioCorte.findByCodigo(corteId);
        if (corte == null) {
            corte = new Corte();
            corte.setCodigo(corteId);
        }
        corte.setFechaApertura(fechaApertura);
        corte.setFechaCierre(fechaCierre);
        repositorioCorte.save(corte);
    }
    
    @Override
    public Corte obtenerCortePorFecha(LocalDate fecha) {
        return repositorioCorte.findByFechaActual(fecha);
    }
}
