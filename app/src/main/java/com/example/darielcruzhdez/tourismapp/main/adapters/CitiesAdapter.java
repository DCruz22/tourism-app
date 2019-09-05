package com.example.darielcruzhdez.tourismapp.main.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.darielcruzhdez.tourismapp.R;
import com.example.darielcruzhdez.tourismapp.main.models.City;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by darielcruzhdez on 10/8/16.
 */
public class CitiesAdapter extends RecyclerView.Adapter<CitiesAdapter.ViewHolder> {

    // Your custom values for the spinner (User)
    private List<City> mCities = new ArrayList<>();

    public DestinationAdapter(List<City> values){
        this.mCities = values;
    }

    @Override
    public int getItemsCount() {
        return mCities.size();
    }

    @Override
    public CitiesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View destinationView = inflater.inflate(R.layout.city_items, parent, false);

        return new ViewHolder(destinationView);
    }

    @Override
    public void onBindViewHolder(DestinationAdapter.ViewHolder viewHolder, int position){
        City city = mCities.get(position);

        TextView tv = viewHolder.cityTv;
        tv.setText(city.name);
    }
 
    public class ViewHolder extends RecyclerView.ViewHolder {
        
        public TextView cityTv;

        public ViewHolder(View itemView) {
            super(itemView);
            destinationTv = (TextView) itemView.findViewById(R.id.text_city);
        }
    }
}

}
