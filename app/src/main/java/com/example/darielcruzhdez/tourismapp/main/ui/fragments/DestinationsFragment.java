package com.example.darielcruzhdez.tourismapp.main.ui.fragments;

import android.os.Bundle;
import android.support.v7.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DestinationsFragment extends Fragment {

    private List<Destination> mDestinations;
    private RecyclerView destinationsRV;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cities, container, false);
        
        destinationsRV = (RecyclerView) findViewById(R.id.destinationsRV);

        mDestinations = new ArrayList<>();

        DestinationAdapter adapter = new DestinationAdapter(cities);        
        destinationsRV.setAdapter(adapter);
        destinationsRV.setLayoutManager(new LinearLayoutManager(this));
    }

 }