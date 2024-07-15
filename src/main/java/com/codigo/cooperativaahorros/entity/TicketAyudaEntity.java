package com.codigo.cooperativaahorros.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "TicketAyuda")
@Getter
@Setter
public class TicketAyudaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketCod;

    @Column(length = 200)
    private String descripcion;

    @Column
    private Date fechaCreacion;

    @ManyToOne
    @JoinColumn(name = "usuCod")
    private UsuarioEntity usuario;

    @Column(length = 50)
    private String tipSer;

    @ManyToOne
    @JoinColumn(name = "areCod")
    private AreaEntity areCod;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "ticketAyuda_solucion",
            joinColumns = @JoinColumn(name = "fk_ticket", nullable = false),
            inverseJoinColumns = @JoinColumn(name="fk_solucion", nullable = false)
    )
    private List<SolucionEntity> soluciones;

    @Column
    private String estCod;
    // Getters and Setters
}
