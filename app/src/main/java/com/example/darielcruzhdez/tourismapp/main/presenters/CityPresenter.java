package com.example.darielcruzhdez.tourismapp.main.presenters;

import com.example.darielcruzhdez.tourismapp.main.interfaces.CityInterface;
import com.example.darielcruzhdez.tourismapp.main.models.City;
import com.example.darielcruzhdez.tourismapp.main.repos.CitiesRepo;

public class CityPresenter implements CityInterface.Presenter {

    private CityInterface.View mView;
    private CitiesRepo mRepo;

    public CityPresenter(CityInterface.View view, CitiesRepo repo){
        mView = view;
        mRepo = repo;
    }

    @Override
    public void onItemClicked(City city) {
        mView.showDestinationActivity(city);
    }

    @Override
    public void onResume() {
        mView.showAdapter();
    }

    @Override
    public void loadCities() {
        mView.setAdapter(mRepo.getAllCities());
    }
}
