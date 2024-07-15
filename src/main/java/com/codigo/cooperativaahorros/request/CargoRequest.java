package com.codigo.cooperativaahorros.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CargoRequest {
    private String carNom;
    private String cargoDes;
    private Character carEst = 'A';
}
