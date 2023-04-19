package com.cibertec.personalplanta.service;

import com.cibertec.personalplanta.model.Vacacion;
import com.cibertec.personalplanta.repository.VacacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VacacionServiceImpl implements VacacionService {

    @Autowired
    private VacacionRepository vacacionRepository;
    @Override
    public List<Vacacion> listaVacaciones() {
        return vacacionRepository.findAll();
    }

    @Override
    public void guardarVacaciones(Vacacion vacacion) {
        vacacionRepository.save(vacacion);
    }

    @Override
    public Vacacion obtenerVacaciones(long id) {

        Optional<Vacacion> optional = vacacionRepository.findById(id);

        Vacacion vacacion;

        if (optional.isPresent()) vacacion = optional.get();

        else throw new RuntimeException("Registro no encontrado para el id: "+ id);


        return vacacion;
    }

    @Override
    public void eliminarVacaciones(long id) {
        vacacionRepository.deleteById(id);
    }
}
