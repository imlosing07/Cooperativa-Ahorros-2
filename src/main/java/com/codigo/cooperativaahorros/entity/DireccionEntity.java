package com.codigo.cooperativaahorros.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Direccion")
@Getter
@Setter
public class DireccionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dirCod;

    @Column(length = 50, nullable = false)
    private String dirDep;

    @Column(length = 50, nullable = false)
    private String dirPro;

    @Column(length = 50, nullable = false)
    private String dirDis;

    @Column(nullable = false)
    private Character dirEst = 'A';
}

