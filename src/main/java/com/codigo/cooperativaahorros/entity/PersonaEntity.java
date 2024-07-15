package com.codigo.cooperativaahorros.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity
@Table(name = "Persona")
@Getter
@Setter
public class PersonaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long perCod;

    @Column(length = 50)
    private String perIden;

    @Column(length = 50)
    private String perApePat;

    @Column(length = 50)
    private String perApeMat;

    @Column(length = 100)
    private String perNom;

    @Column
    private Date perFecNac;

    @Column(length = 100)
    private String perCor;

    @Column(length = 200)
    private String perFot;

    @ManyToOne
    @JoinColumn(name = "cooCod")
    private CooperativaEntity cooperativa;

    @ManyToOne
    @JoinColumn(name = "cargoCod")
    private CargoEntity cargo;

    @Column(nullable = false)
    private Character perEst = 'A';
}
