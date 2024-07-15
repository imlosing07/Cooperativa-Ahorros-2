package com.codigo.cooperativaahorros.request;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class AvanceRequest {
    private String avaDes;
    private String duda;
    private Date avaFec;
    private Long ticketAyuda;
    private Character avaEst;
}
