package com.nat.cadeaux.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class City {

    @Id
    private Long id;

    private String name;

    @OneToMany(mappedBy="city")
    private List<User> users;

    @ManyToOne
    private Department department;
}
