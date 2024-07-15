package com.codigo.cooperativaahorros.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoRequest {
    private String proIden;
    private String proDes;
    private Long tasa;
    private Long moneda;
    private Long socio;
    private Character proEst;
}
