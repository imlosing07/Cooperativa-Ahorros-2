package com.codigo.cooperativaahorros.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;


@Getter
@Setter
public class SocioDTO {
    private Integer socCod;
    private String socIden;
    private String socApePat;
    private String socApeMat;
    private String socNom;
    private Date socioFec;
    private String socCor;
    private String Cooperativa;
    private String Cuenta;
    private String Direccion;
    private Character socEst;
}
