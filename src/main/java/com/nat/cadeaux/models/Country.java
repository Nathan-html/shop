package com.nat.cadeaux.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Country {

    @Id
    private String ISO3166;

    private String name;

}
