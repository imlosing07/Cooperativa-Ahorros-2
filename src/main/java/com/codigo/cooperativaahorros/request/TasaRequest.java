package com.codigo.cooperativaahorros.request;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class TasaRequest {
    private String tasIden;
    private String tasDesc;
    private Double tasTasa;
    private Date tasFecIni;
    private Date tasFecFin;
    private Character tasEst;
}
