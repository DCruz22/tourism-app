package com.example.darielcruzhdez.tourismapp.main.models;

import com.example.darielcruzhdez.tourismapp.main.model.Destination;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by darielcruzhdez on 10/3/16.
 */
public class City {

    private int id;
    private String name;
    private List<Destination> destinations = new ArrayList<>();

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

    public List<Destination> getDestinations() {
        return destinations;
    }

    public void setDestinations(List<Destination> destinations) {
        this.destinations = destinations;
    }

}
