package com.codigo.cooperativaahorros.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Cooperativa")
@Getter
@Setter
public class CooperativaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cooCod;
    @Column(length = 50)
    private String cooIden;
    @Column(length = 100)
    private String cooNom;
    @Column(length = 50)
    private String cooSig;
    @Column(length = 200)
    private String cooDir;
    @Column(length = 20)
    private String cooTel;
    @Column(length = 100)
    private String cooCor;
    @Column(length = 200)
    private String cooSlo;
    @Column(length = 200)
    private String cooLog;

    @OneToMany(mappedBy = "cooperativa", fetch = FetchType.LAZY)
    private Set<UsuarioEntity> usuarios = new HashSet<>();

    @OneToMany(mappedBy = "cooperativa", fetch = FetchType.LAZY)
    private Set<SocioEntity> socios = new HashSet<>();

    @Column
    private Character cooEst = 'A';

    // Getters and Setters
}
