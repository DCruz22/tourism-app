package com.example.darielcruzhdez.tourismapp.main.presenters;

import com.example.darielcruzhdez.tourismapp.main.interfaces.DestinationInterface;
import com.example.darielcruzhdez.tourismapp.main.model.Destination;
import com.example.darielcruzhdez.tourismapp.main.repos.CitiesRepo;
import com.example.darielcruzhdez.tourismapp.main.repos.DestinationsRepo;

public class DestinationPresenter implements DestinationInterface.Presenter {

    private DestinationInterface.View mView;
    private CitiesRepo mCitiesRepo;
    private DestinationsRepo mDestinationsRepo;
    private String cityName;

    public DestinationPresenter(DestinationInterface.View view, CitiesRepo citiesRepo, DestinationsRepo destinationsRepo){
        this.mView = view;
        this.mCitiesRepo = citiesRepo;
        this.mDestinationsRepo = destinationsRepo;
    }

    @Override
    public void onItemClicked(Destination destination) {
        if(cityName != null)
            destination.setCityName(cityName);

        mView.openLocation(destination);
    }

    @Override
    public void onBookmarkImgClicked(Destination destination) {
        boolean isFavTab = true;

        if(cityName != null) {
            destination.setCityName(cityName);
            isFavTab = false;
        }

        int result =   mDestinationsRepo.bookmarkDestination(destination);

        String msg = result == 0 ? "Added to Bookmarks" : "Removed from Bookmarks";

        mView.showMessage(msg);

        if(isFavTab)
            mView.updateAdapter(mDestinationsRepo.findAll());
    }

    @Override
    public void loadBookmarkedDestinations() {
        mView.setAdapter(mDestinationsRepo.findAll());
    }

    @Override
    public void loadDestinations() {
        mView.setAdapter(mCitiesRepo.getDestinations(this.cityName));
    }

    @Override
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public void onResume() {
        mView.showAdapter();
    }

    @Override
    public void onDestroy() {
        mDestinationsRepo.close();
    }
}
