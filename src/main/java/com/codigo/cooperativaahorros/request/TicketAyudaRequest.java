package com.codigo.cooperativaahorros.request;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
public class TicketAyudaRequest {
    private String descripcion;
    private Date fechaCreacion;
    private String tipSer;
    private Long usuario;
    private Long areCod;
    private List<Long> soluciones;
    private String estCod;
}
