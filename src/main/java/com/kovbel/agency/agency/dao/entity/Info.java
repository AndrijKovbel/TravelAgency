package com.kovbel.agency.agency.dao.entity;

public class Info {
    private int id;
    private String tour;
    private String country;
    private int price;

    public Info() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Info(int id, String tour, String country, int price) {
        this.id = id;
        this.tour = tour;
        this.country = country;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Info{" +
                "id=" + id +
                ", tour='" + tour + '\'' +
                ", country='" + country + '\'' +
                ", price=" + price +
                '}';
    }
}
