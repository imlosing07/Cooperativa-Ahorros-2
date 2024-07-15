package com.codigo.cooperativaahorros.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity
@Table(name = "Solucion")
@Getter
@Setter
public class SolucionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long solCod;

    @Column(length = 20)
    private String solNom;

    @Column(length = 200)
    private String solDes;

    private Date solFec;

    @Column(nullable = false)
    private Character solEst = 'A';

    // Getters and Setters
}
