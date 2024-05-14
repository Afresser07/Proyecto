package co.ucentral.sistema.Proyecto_Estudiantes.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import co.ucentral.sistema.Proyecto_Estudiantes.entidades.Actividad;
import co.ucentral.sistema.Proyecto_Estudiantes.operaciones.OperacionesActividad;

@Controller
public class ControladorActividad {
    
    @Autowired
    private OperacionesActividad operacionesActividad;

    @GetMapping("/ActividadProfesor")
    public String mostrarActividadProfesor(Model modelo) {
        modelo.addAttribute("actividades", operacionesActividad);
        return "listaActividad";
    }
    
    @GetMapping("/CrearActividad")
    public String mostrarFormularioActividad(Model modelo) {
        Actividad actividad = new Actividad();
        modelo.addAttribute("actividad", actividad);
        return "registroActividad";
    }
}
