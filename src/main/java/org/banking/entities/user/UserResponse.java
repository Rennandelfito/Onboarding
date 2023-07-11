package org.banking.entities.user;

import java.time.LocalDate;

public class UserResponse {

    private Long id;
    private String name;
    private String document;
    private LocalDate dateBirth;
    private String country;
    private String state;
    private String city;
    private String neighborhood;
    private String street;
    private Integer numberhouse;

    public UserResponse(Long id, String name, String document, LocalDate dateBirth, String country, String state, String city, String neighborhood, String street, Integer numberhouse) {
        this.id = id;
        this.name = name;
        this.document = document;
        this.dateBirth = dateBirth;
        this.country = country;
        this.state = state;
        this.city = city;
        this.neighborhood = neighborhood;
        this.street = street;
        this.numberhouse = numberhouse;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumberhouse() {
        return numberhouse;
    }

    public void setNumberhouse(Integer numberhouse) {
        this.numberhouse = numberhouse;
    }
}
