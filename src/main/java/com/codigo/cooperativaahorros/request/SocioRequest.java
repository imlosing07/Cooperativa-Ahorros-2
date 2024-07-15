package com.codigo.cooperativaahorros.request;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class SocioRequest {
    private String socIden;
    private String socApePat;
    private String socApeMat;
    private String socNom;
    private Date socioFec;
    private String socCor;
    private Long cooperativa;
    private Long direccion;
    private Long cuenta;
    private Character socEst;
}
