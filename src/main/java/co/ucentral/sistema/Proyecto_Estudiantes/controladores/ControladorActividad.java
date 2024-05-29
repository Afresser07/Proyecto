package co.ucentral.sistema.Proyecto_Estudiantes.controladores;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.ucentral.sistema.Proyecto_Estudiantes.entidades.Actividad;
import co.ucentral.sistema.Proyecto_Estudiantes.entidades.Asignatura;
import co.ucentral.sistema.Proyecto_Estudiantes.entidades.Corte;
import co.ucentral.sistema.Proyecto_Estudiantes.operaciones.OperacionesActividad;
import co.ucentral.sistema.Proyecto_Estudiantes.operaciones.OperacionesAsignatura;
import co.ucentral.sistema.Proyecto_Estudiantes.operaciones.OperacionesCorte;
import jakarta.servlet.http.HttpSession;

@Controller
public class ControladorActividad {
    
    @Autowired
    private OperacionesActividad operacionesActividad;

    @Autowired
    private OperacionesAsignatura operacionesAsignatura;

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
    public String mostrarFormularioActividad(@RequestParam Integer asignaturaId, HttpSession session, Model modelo) {
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
                                @RequestParam LocalDate fechaLimite,
                                HttpSession session) {
            
            Optional<Asignatura> asignaturaOpt = Optional.ofNullable(operacionesAsignatura.findByCodigo(asignaturaId));

            Corte corte = operacionesCorte.obtenerCortePorFecha(fechaLimite);
    
            Asignatura asignatura = asignaturaOpt.get();
            
            Actividad nuevaActividad = new Actividad();
            nuevaActividad.setNombre(nombreActividad);
            nuevaActividad.setFecha(fechaLimite);
            nuevaActividad.setPuntos(puntos);
            nuevaActividad.setCorte(corte);
            nuevaActividad.setAsignatura(asignatura);
    
            operacionesActividad.guardarActividad(nuevaActividad);

        return "redirect:/AsignaturasProfesor";
    }
}
