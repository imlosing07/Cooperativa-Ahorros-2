package com.codigo.cooperativaahorros.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Socio")
@Getter
@Setter
public class SocioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long socCod;

    @Column(length = 50, nullable = false)
    private String socIden;

    @Column(length = 50, nullable = false)
    private String socNom;

    @Column(length = 50, nullable = false)
    private String socApePat;

    @Column(length = 50, nullable = false)
    private String socApeMat;

    @Column
    private Date socioFec;

    @Column(length = 50, nullable = false)
    private String socCor;

    @OneToMany(mappedBy = "socio", fetch = FetchType.LAZY)
    private Set<ProductoEntity> productos = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "cueCod", nullable = false)
    private CuentaEntity cuenta;

    @ManyToOne
    @JoinColumn(name = "cooCod", nullable = false)
    private CooperativaEntity cooperativa;

    @ManyToOne
    @JoinColumn(name = "dirCod", nullable = false)
    private DireccionEntity direccion;

    @Column(nullable = false)
    private Character socEst = 'A';
}
