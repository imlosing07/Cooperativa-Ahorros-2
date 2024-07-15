package com.codigo.cooperativaahorros.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.sql.Date;

@Entity
@Table(name = "Avance")
@Getter
@Setter
public class AvanceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long avaCod;

    @Column(length = 200)
    private String avaDes;

    @Column(length = 200)
    private String duda;

    private Date avaFec;

    @ManyToOne
    @JoinColumn(name = "ticketAyuda")
    private TicketAyudaEntity ticketAyuda;

    @Column(nullable = false)
    private Character avaEst = 'A';
    // Getters and Setters
}
