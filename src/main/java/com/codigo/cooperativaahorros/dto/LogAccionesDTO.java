package com.codigo.cooperativaahorros.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.sql.Timestamp;

@Getter
@Setter
public class LogAccionesDTO {
    private Integer logAccionesCod;
    private Time horaInicio;
    private Time horaFin;
    private Integer logSesionCod;
    private Character logAccionEst;
}
