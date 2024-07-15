package com.codigo.cooperativaahorros.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioRequest {
    private String usuIde;
    private String usuUsu;
    private String usuPas;
    private Long cooperativa;
    private Long rol;
    private Character usuEst;
}
