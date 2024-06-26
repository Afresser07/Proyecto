package co.ucentral.sistema.Proyecto_Estudiantes.operaciones;
import java.util.List;

import co.ucentral.sistema.Proyecto_Estudiantes.entidades.Profesor;

public interface OperacionesProfesor{

    public Profesor findByEmail(String email);

    public List<Profesor> listarTodosLosProfesores();

    public Profesor guardarProfesor(Profesor profesor);
}
