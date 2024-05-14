package co.ucentral.sistema.Proyecto_Estudiantes.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import co.ucentral.sistema.Proyecto_Estudiantes.operaciones.OperacionesCalificacion;

@Controller
public class ControladorCalificacion {
    
    @Autowired
    private OperacionesCalificacion operacionesCalificacion;

    @GetMapping("/CalificacionsEstudiante")
    public String mostrarCalificacionsEstudiante(Model modelo) {
        modelo.addAttribute("Calificaciones", operacionesCalificacion);
        return "inicioEstudiante";
    }
}
