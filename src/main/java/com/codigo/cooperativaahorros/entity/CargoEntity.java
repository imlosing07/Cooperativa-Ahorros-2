package com.codigo.cooperativaahorros.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "Cargo")
@Getter
@Setter
public class CargoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cargoCod;

    @Column(length = 50)
    private String cargoNom;

    @Column(length = 50)
    private String cargoDes;

    @OneToMany(mappedBy = "cargo", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<FuncionesEntity> funciones;

    @OneToMany(mappedBy = "cargo", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PersonaEntity> personas;

    @Column(nullable = false)
    private Character cargoEst = 'A';
}
