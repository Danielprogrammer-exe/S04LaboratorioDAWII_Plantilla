package com.cibertec.personalplanta.service;

import com.cibertec.personalplanta.model.Vacacion;

import java.util.List;

public interface VacacionService {

    List<Vacacion> listaVacaciones();

    void guardarVacaciones(Vacacion vacacion);

    Vacacion obtenerVacaciones(long id);

    void eliminarVacaciones(long id);

}
