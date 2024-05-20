package co.ucentral.sistema.Proyecto_Estudiantes.controladores;

import java.time.LocalDate;

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
    public String mostrarFormularioActividad(@RequestParam Long asignaturaId, HttpSession session, Model modelo) {
        LocalDate fechaActual = (LocalDate) session.getAttribute("fechaActual");
        Corte corte = operacionesCorte.obtenerCortePorFecha(fechaActual);
        modelo.addAttribute("corte", corte);
        modelo.addAttribute("fechaActividad", fechaActual);
        modelo.addAttribute("asignaturaId", asignaturaId);
        return "registroActividad";
    }


    @PostMapping("/CrearActividad")
    public String crearActividad(@RequestParam String nombreActividad,
                                @RequestParam int puntos,
                                @RequestParam Integer asignaturaId,
                                HttpSession session) {
            LocalDate fechaActividad = (LocalDate) session.getAttribute("fechaActual");
            Corte corte = operacionesCorte.obtenerCortePorFecha(fechaActividad);
    
            Actividad nuevaActividad = new Actividad();
            nuevaActividad.setNombre(nombreActividad);
            nuevaActividad.setFecha(fechaActividad);
            nuevaActividad.setPuntos(puntos);
            nuevaActividad.setCorte(corte);
            nuevaActividad.setAsignaturaId(asignaturaId);
    
            operacionesActividad.guardarActividad(nuevaActividad);

        return "redirect:/AsignaturasProfesor";
    }
}
