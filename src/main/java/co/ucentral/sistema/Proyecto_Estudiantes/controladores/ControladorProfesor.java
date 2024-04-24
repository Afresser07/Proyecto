package co.ucentral.sistema.Proyecto_Estudiantes.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.GetMapping;

import co.ucentral.sistema.Proyecto_Estudiantes.entidades.Profesor;
import co.ucentral.sistema.Proyecto_Estudiantes.servicios.ServicioProfesor;

@Controller
public class ControladorProfesor {


    @Autowired
   private ServicioProfesor servicioProfesor;

   @GetMapping("/RegistroProfesor")
	public String guardarProfesor(@ModelAttribute("profesor") Profesor profesor) {
		//servicioProfesor.guardarProfesor(profesor);
		return "registro_profesor";
	}
}
