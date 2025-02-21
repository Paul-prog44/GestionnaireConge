package com.gestionemployes.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "periodes")
public class Periode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="date_debut")
    private String dateDebut;

    @Column(name="nb_jours")
    private int nbJour;
}
