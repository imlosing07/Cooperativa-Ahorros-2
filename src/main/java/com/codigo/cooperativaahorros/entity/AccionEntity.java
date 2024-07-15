package com.codigo.cooperativaahorros.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Accion")
@Getter
@Setter
public class AccionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accCod;

    @ManyToOne
    @JoinColumn(name = "logAccionesCod")
    private LogAccionesEntity logAccionesCod;

    @Column(length = 200)
    private String accDes;

    @Column(nullable = false)
    private Character accEst = 'A';

    // Getters and Setters
}

