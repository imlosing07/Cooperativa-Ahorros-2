package com.codigo.cooperativaahorros.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Dispositivo")
@Getter
@Setter
public class DispositivoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long disCod;

    @Column(length = 50)
    private String disNom;

    @Column(length = 40)
    private String disDirIp;

    @Column(nullable = false)
    private Character disEst = 'A';
}
