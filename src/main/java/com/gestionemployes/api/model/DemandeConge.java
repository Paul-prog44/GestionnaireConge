package com.gestionemployes.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "demande_conges")
public class DemandeConge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employe;

    @ManyToOne
    @JoinColumn(name = "periode_id", referencedColumnName = "id")
    private Periode periode;

    @Column(name = "date_demande")
    private LocalDateTime dateDemande;

}