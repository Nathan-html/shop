package com.nat.cadeaux.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="users")
public class User {

    @Id
    private Long id;

    private String prenom;

    @Column(length=50)
    private String nom;

    @Column(unique = true)
    private String email;

    private int solde;

    private LocalDate dateDeNaissance;

    @ManyToOne
    private City city;

}
