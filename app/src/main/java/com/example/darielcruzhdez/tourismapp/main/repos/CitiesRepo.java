package com.example.darielcruzhdez.tourismapp.main.repos;

import android.content.Context;

import com.example.darielcruzhdez.tourismapp.main.model.Destination;
import com.example.darielcruzhdez.tourismapp.main.models.City;
import com.example.darielcruzhdez.tourismapp.main.utils.Parser;

import java.util.List;

public class CitiesRepo {

    private List<City> mCities;

    public CitiesRepo(Context c){
        mCities = Parser.getCitiesFromJson(c);
    }

    public City getCity(int id){
        return mCities.get(id);
    }

    public List<City> getAllCities(){
        return mCities;
    }

    public List<Destination> getDestinations(String cityName){
        City c = this.getAllCities().stream()
                .filter(city -> cityName.equals(city.getName()))
                .findAny()
                .orElse(null);

        assert c != null;
        return c.getDestinations();
    }

}
