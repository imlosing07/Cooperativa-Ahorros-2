package com.codigo.cooperativaahorros.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CargoDTO {
    private Long cargoCod;
    private String cargoNom;
    private String cargoDes;
    private String funciones;
    private String personas;
    private Character cargoEst;
}
