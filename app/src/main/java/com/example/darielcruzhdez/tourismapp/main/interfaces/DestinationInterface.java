package com.example.darielcruzhdez.tourismapp.main.interfaces;


import com.example.darielcruzhdez.tourismapp.main.model.Destination;

import java.util.List;

public interface DestinationInterface {
    interface View{
        void setAdapter(List<Destination> items);
        void updateAdapter(List<Destination> items);
        void showAdapter();
        void openLocation(Destination destination);
        void showMessage(String message);
    }

    interface Presenter{
        void onItemClicked(Destination destination);
        void onBookmarkImgClicked(Destination destination);
        void loadBookmarkedDestinations();
        void loadDestinations();
        void setCityName(String cityName);
        void onResume();
        void onDestroy();
    }
}