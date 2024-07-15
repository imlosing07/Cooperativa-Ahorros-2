package com.codigo.cooperativaahorros.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class AvanceDTO {
    Integer avaCod;
    String avaDes;
    String duda;
    Date avaFec;
    Integer ticketAyudaCod;
    Character avaEst;
}
