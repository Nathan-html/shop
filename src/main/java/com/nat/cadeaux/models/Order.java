package com.nat.cadeaux.models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="orders")
public class Order {

    @Id
    private Long id;

    private LocalDateTime dateHeureEnvoi;

    @ManyToOne
    private User utilisateur;

    @ManyToMany()
    private List<Article> articles;

}
