package com.kovbel.agency.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Info {
    @Id
    @GeneratedValue
    private Long id;
    private String tour;
    private String country;
    private int price;

    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    private Date creationDate;


    public Info() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTour() {
        return tour;
    }

    public void setTour(String tour) {
        this.tour = tour;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Info(Long id, String tour, String country, int price) {
        this.id = id;
        this.tour = tour;
        this.country = country;
        this.price = price;
    }
}
