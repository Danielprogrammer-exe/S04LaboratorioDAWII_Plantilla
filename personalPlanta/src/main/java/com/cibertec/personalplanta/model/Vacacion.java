package com.cibertec.personalplanta.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_vacacion")
@Getter
@Setter
public class Vacacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vacacion")
    private long id;

    @Column(name = "fecha_inicio")
    @Temporal(value = TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaInicio;

    @Column(name = "fecha_fin")
    @Temporal(value = TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaFin;

    @Column(name = "estado")
    private int estado;

    //método para asignar nombre a los estados
    public String NombreEstado() {
        String nombreEstado = null;
        switch (estado) {
            case 0: nombreEstado = "Programado";break;
            case 1: nombreEstado = "Tomado";break;
            default: nombreEstado = "Cancelado";
        }
        return nombreEstado;
    }
}
