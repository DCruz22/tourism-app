package com.example.darielcruzhdez.tourismapp.main.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.darielcruzhdez.tourismapp.R;
import com.example.darielcruzhdez.tourismapp.main.models.City;
import com.example.darielcruzhdez.tourismapp.main.adapters.CitiesAdapter;

import java.util.ArrayList;
import java.util.List;

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
        mCitiesRV = container.findViewById(R.id.citiesRV);

        mCitiesRV.setAdapter(mAdapter);
        mCitiesRV.setLayoutManager(new LinearLayoutManager(getActivity()));

        return inflater.inflate(R.layout.fragment_cities, container, false);
    }

}