package com.codigo.cooperativaahorros.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Producto")
@Getter
@Setter
public class ProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long proCod;

    @Column(length = 50)
    private String proIden;

    @Column(length = 200)
    private String proDes;

    @ManyToOne
    @JoinColumn(name = "tasCod")
    private TasaEntity tasa;

    @ManyToOne
    @JoinColumn(name = "monCod")
    private MonedaEntity moneda;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "socCod")
    private SocioEntity socio;

    @Column(nullable = false)
    private Character proEst = 'A';
    // Getters and Setters
}
