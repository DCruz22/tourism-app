package com.example.darielcruzhdez.tourismapp.main.model;

import io.realm.RealmObject;

/**
 * Created by darielcruzhdez on 10/3/16.
 */
public class Destination extends RealmObject {

    private int id;
    private String name;
    private String cityName;

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

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String name) {
        this.cityName = name;
    }

}
