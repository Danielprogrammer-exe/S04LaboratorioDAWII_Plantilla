package com.cibertec.personalplanta.repository;


import com.cibertec.personalplanta.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado,Long> {

    @Query(value=" SELECT * FROM tb_empleado e inner join tb_emp_capa ec on e.id_empleado= ec.id_empleado WHERE  ec.id_capacitacion=:idCapacitacion " , nativeQuery = true )

    public List<Empleado> findAllByCapacitacionesId(@Param("idCapacitacion") long idCapacitacion);
}
