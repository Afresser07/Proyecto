package co.ucentral.sistema.Proyecto_Estudiantes.operaciones;

import java.time.LocalDate;
import java.util.List;

import co.ucentral.sistema.Proyecto_Estudiantes.entidades.Actividad;
import co.ucentral.sistema.Proyecto_Estudiantes.entidades.Corte;

public interface OperacionesCorte {

    public Corte guardarCorte(Corte corte);

    public List<Corte> listarTodosLosCortes();

    public void agregarActividadesCorte(Integer corteId,Actividad actividad);

    public Corte findByCodigo(int id);

    public Corte obtenerCorteFecha(LocalDate fecha);

    public void establecerFechasCorte(Integer corteId, LocalDate fechaApertura, LocalDate fechaCierre);

    public Corte obtenerCortePorFecha(LocalDate fecha);
}
