package com.codigo.cooperativaahorros.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Usuario")
@Getter
@Setter
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuCod;

    @Column(length = 50)
    private String usuIde;

    @Column(length = 50)
    private String usuUsu;

    @Column(length = 50)
    private String usuPas;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cooCod")
    private CooperativaEntity cooperativa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rolCod")
    private RolEntity rol;

    @Column(nullable = false)
    private Character usuEst;
}

