package co.ucentral.sistema.Proyecto_Estudiantes.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import co.ucentral.sistema.Proyecto_Estudiantes.entidades.Profesor;
import co.ucentral.sistema.Proyecto_Estudiantes.operaciones.OperacionesProfesor;



@Controller
public class ControladorProfesor {
    
    @Autowired
    private OperacionesProfesor operacionesProfesor;

    @GetMapping({"/profesores","/"})
    public String listarProfesores(Model modelo) {
        modelo.addAttribute("profesores", operacionesProfesor);
        return "registroProfesor";
    }

    @GetMapping("/registroProfesor")
    public String registrarNuevoProfesor(Model modelo) {
        Profesor profesor = new Profesor();
        modelo.addAttribute("profesor", profesor);
        return "registroProfesor";
    }

    @PostMapping("/profesores")
    public String guardarProfesor(@ModelAttribute("profesor")Profesor profesor) {
        operacionesProfesor.guardarProfesor(profesor);
        return "redirect:/";
    }
    
    
    
}
