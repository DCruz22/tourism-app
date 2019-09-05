package com.example.darielcruzhdez.tourismapp.main.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.darielcruzhdez.tourismapp.R;
import com.example.darielcruzhdez.tourismapp.main.models.Destination;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by darielcruzhdez on 10/8/16.
 */
public class DestinationAdapter extends RecyclerView.Adapter<DestinationAdapter.ViewHolder> {

    // Your custom values for the spinner (User)
    private List<Destination> mDestinations = new ArrayList<>();

    public DestinationAdapter(List<City> values){
        this.mDestinations = values;
    }

    @Override
    public int getItemsCount() {
        return mDestinations.size();
    }

    @Override
    public DestinationAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View destinationView = inflater.inflate(R.layout.destination_items, parent, false);

        return new ViewHolder(destinationView);
    }

    @Override
    public void onBindViewHolder(DestinationAdapter.ViewHolder viewHolder, int position){
        Destination destination = mDestinations.get(position);

        TextView tv = viewHolder.destinationTv;
        tv.setText(destination.name);
    }
 
    public class ViewHolder extends RecyclerView.ViewHolder {
        
        public TextView destinationTv;
        public ImageView bookmarkIv;

        public ViewHolder(View itemView) {
            super(itemView);
            destinationTv = (TextView) itemView.findViewById(R.id.text_destination);
            bookmarkIv = (ImageView) itemView.findViewById(R.id.image_bookmark);
        }
    }
}

}
