package com.cibertec.personalplanta.controller;


import com.cibertec.personalplanta.model.Capacitacion;
import com.cibertec.personalplanta.model.Empleado;
import com.cibertec.personalplanta.service.CapacitacionService;
import com.cibertec.personalplanta.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
public class CapacitacionController {

    @Autowired
    private CapacitacionService capacitacionService;

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping("/capacitaciones")
    public String verPaginaInicioCapacitacion(Model model){
        model.addAttribute("listaCapacitaciones", capacitacionService.listarCapacitaciones());
        return "capacitaciones/capacitaciones";
    }

    @GetMapping("/nuevaCapacitacion")
    public String nuevaCapacitacion(Model model ) {
        Capacitacion capacitacion = new Capacitacion();
        model.addAttribute("capacitacion", capacitacion);
        return "capacitaciones/nuevaCapacitacion";   //Página html
    }

    @PostMapping("/guardarCapacitacion")
    public String guardarCapacitacion(@ModelAttribute("capacitacion") Capacitacion capacitacion){
        capacitacionService.guardarCapacitacion(capacitacion);
        return "redirect:/capacitaciones";
    }

    @GetMapping("/actualizarCapacitacion/{id}")
    public String actualizarCapacitacion(@PathVariable(value="id") long id , Model model){
        Capacitacion capacitacion = capacitacionService.obtenerCapacitacionPorId(id);
        model.addAttribute("capacitacion", capacitacion);
        return "capacitaciones/actualizarCapacitacion"; //Página html
    }

    @GetMapping("/eliminarCapacitacion/{id}")
    public String eliminarCapacitacion(@PathVariable(value="id") long id){
        capacitacionService.eliminarCapacitacion(id);
        return "redirect:/capacitaciones";
    }



    @GetMapping("/inicioBusqueda")
    public String verPaginaInicioBusqueda(Model model){
        return "capacitaciones/buscarCapacitacion";
    }

    @GetMapping("/busquedaCapacitacion")
    public String busquedaCapacitacion(Model model, @RequestParam("fechaIniIni")@DateTimeFormat(pattern = "yyyy-MM-dd")Date fechaIniIni,
                                                    @RequestParam("fechaIniFin")@DateTimeFormat(pattern = "yyyy-MM-dd")Date fechaIniFin){
        List<Capacitacion> lista = capacitacionService.listarCapacitacionPorFechaInicio(fechaIniIni,fechaIniFin);
        model.addAttribute("listaCapacitaciones", lista);
        System.out.println("lista ---> " + lista.size());
        return "capacitaciones/buscarCapacitacion";

    }

    @GetMapping("/capacitacionDetalle/{id}")
    public String capacitacionDetalle (@PathVariable(value="id") long id, Model model){

        List<Empleado> listaEmpleadoCapacitacion =empleadoService.listarEmpleadoPorCapacitacionId(id);
        Capacitacion capacitacion = capacitacionService.obtenerCapacitacionPorId(id);

        model.addAttribute("listaEmpleadoCapacitacion", listaEmpleadoCapacitacion);
        model.addAttribute("capacitacion",capacitacion);
        return "capacitaciones/capacitacionDetalle";
    }

}
