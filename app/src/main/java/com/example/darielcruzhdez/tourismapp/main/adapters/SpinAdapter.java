package com.example.darielcruzhdez.tourismapp.main.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.darielcruzhdez.tourismapp.main.models.City;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
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
                       City[] values){
        super(context, textViewResourceId, values);
        this.context = context;
        this.mCities = Arrays.asList(values);
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
        // I created a dynamic TextView here, but you can reference your own  custom layout for each spinner item
        TextView label = new TextView(context);
        label.setTextColor(Color.BLACK);
        // Then you can get the current item using the values array (Users array) and the current position
        // You can NOW reference each method you has created in your bean object (User class)
        label.setText(mCities.get(position).getName());

        // And finally return your dynamic (or custom) view for each spinner item
        return label;
    }

    @Override
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {
        TextView label = new TextView(context);
        label.setTextColor(Color.BLACK);
        label.setText(mCities.get(position).getName());

        return label;
    }

}
