package co.ucentral.sistema.Proyecto_Estudiantes.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import co.ucentral.sistema.Proyecto_Estudiantes.entidades.Calificacion;
import co.ucentral.sistema.Proyecto_Estudiantes.operaciones.OperacionesCalificacion;

@Controller
public class ControladorCalificacion {
    
    @Autowired
    private OperacionesCalificacion operacionesCalificacion;

    @GetMapping("/CalificacionEstudiante")
    public String mostrarCalificacionesEstudiante(Model modelo) {
        modelo.addAttribute("Calificaciones", operacionesCalificacion);
        return "calificacionEstudiante";
    }

    @GetMapping("/CalificacionProfesor")
    public String mostrarCalificacionesProfesor(Model modelo) {
        modelo.addAttribute("Calificaciones", operacionesCalificacion);
        return "calificacionProfesor";
    }

    @GetMapping("/CrearCalificacion")
    public String mostrarFormularioCalificacion(Model modelo) {
        Calificacion Calificacion = new Calificacion();
        modelo.addAttribute("calificaciones", Calificacion);
        return "registroCalificacion";
    }

    @PostMapping("/CrearCalificacion")
    public String guardarCalificacion(@ModelAttribute("Calificacion")Calificacion Calificacion) {
        operacionesCalificacion.guardarCalificacion(Calificacion);
        return "redirect:/CalificacionProfesor";
    }
}
