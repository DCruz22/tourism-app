package com.example.darielcruzhdez.tourismapp.main.ui.fragments;

import android.os.Bundle;
import android.support.v7.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CitiesFragment extends Fragment {

    private List<City> cities;
    private RecyclerView citiesRV;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cities, container, false);
        
        citiesRV = (RecyclerView) findViewById(R.id.citiesRV);

        cities = new ArrayList<>();

        CitiesAdapter adapter = new CitiesAdapter(cities);        
        citiesRV.setAdapter(adapter);
        citiesRV.setLayoutManager(new LinearLayoutManager(this));
    }

}