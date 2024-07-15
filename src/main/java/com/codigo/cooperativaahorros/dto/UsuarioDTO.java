package com.codigo.cooperativaahorros.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {
    private Integer usuCod;
    private String usuIde;
    private String usuUsu;
    private String usuPas;
    private String Cooperativa;
    private String Rol;
    private Character usuEst;
}
