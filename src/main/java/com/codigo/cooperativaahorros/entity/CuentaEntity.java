package com.codigo.cooperativaahorros.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Cuenta")
@Getter
@Setter
public class CuentaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cueCod;

    @Column(nullable = false)
    private String cueNum;

    @Column(nullable = false)
    private Character cueEst = 'A';
}

