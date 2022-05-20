package com.nat.cadeaux.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Department {

    @Id
    private Long id;

    private String name;

    private Integer number;

    @OneToMany(mappedBy="department")
    private List<City> cities;

    @ManyToOne
    private Region region;
}
