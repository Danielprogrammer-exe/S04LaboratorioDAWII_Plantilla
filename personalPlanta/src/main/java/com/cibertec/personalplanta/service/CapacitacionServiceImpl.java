package com.cibertec.personalplanta.service;

import com.cibertec.personalplanta.model.Capacitacion;
import com.cibertec.personalplanta.repository.CapacitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CapacitacionServiceImpl implements CapacitacionService {

    @Autowired
    private CapacitacionRepository capacitacionRepository;

    @Override
    public List<Capacitacion> listarCapacitaciones() {
        return capacitacionRepository.findAll();
    }

    @Override
    public void guardarCapacitacion(Capacitacion capacitacion) {
        capacitacionRepository.save(capacitacion);
    }

    @Override
    public Capacitacion obtenerCapacitacionPorId(long id) {
        Optional<Capacitacion> opcional = capacitacionRepository.findById(id);
        Capacitacion capacitacion;
        if(opcional.isPresent()){
            capacitacion= opcional.get();
        }else{
            throw new RuntimeException("Capacitación no encontrado para el id: "+id);
        }
        return capacitacion;
    }

    @Override
    public void eliminarCapacitacion(long id) {
        capacitacionRepository.deleteById(id);
    }

    @Override
    public List<Capacitacion> listarCapacitacionPorFechaInicio(Date fechaIniIni, Date fechaIniFin) {
        return capacitacionRepository.findCapacitacionPorFechaInicio(fechaIniIni, fechaIniFin);
    }
}
