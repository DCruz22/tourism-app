package com.example.darielcruzhdez.tourismapp.main.ui.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.darielcruzhdez.tourismapp.R;
import com.example.darielcruzhdez.tourismapp.main.adapters.DestinationAdapter;
import com.example.darielcruzhdez.tourismapp.main.interfaces.DestinationInterface;
import com.example.darielcruzhdez.tourismapp.main.model.Destination;
import com.example.darielcruzhdez.tourismapp.main.presenters.DestinationPresenter;
import com.example.darielcruzhdez.tourismapp.main.repos.CitiesRepo;
import com.example.darielcruzhdez.tourismapp.main.repos.DestinationsRepo;

import java.util.List;

public class DestinationsFragment extends Fragment implements DestinationInterface.View {

    private RecyclerView mDestinationsRV;
    private DestinationAdapter mAdapter;
    private DestinationPresenter mPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new DestinationPresenter(this, new CitiesRepo(getActivity()), new DestinationsRepo());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_destinations, container, false);
        mDestinationsRV = view.findViewById(R.id.destinationsRV);

        Bundle b = getArguments();
        if(b != null){
            mPresenter.setCityName(b.getString("CITY_NAME"));
            mPresenter.loadDestinations();
        }else{
            mPresenter.loadBookmarkedDestinations();
        }

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }

    @Override
    public void setAdapter(List<Destination> items) {
        mAdapter = new DestinationAdapter(items, mPresenter::onItemClicked, mPresenter::onBookmarkImgClicked);
    }

    @Override
    public void updateAdapter(List<Destination> items) {
        mAdapter.setList(items);
    }

    @Override
    public void showAdapter() {
        mDestinationsRV.setAdapter(mAdapter);
        mDestinationsRV.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void openLocation(Destination destination) {
        Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + destination.getCityName() + ", " + destination.getName());
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }
}