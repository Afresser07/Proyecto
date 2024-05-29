package co.ucentral.sistema.Proyecto_Estudiantes.controladores;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.ucentral.sistema.Proyecto_Estudiantes.entidades.Actividad;
import co.ucentral.sistema.Proyecto_Estudiantes.entidades.Asignatura;
import co.ucentral.sistema.Proyecto_Estudiantes.entidades.Calificacion;
import co.ucentral.sistema.Proyecto_Estudiantes.entidades.Estudiante;
import co.ucentral.sistema.Proyecto_Estudiantes.operaciones.OperacionesActividad;
import co.ucentral.sistema.Proyecto_Estudiantes.operaciones.OperacionesAsignatura;
import co.ucentral.sistema.Proyecto_Estudiantes.operaciones.OperacionesCalificacion;
import co.ucentral.sistema.Proyecto_Estudiantes.operaciones.OperacionesEstudiante;
import co.ucentral.sistema.Proyecto_Estudiantes.repositorios.RepositorioCalificacion;

@Controller
public class ControladorCalificacion {
    
    @Autowired
    private OperacionesCalificacion operacionesCalificacion;

    @Autowired
    private OperacionesEstudiante operacionesEstudiante;

    @Autowired
    private OperacionesActividad operacionesActividad;

    @Autowired
    private OperacionesAsignatura operacionesAsignatura;

    @Autowired
    private RepositorioCalificacion repositorioCalificacion;

    @GetMapping("/CalificacionProfesor/{asignaturaId}")
    public String verCalificaciones(@PathVariable Integer asignaturaId, Model model) {
        Asignatura asignatura = operacionesAsignatura.findByCodigo(asignaturaId);
        model.addAttribute("asignatura", asignatura);
        return "visualizarCalificaciones";
    }

    @GetMapping("/CalificacionProfesor/{asignaturaId}/corte")
    public String verCalificacionesPorCorte(@PathVariable Integer asignaturaId, @RequestParam Integer corteId, Model model) {
        Asignatura asignatura = operacionesAsignatura.findByCodigo(asignaturaId);
        List<Calificacion> calificaciones = repositorioCalificacion.findByAsignaturaIdAndCorteId(asignaturaId, corteId);
        Set<Estudiante> estudiante = new HashSet<>(operacionesEstudiante.findByAsignaturasCodigo(asignaturaId));
        model.addAttribute("asignatura", asignatura);
        model.addAttribute("calificaciones", calificaciones);
        model.addAttribute("estudiante", estudiante);
        model.addAttribute("operaciones", operacionesCalificacion);
        return "visualizarCalificaciones";
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
    public String guardarCalificacion(@RequestParam Integer actividadId, @RequestParam Integer estudianteId, @RequestParam Integer asignaturaId, @RequestParam Integer nota, Model modelo) {
        Actividad actividad = operacionesActividad.findByCodigo(actividadId);
        Estudiante estudiante = operacionesEstudiante.findByCedula(estudianteId);
        Asignatura asignatura = operacionesAsignatura.findByCodigo(asignaturaId);

        if (actividad == null) {
            modelo.addAttribute("error", "La actividad no existe.");
            return "registroCalificaciones";
        }
        if (estudiante == null) {
            modelo.addAttribute("error", "El estudiante no existe.");
            return "registroCalificaciones";
        }
        if (asignatura == null) {
            modelo.addAttribute("error", "La asignatura no existe.");
            return "registroCalificaciones";
        }

        if (nota > actividad.getPuntos()) {
            modelo.addAttribute("error", "Los puntos perdidos no pueden exceder los puntos máximos de la actividad.");
            return "registroCalificaciones";
        }

        

        Calificacion calificacion = new Calificacion();
        calificacion.setActividad(actividad);
        calificacion.setEstudiante(estudiante);
        calificacion.setNota(nota);

        operacionesCalificacion.guardarCalificacion(calificacion);

        return "redirect:/AsignaturasProfesor";
    }


    @GetMapping("/estudiante/calificaciones{estudianteId}")
    public String verCalificacionesEstudiante(@RequestParam("estudianteId") Integer estudianteId, @RequestParam("asignaturaId") Integer asignaturaId, Model model) {
        Estudiante estudiante = operacionesEstudiante.findByCedula(estudianteId);
        Asignatura asignatura = operacionesAsignatura.findByCodigo(asignaturaId);
        
        List<Calificacion> calificaciones = repositorioCalificacion.findByEstudianteAndAsignatura(estudianteId, asignaturaId);
        
        model.addAttribute("calificaciones", calificaciones);
        model.addAttribute("asignatura", asignatura);
        model.addAttribute("estudiante", estudiante);

        return "calificacionEstudiante";
    }
}
