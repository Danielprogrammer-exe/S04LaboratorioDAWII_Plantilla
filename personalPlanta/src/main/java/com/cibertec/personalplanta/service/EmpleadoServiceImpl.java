package com.cibertec.personalplanta.service;

import com.cibertec.personalplanta.model.Empleado;
import com.cibertec.personalplanta.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServiceImpl  implements EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;


    @Override
    public List<Empleado> listarEmpleados() {
        return empleadoRepository.findAll() ;
    }

    @Override
    public void guardarEmpleado(Empleado empleado) {
        empleadoRepository.save(empleado);
    }

    @Override
    public Empleado obtenerEmpleadoPorId(long id) {

        Optional<Empleado> opcional = empleadoRepository.findById(id);
        Empleado empleado;
        if(opcional.isPresent()){
            empleado= opcional.get();
        }else{
            throw new RuntimeException("Empleado no encontrado para el id: "+id);
        }
        return empleado;
    }

    @Override
    public void eliminarEmpleado(long id) {
        empleadoRepository.deleteById(id);
    }

    @Override

    public List<Empleado> listarEmpleadoPorCapacitacionId(long idCapacitacion) {

        return empleadoRepository.findAllByCapacitacionesId(idCapacitacion);

    }

}
