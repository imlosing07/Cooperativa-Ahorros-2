package com.codigo.cooperativaahorros.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PersonaDTO {
    private Integer perCod;
    private String perIden;
    private String perApePat;
    private String perApeMat;
    private String perNom;
    private Date perFecNac;
    private String perCor;
    private String perFot;
    private String cooNom;
    private String cargoNom;
    private Character perEst;
}
