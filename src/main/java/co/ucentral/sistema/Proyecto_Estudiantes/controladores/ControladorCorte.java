package co.ucentral.sistema.Proyecto_Estudiantes.controladores;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.ucentral.sistema.Proyecto_Estudiantes.entidades.Actividad;
import co.ucentral.sistema.Proyecto_Estudiantes.entidades.Corte;
import co.ucentral.sistema.Proyecto_Estudiantes.operaciones.OperacionesCorte;
import jakarta.servlet.http.HttpSession;

@Controller
public class ControladorCorte {
    @Autowired
    OperacionesCorte operacionesCorte;

    @GetMapping("/EstablecerFechas")
    public String establecerFechas(Model modelo) {
        modelo.addAttribute("cortes", operacionesCorte);
        return "fechasCortes";
    }

    @PostMapping("/EstablecerFechas")
    public String establecerFechas(@RequestParam String fechaAperturaCorte1,
                                    @RequestParam String fechaCierreCorte1,
                                    @RequestParam String fechaAperturaCorte2,
                                    @RequestParam String fechaCierreCorte2,
                                    @RequestParam String fechaAperturaCorte3,
                                    @RequestParam String fechaCierreCorte3) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        operacionesCorte.establecerFechasCorte(1, LocalDate.parse(fechaAperturaCorte1, formatter), LocalDate.parse(fechaCierreCorte1, formatter));
        operacionesCorte.establecerFechasCorte(2, LocalDate.parse(fechaAperturaCorte2, formatter), LocalDate.parse(fechaCierreCorte2, formatter));
        operacionesCorte.establecerFechasCorte(3, LocalDate.parse(fechaAperturaCorte3, formatter), LocalDate.parse(fechaCierreCorte3, formatter));

        return "redirect:/EstablecerFechas";
    }


    @GetMapping("/Corte/{id}/actividades")
    public String mostrarActividades(@RequestParam String fecha, Model modelo) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaIngresada = LocalDate.parse(fecha, formatter);
        Corte corte = operacionesCorte.obtenerCorteFecha(fechaIngresada);
        modelo.addAttribute("corte", corte);
        modelo.addAttribute("actividades", corte.getActividades());
        return "listarActividades";
    }
    

    @PostMapping("/Corte/{id}/agregarActividad")
    public String agregarActividad(@PathVariable("id") Integer id, @ModelAttribute Actividad actividad) {
        operacionesCorte.agregarActividadesCorte(id,actividad);
        return "redirect:/Corte/" + id + "/actividades";
    }

    @PostMapping("/GuardarFecha") //fecha actual
    public String guardarFecha(@RequestParam String fecha, HttpSession session) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaIngresada = LocalDate.parse(fecha, formatter);
        session.setAttribute("fechaActual", fechaIngresada);
        return "redirect:/AsignaturasProfesor";
    }
}
