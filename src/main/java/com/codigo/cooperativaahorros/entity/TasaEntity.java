package com.codigo.cooperativaahorros.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity
@Table(name = "Tasa")
@Getter
@Setter
public class TasaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tasCod;

    @Column(length = 50)
    private String tasIden;
    @Column(length = 150)
    private String tasDesc;
    @Column
    private Double tasTasa;
    @Column
    private Integer tasPlaDia;
    @Column
    private Date tasFecIni;
    @Column
    private Date tasFecFin;

    @Column(nullable = false)
    private Character tasEst = 'A';

    // Getters and Setters
}
