package com.codigo.cooperativaahorros.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Rol")
@Getter
@Setter
public class RolEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rolCod;

    @Column(length = 50)
    private String rolRol;

    @Column(length = 20)
    private String rolNom;

    @OneToMany(mappedBy = "rol", fetch = FetchType.LAZY)
    private Set<UsuarioEntity> usuarios = new HashSet<>();

    @Column(nullable = false)
    private Character rolEst = 'A';
}
