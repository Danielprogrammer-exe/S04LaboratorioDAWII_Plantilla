package com.cibertec.personalplanta.repository;

import com.cibertec.personalplanta.model.Capacitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CapacitacionRepository extends JpaRepository<Capacitacion,Long> {
    @Query(value = "SELECT * FROM bd_semana05.tb_capacitacion c WHERE c.fecha_inicio between :fechaIniIni and :fechaIniFin", nativeQuery = true)
    public List<Capacitacion> findCapacitacionPorFechaInicio(@Param("fechaIniIni")Date fechaIniIni, @Param("fechaIniFin")Date fechaIniFin);

}
