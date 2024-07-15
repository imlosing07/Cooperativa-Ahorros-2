package com.codigo.cooperativaahorros.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class LogSesionesDTO {
    private Long logSesionCod;
    private Date dia;
    private String usuUsu;
    private String disNom;
    private Character logSesionEst;
}
