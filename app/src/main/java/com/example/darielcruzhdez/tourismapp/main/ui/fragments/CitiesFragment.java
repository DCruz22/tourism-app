package com.example.darielcruzhdez.tourismapp.main.ui.fragments;

import android.os.Bundle;
import android.support.v7.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CitiesFragment extends Fragment {

    private List<City> mCities;
    private RecyclerView mCitiesRV;
    private CitiesAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCities = new ArrayList<>();
        mAdapter = new CitiesAdapter(mCities);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cities, container, false);
        
        mCitiesRV = (RecyclerView) findViewById(R.id.citiesRV);

        mCitiesRV.setAdapter(mAdapter);
        mCitiesRV.setLayoutManager(new LinearLayoutManager(this));
    }

}