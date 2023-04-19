package com.cibertec.personalplanta.repository;

import com.cibertec.personalplanta.model.Vacacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacacionRepository extends JpaRepository<Vacacion,Long> {
}
