package com.codigo.cooperativaahorros.request;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class LogSesionesRequest {
    private Date dia;
    private Long usuario;
    private Long dispositivo;
    private Character logSesionesEst;
}
