package com.codigo.cooperativaahorros.request;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class PersonaRequest {

    private String perIden;
    private String perApePat;
    private String perApeMat;
    private String perNom;
    private Date perFecNac;
    private String perCor;
    private String perFot;
    private Long cooperativa;
    private Long cargo;
    private Character perEst;
}
