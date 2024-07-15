package com.codigo.cooperativaahorros.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "Funciones")
@Getter
@Setter
public class FuncionesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long funCod;

    @Column(length = 50)
    private String funDes;

    @Column(length = 20)
    private String funReq;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cargoCod")
    private CargoEntity cargo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manCod")
    private ManualEntity manual;

    @Column(nullable = false)
    private Character funEst = 'A';
}

