package com.cibertec.personalplanta.service;

import com.cibertec.personalplanta.model.Capacitacion;

import java.util.Date;
import java.util.List;

public interface CapacitacionService {

    List <Capacitacion> listarCapacitaciones();
    void guardarCapacitacion(Capacitacion capacitacion);
    Capacitacion obtenerCapacitacionPorId(long id);
    void eliminarCapacitacion(long id);

    List<Capacitacion> listarCapacitacionPorFechaInicio(Date fechaIniIni, Date fechaIniFin);
}
