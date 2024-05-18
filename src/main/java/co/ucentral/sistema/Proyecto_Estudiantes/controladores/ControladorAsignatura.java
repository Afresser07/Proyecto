package co.ucentral.sistema.Proyecto_Estudiantes.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.ucentral.sistema.Proyecto_Estudiantes.entidades.Asignatura;
import co.ucentral.sistema.Proyecto_Estudiantes.entidades.Estudiante;
import co.ucentral.sistema.Proyecto_Estudiantes.operaciones.OperacionesAsignatura;
import co.ucentral.sistema.Proyecto_Estudiantes.operaciones.OperacionesEstudiante;


@Controller
public class ControladorAsignatura {
    
    @Autowired
    private OperacionesAsignatura operacionesAsignatura;

    @Autowired
    private OperacionesEstudiante operacionesEstudiante;

    @GetMapping("/AsignaturasEstudiante")
    public String mostrarAsignaturasEstudiante(Model modelo) {
        modelo.addAttribute("asignaturas", operacionesAsignatura);
        return "inicioEstudiante";
    }

    @GetMapping("/AsignaturasProfesor")
    public String mostrarAsignaturasProfesor(Model modelo) {
        modelo.addAttribute("asignaturas", operacionesAsignatura.listarTodasLosAsignaturas());
        return "inicioProfesor";
    }
    
    @GetMapping("/CrearAsignatura")
    public String mostrarFormularioAsignatura(Model modelo) {
        Asignatura asignatura = new Asignatura();
        modelo.addAttribute("asignatura", asignatura);
        return "registroAsignatura";
    }
    
    @PostMapping("/CrearAsignatura")
    public String guardarAsignatura(@ModelAttribute("Asignatura")Asignatura asignatura) {
        operacionesAsignatura.guardarAsignatura(asignatura);
        return "redirect:/AsignaturasProfesor";
    }

    @GetMapping("/Asignatura/{id}/estudiantes")
    public String mostrarEstudiantesParaAsignatura(@PathVariable("id") int idAsignatura, Model modelo) {
        Asignatura asignatura = operacionesAsignatura.findByCodigo(idAsignatura);
        List<Estudiante> estudiantes = operacionesEstudiante.listarTodosLosEstudiantes();
        modelo.addAttribute("asignatura", asignatura);
        modelo.addAttribute("estudiantes", estudiantes);
        return "listarEstudiantes";
    }

    @PostMapping("/Asignatura/{id}/AgregarEstudiantes")
    public String agregarEstudianteAsignatura(@RequestParam("asignaturaId") Integer idAsignatura, @RequestParam("estudianteIds") List<Integer> estudianteIds) {
        operacionesAsignatura.agregarEstudianteAsignatura(idAsignatura,estudianteIds);
        return "redirect:/AsignaturasProfesor";
    }
    
}
