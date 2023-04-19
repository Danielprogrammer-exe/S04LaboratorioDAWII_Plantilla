package com.cibertec.personalplanta.controller;

import com.cibertec.personalplanta.model.Vacacion;
import com.cibertec.personalplanta.service.VacacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class VacacionController {

    @Autowired
    private VacacionService vacacionService;

    @GetMapping("/vacaciones")
    public String cargarVacaciones( Model model){
        List<Vacacion> vacaciones = vacacionService.listaVacaciones();
        model.addAttribute("listaVacaciones",vacaciones);

        return "vacaciones/vacaciones";
    }

    @GetMapping("/nuevaVacacion")
    public String nuevaVacacion( Model model) {
        Vacacion vacacion = new Vacacion();
        model.addAttribute("vacacion", vacacion);

        return "vacaciones/nuevaVacacion";
    }

    @PostMapping("/guardarVacacion")
    public String guardarVacacion(@ModelAttribute("vacacion") Vacacion vacacion){
        vacacionService.guardarVacaciones(vacacion);

        return "redirect:/vacaciones";
    }

    @GetMapping("/actualizarVacacion/{id}")
    public String actualizarVacacion(@ModelAttribute(value = "id") long id,Model model) {
        Vacacion vacacion = vacacionService.obtenerVacaciones(id);

        model.addAttribute("vacacion", vacacion);

        return "vacaciones/actualizarVacacion";
    }

    @GetMapping("/eliminarVacacion/{id}")
    public String eliminarVacacion(@PathVariable(value = "id") long id) {
        vacacionService.eliminarVacaciones(id);

        return "redirect:/vacaciones";
    }
}
