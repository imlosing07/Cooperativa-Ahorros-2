package com.codigo.cooperativaahorros.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "LogSesiones")
@Getter
@Setter
public class LogSesionesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long logSesionesCod;

    @Column
    private Date Dia;

    @ManyToOne
    @JoinColumn(name = "usuCod")
    private UsuarioEntity usuario;

    @ManyToOne
    @JoinColumn(name = "disCod")
    private DispositivoEntity dispositivo;

    @Column(nullable = false)
    private Character logSesionesEst = 'A';

    // Getters and Setters
}
