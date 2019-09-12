package com.example.darielcruzhdez.tourismapp.main.interfaces;

//https://app.pluralsight.com/guides/mvp-with-testing-part-1
//https://android.jlelse.eu/recyclerview-in-mvp-passive-views-approach-8dd74633158

import com.example.darielcruzhdez.tourismapp.main.models.City;
import java.util.List;

public interface CityInterface {
    interface View{
        void showAdapter();
        void setAdapter(List<City> cities);
        void showDestinationActivity(City city);
    }

    interface Presenter{
        void onItemClicked(City city);
        void onResume();
        void loadCities();
    }
}