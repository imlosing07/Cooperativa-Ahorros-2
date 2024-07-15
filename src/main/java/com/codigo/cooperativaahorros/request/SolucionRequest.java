package com.codigo.cooperativaahorros.request;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class SolucionRequest {
    private String solNom;
    private String solDes;
    private Date solFec;
    private Character solEst;
}
