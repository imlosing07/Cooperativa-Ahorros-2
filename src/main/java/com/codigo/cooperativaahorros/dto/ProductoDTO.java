package com.codigo.cooperativaahorros.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoDTO {
    private Integer proCod;
    private String proIden;
    private String proDes;
    private Double tasTasa;
    private String monNom;
    private String socNom;
    private Character proEst;
}
