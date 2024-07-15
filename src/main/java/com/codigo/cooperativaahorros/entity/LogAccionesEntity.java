package com.codigo.cooperativaahorros.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Table(name = "LogAcciones")
@Getter
@Setter
public class LogAccionesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long logAccionesCod;

    @Column
    private Time horaInicio;

    @Column
    private Time horaFin;

    @ManyToOne
    @JoinColumn(name = "logSesionesCod")
    private LogSesionesEntity logSesionesCod;

    @Column(nullable = false)
    private Character logSesionesEst = 'A';

    // Getters and Setters
}
