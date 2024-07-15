package com.codigo.cooperativaahorros.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Moneda")
@Getter
@Setter
public class MonedaEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long monCod;

    @Column(length = 50)
    private String monNom;

    @Column(nullable = false)
    private Character monEst = 'A';

    // Getters and Setters
}
