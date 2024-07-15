package com.codigo.cooperativaahorros.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class TicketAyudaDTO {
    private Integer ticketCod;
    private String descripcion;
    private Date fechaCreacion;
    private String usuUsu;
    private String tipSer;
    private String areNom;
    private String soluciones;
    private String estCod;

}
