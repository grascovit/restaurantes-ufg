package br.ufg.inf.restaurantesufg.models;

public class Restaurant {
    public String name;
    public String latitude;
    public String longitude;

    public Restaurant(String name, String latitude, String longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
