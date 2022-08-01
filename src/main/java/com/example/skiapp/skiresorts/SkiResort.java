package com.example.skiapp.skiresorts;

import com.example.skiapp.countries.Country;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class SkiResort {
    @Id
    private int id;
    private String name;
    private String description;
    @ManyToOne // 1 country ima više sky resort-ova
    @JoinColumn(name = "country_id")
    private Country country;


    public SkiResort() {
    }

    public SkiResort(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
