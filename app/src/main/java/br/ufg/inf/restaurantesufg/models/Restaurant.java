package br.ufg.inf.restaurantesufg.models;

public class Restaurant {
    public String name;
    public String latitude;
    public String longitude;
    public String image;
    public String rating;

    public Restaurant(String name, String latitude, String longitude, String image,
                      String rating) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.image = image;
        this.rating = rating;
    }
}
