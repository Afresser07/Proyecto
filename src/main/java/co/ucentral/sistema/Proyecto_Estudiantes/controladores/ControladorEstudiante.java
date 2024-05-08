package co.ucentral.sistema.Proyecto_Estudiantes.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import co.ucentral.sistema.Proyecto_Estudiantes.entidades.Estudiante;
import co.ucentral.sistema.Proyecto_Estudiantes.operaciones.OperacionesEstudiante;


@Controller
public class ControladorEstudiante {

    @Autowired
    private OperacionesEstudiante operacionesEstudiante;

    @GetMapping("/registroEstudiante")
    public String mostrarFormularioEstudiante(Model modelo) {
        Estudiante estudiante = new Estudiante();
        modelo.addAttribute("estudiante", estudiante);
        return "registroEstudiante";
    }

    @PostMapping("/registroEstudiante")
    public String guardarEstudiante(@ModelAttribute("Estudiante")Estudiante Estudiante) {
        operacionesEstudiante.guardarEstudiante(Estudiante);
        return "redirect:/";
    }
}
