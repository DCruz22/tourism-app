package com.example.darielcruzhdez.tourismapp.main.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.darielcruzhdez.tourismapp.R;
import com.example.darielcruzhdez.tourismapp.main.model.Destination;

import java.util.List;

/**
 * Created by darielcruzhdez on 10/8/16.
 */
public class DestinationAdapter extends RecyclerView.Adapter<DestinationAdapter.ViewHolder> {

    public interface ClickListener {
        void onItemClicked(Destination item);
    }

    public interface ImageListener {
        void onBookmarkImgClicked(Destination item);
    }

    private List<Destination> mDestinations;
    private ClickListener mClickListener;
    private ImageListener mImgListener;

    public DestinationAdapter(List<Destination> values, ClickListener clickListener, ImageListener imageListener){
        this.mDestinations = values;
        this.mClickListener = clickListener;
        this.mImgListener = imageListener;
    }

    @Override
    public int getItemCount() {
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
        tv.setText(destination.getName());
        tv.setOnClickListener(v -> mClickListener.onItemClicked(destination));
        viewHolder.bookmarkIv.setOnClickListener(v -> mImgListener.onBookmarkImgClicked(destination));
    }
 
    public class ViewHolder extends RecyclerView.ViewHolder {
        
        public TextView destinationTv;
        public ImageView bookmarkIv;

        public ViewHolder(View itemView) {
            super(itemView);
            destinationTv = itemView.findViewById(R.id.text_destination);
            bookmarkIv = itemView.findViewById(R.id.image_bookmark);
        }
    }
}
