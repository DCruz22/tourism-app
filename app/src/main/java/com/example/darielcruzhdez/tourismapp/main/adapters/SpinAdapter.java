package com.example.darielcruzhdez.tourismapp.main.adapters;

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
public class SpinAdapter extends ArrayAdapter<City> {

    // Your sent context
    private Context context;
    // Your custom values for the spinner (User)
    private List<City> mCities = new ArrayList<>();

    public SpinAdapter(Context context, int textViewResourceId,
                       List<City> values){
        super(context, textViewResourceId, values);
        this.context = context;
        this.mCities = values;
    }

    public void add(City item) {

        mCities.add(item);
        notifyDataSetChanged();

    }

    // Clears the list adapter of all items.

    public void clear() {

        mCities.clear();
        notifyDataSetChanged();

    }

    // Returns the number of ToDoItems

    @Override
    public int getCount() {

        return mCities.size();

    }

    // Retrieve the number of ToDoItems

    @Override
    public City getItem(int pos) {

        return mCities.get(pos);

    }

    // Get the ID for the ToDoItem
    // In this case it's just the position

    @Override
    public long getItemId(int pos) {

        return pos;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        return returnSpinnerView(position, convertView);
    }

    @Override
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {
        return returnSpinnerView(position, convertView);
    }

    public View returnSpinnerView(int position, View convertView){
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        convertView = inflater.inflate(R.layout.spin_adapter, null);

        TextView tvItem = (TextView)convertView.findViewById(R.id.spin_adapter_tv_item);
        tvItem.setText(mCities.get(position).getName());

        // And finally return your dynamic (or custom) view for each spinner item
        return convertView;
    }

}
