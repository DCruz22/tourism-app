package com.example.darielcruzhdez.tourismapp.main.utils;

import android.content.Context;

import com.example.darielcruzhdez.tourismapp.main.models.City;
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

}
