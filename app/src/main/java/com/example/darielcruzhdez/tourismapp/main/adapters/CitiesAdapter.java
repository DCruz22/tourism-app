package com.example.darielcruzhdez.tourismapp.main.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.darielcruzhdez.tourismapp.R;
import com.example.darielcruzhdez.tourismapp.main.models.City;

import java.util.List;

/**
 * Created by darielcruzhdez on 10/8/16.
 */
public class CitiesAdapter extends RecyclerView.Adapter<CitiesAdapter.ViewHolder> {

    public interface Listener {
        void onItemClicked(City item);
    }

    private List<City> mCities;
    private Listener mListener;

    public CitiesAdapter(List<City> values, Listener listener){
        this.mCities = values;
        this.mListener = listener;
    }

    @Override
    public int getItemCount() {
        return mCities.size();
    }

    @Override
    public CitiesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View destinationView = inflater.inflate(R.layout.cities_items, parent, false);

        return new ViewHolder(destinationView);
    }

    @Override
    public void onBindViewHolder(CitiesAdapter.ViewHolder viewHolder, int position){
        final City city = mCities.get(position);

        TextView tv = viewHolder.cityTv;
        tv.setText(city.getName());
        viewHolder.cityTv.setOnClickListener(v -> mListener.onItemClicked(city));
    }
 
    public class ViewHolder extends RecyclerView.ViewHolder {
        
        public TextView cityTv;

        public ViewHolder(View itemView) {
            super(itemView);
            cityTv = itemView.findViewById(R.id.text_city);
        }
    }
}


