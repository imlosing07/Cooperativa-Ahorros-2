package com.codigo.cooperativaahorros.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Manual")
@Getter
@Setter
public class ManualEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long manCod;

    @Column(length = 50)
    private String manNom;

    @Column(length = 200)
    private String manDes;

    @OneToMany(mappedBy = "manual", fetch = FetchType.LAZY)
    private Set<FuncionesEntity> funciones = new HashSet<>();

    @Column(nullable = false)
    private Character manEst = 'A';

    // Getters and Setters
}
