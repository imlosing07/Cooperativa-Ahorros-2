package com.codigo.cooperativaahorros.request;

import lombok.Getter;
import lombok.Setter;

import java.sql.Time;

@Getter
@Setter
public class LogAccionesRequest {
    private Time horaFin;
    private Long logSesionesCod;
    private Character logAccionEst;
}
