package com.example.darielcruzhdez.tourismapp.main.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.darielcruzhdez.tourismapp.R;
import com.example.darielcruzhdez.tourismapp.main.adapters.DestinationAdapter;
import com.example.darielcruzhdez.tourismapp.main.model.Destination;

import java.util.ArrayList;
import java.util.List;

public class DestinationsFragment extends Fragment {

    private List<Destination> mDestinations;
    private RecyclerView mDestinationsRV;
    private DestinationAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDestinations = new ArrayList<>();
        mAdapter = new DestinationAdapter(mDestinations);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_destinations, container, false);
        mDestinationsRV = view.findViewById(R.id.destinationsRV);

        mDestinations = new ArrayList<>();

        mDestinationsRV.setAdapter(mAdapter);
        mDestinationsRV.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }

 }