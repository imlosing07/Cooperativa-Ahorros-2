package com.codigo.cooperativaahorros.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Area")
@Getter
@Setter
public class AreaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long areCod;

    @Column(length = 50)
    private String areNom;

    @Column(length = 50)
    private String areDes;

    @Column(nullable = false)
    private Character areEst = 'A';

    // Getters and Setters
}

