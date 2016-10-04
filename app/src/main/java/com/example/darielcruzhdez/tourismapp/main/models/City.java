package com.example.darielcruzhdez.tourismapp.main.models;

import java.util.List;

/**
 * Created by darielcruzhdez on 10/3/16.
 */
public class City {

    private int id;
    private String name;
    private List<String> destinations;

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

    public List<String> getDestinations() {
        return destinations;
    }

    public void setDestinations(List<String> destinations) {
        this.destinations = destinations;
    }

}