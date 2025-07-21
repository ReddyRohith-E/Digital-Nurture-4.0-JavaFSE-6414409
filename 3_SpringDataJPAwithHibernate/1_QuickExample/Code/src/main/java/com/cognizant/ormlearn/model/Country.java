package com.cognizant.ormlearn.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Country Entity class representing the country table
 */
@Entity
@Table(name = "country")
public class Country {

    @Id
    @Column(name = "co_code")
    @NotBlank(message = "Country code cannot be blank")
    @Size(min = 2, max = 3, message = "Country code must be 2-3 characters")
    private String code;

    @Column(name = "co_name")
    @NotBlank(message = "Country name cannot be blank")
    @Size(max = 100, message = "Country name cannot exceed 100 characters")
    private String name;

    // Default constructor
    public Country() {
    }

    // Parameterized constructor
    public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }

    // Getters and Setters
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Country{code='%s', name='%s'}", code, name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Country country = (Country) obj;
        return code != null ? code.equals(country.code) : country.code == null;
    }

    @Override
    public int hashCode() {
        return code != null ? code.hashCode() : 0;
    }
}
