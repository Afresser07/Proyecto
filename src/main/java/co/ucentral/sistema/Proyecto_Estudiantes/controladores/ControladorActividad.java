package co.ucentral.sistema.Proyecto_Estudiantes.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import co.ucentral.sistema.Proyecto_Estudiantes.entidades.Actividad;
import co.ucentral.sistema.Proyecto_Estudiantes.operaciones.OperacionesActividad;

@Controller
public class ControladorActividad {
    
    @Autowired
    private OperacionesActividad operacionesActividad;

    @GetMapping("/ActividadProfesor")
    public String mostrarActividadProfesor(Model modelo) {
        modelo.addAttribute("actividades", operacionesActividad);
        return "listaActividadProfesor";
    }

    @GetMapping("/ActividadEstudiante")
    public String mostrarActividadEstudiante(Model modelo) {
        modelo.addAttribute("actividades", operacionesActividad);
        return "listaActividadEstudiante";
    }
    
    @GetMapping("/CrearActividad")
    public String mostrarFormularioActividad(Model modelo) {
        Actividad actividad = new Actividad();
        modelo.addAttribute("actividad", actividad);
        return "registroActividad";
    }

    @PostMapping("/CrearActividad")
    public String guardarActividad(@ModelAttribute("Actividad")Actividad actividad) {
        operacionesActividad.guardarActividad(actividad);
        return "redirect:/ActividadProfesor";
    }
}
