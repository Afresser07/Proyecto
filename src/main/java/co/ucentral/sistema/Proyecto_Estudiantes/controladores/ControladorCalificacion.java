package co.ucentral.sistema.Proyecto_Estudiantes.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.ucentral.sistema.Proyecto_Estudiantes.entidades.Actividad;
import co.ucentral.sistema.Proyecto_Estudiantes.entidades.Calificacion;
import co.ucentral.sistema.Proyecto_Estudiantes.entidades.Estudiante;
import co.ucentral.sistema.Proyecto_Estudiantes.operaciones.OperacionesActividad;
import co.ucentral.sistema.Proyecto_Estudiantes.operaciones.OperacionesCalificacion;
import co.ucentral.sistema.Proyecto_Estudiantes.operaciones.OperacionesEstudiante;

@Controller
public class ControladorCalificacion {
    
    @Autowired
    private OperacionesCalificacion operacionesCalificacion;

    @Autowired
    private OperacionesEstudiante operacionesEstudiante;

    @Autowired
    private OperacionesActividad operacionesActividad;

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
    public String mostrarFormularioCalificacion(@RequestParam Integer asignaturaId, Model model) {
        List<Actividad> actividades = operacionesActividad.findByAsignaturaId(asignaturaId);
        List<Estudiante> estudiantes = operacionesEstudiante.findByAsignaturasCodigo(asignaturaId);
        model.addAttribute("actividades", actividades);
        model.addAttribute("estudiantes", estudiantes);
        model.addAttribute("asignaturaId", asignaturaId);
        return "registroCalificaciones";
    }

    @PostMapping("/CrearCalificacion")
    public String guardarCalificacion(@RequestParam Integer actividadId, @RequestParam Integer estudianteId, @RequestParam Integer valor, @RequestParam Integer asignaturaId) {
        Actividad actividad = operacionesActividad.findByCodigo(actividadId);
        Estudiante estudiante = operacionesEstudiante.findByCedula(estudianteId);

        Calificacion calificacion = new Calificacion();
        calificacion.setActividad(actividad);
        calificacion.setEstudiante(estudiante);
        calificacion.setNota(valor);
        
        operacionesCalificacion.guardarCalificacion(calificacion);
        return "redirect:/AsignaturasProfesor";
    }
}
