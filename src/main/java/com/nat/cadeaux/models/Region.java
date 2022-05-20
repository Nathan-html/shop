package com.nat.cadeaux.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Region {

    @Id
    private Long id;

    private String name;

    @OneToMany(mappedBy = "region")
    private List<Department> departments;
}
