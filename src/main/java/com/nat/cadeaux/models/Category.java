package com.nat.cadeaux.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import java.util.List;

@Entity
public class Category {

    @Id
    private Long id;
    private String nom;

    private String couleur;

    @Transient
    private String attributQuiNeSeraPasEnBase;

    @OneToMany(mappedBy="categorie")
    private List<Article> articles;

}
