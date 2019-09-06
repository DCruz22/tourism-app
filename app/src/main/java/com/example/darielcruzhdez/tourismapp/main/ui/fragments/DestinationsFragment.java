package com.example.darielcruzhdez.tourismapp.main.ui.fragments;

import android.os.Bundle;
import android.support.v7.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DestinationsFragment extends Fragment {

    private List<Destination> mDestinations;
    private RecyclerView mDestinationsRV;
    private DestinationAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDestinations = new ArrayList<>();
        mAdapter = new DestinationAdapter(cities);        
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cities, container, false);
        
        mDestinationsRV = (RecyclerView) findViewById(R.id.destinationsRV);

        mDestinations = new ArrayList<>();

        mDestinationsRV.setAdapter(mAdapter);
        mDestinationsRV.setLayoutManager(new LinearLayoutManager(this));
    }

 }