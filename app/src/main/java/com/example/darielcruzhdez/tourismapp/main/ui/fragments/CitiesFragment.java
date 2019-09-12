package com.example.darielcruzhdez.tourismapp.main.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.darielcruzhdez.tourismapp.R;
import com.example.darielcruzhdez.tourismapp.main.interfaces.CityInterface;
import com.example.darielcruzhdez.tourismapp.main.models.City;
import com.example.darielcruzhdez.tourismapp.main.adapters.CitiesAdapter;
import com.example.darielcruzhdez.tourismapp.main.presenters.CityPresenter;
import com.example.darielcruzhdez.tourismapp.main.ui.activities.DestinationActivity;
import com.example.darielcruzhdez.tourismapp.main.utils.CitiesRepo;

import java.util.List;

public class CitiesFragment extends Fragment implements CityInterface.View {

    private RecyclerView mCitiesRV;
    private CitiesAdapter mAdapter;
    private CityPresenter mPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new CityPresenter(this, new CitiesRepo(getContext()));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cities, container, false);
        mCitiesRV = view.findViewById(R.id.citiesRV);
        mPresenter.loadCities();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.onResume();
    }

    @Override
    public void setAdapter(List<City> cities) {
        mAdapter = new CitiesAdapter(cities, mPresenter::onItemClicked);
    }

    @Override
    public void showAdapter() {
        mCitiesRV.setAdapter(mAdapter);
        mCitiesRV.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void showDestinationActivity(City city) {
        Intent i = new Intent(getActivity(), DestinationActivity.class);
        i.putExtra("CITY", city.getId());
        startActivity(i);
    }
}