package com.nat.cadeaux.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Article {

    @Id
    private Long id;
    private String libelle;

    @Lob
    private String description;

    private int nbPoints;

    // Un article appartient à une catégorie
    @ManyToOne
    private Category categorie;
}
