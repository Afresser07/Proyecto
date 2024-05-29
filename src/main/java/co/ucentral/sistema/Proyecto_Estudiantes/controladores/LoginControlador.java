package co.ucentral.sistema.Proyecto_Estudiantes.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.ucentral.sistema.Proyecto_Estudiantes.entidades.Estudiante;
import co.ucentral.sistema.Proyecto_Estudiantes.entidades.Profesor;
import co.ucentral.sistema.Proyecto_Estudiantes.servicios.ServicioEstudiante;
import co.ucentral.sistema.Proyecto_Estudiantes.servicios.ServicioProfesor;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginControlador {
    @Autowired
    private ServicioEstudiante servicioEstudiante;

    @Autowired
    private ServicioProfesor servicioProfesor;

    @GetMapping("/")
    public String formularioInicioSesion() {
        return "inicioSesion";
    }

    @PostMapping("/")
    public String inicioSesion(@RequestParam String email, @RequestParam int password, HttpSession session, Model modelo) {
        Estudiante estudiante = servicioEstudiante.findByEmail(email);
        if(estudiante!= null && estudiante.getCedula()==password){
            session.setAttribute("estudianteId", estudiante.getCedula());
            return "redirect:/AsignaturasEstudiante";
        }

        Profesor profesor = servicioProfesor.findByEmail(email);
        if(profesor!= null && profesor.getCedula()==password){
            session.setAttribute("profesorId", profesor.getCedula());
            return "redirect:/AsignaturasProfesor";
        }

        modelo.addAttribute("error", true);
        return "inicioSesion";
    }

    
}
