package co.ucentral.sistema.Proyecto_Estudiantes.controladores;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.ucentral.sistema.Proyecto_Estudiantes.entidades.Actividad;
import co.ucentral.sistema.Proyecto_Estudiantes.entidades.Corte;
import co.ucentral.sistema.Proyecto_Estudiantes.operaciones.OperacionesActividad;
import co.ucentral.sistema.Proyecto_Estudiantes.operaciones.OperacionesCorte;
import jakarta.servlet.http.HttpSession;

@Controller
public class ControladorActividad {
    
    @Autowired
    private OperacionesActividad operacionesActividad;

    @Autowired
    private OperacionesCorte operacionesCorte;

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
    public String mostrarFormularioActividad(HttpSession session,Model modelo) {
        
        modelo.addAttribute("actividad", new Actividad());
        return "registroActividad";
    }


    @PostMapping("/CrearActividad")
    public String crearActividad(@RequestParam String nombreActividad,
                                @RequestParam int puntos,
                                @RequestParam String fecha,
                                HttpSession session, Model model) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaActividad = LocalDate.parse(fecha, formatter);

        LocalDate fechaActual = (LocalDate) session.getAttribute("fechaActual");
        if (fechaActual == null) {
            model.addAttribute("error", "No se ha ingresado una fecha actual válida.");
            return "redirect:/AsignaturasProfesor";
        }

        Corte corteActual;
        try {
            corteActual = operacionesCorte.obtenerCorteFecha(fechaActual);
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            return "redirect:/AsignaturasProfesor";
        }

        Actividad actividad = new Actividad();
        actividad.setNombre(nombreActividad);
        actividad.setPuntos(puntos);
        actividad.setCorte(corteActual);

        operacionesActividad.guardarActividad(actividad);

        return "redirect:/AsignaturasProfesor";
    }
}
