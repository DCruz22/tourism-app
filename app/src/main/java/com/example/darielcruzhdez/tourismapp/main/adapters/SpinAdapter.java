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
public class SpinAdapter extends ArrayAdapter<City> {

    // Your sent context
    private Context mContext;
    // Your custom values for the spinner (User)
    private List<City> mCities = new ArrayList<>();

    public SpinAdapter(Context context, int textViewResourceId,
                       List<City> values){
        super(context, textViewResourceId, values);
        this.mContext = context;
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
        ViewHolderItem holder;

        if(convertView == null){
            LayoutInflater inflater = ((Activity)mContext).getLayoutInflater();
            convertView = inflater.inflate(R.layout.spin_adapter, null);

            holder = new ViewHolderItem();
            holder.cityNameTV = (TextView) convertView.findViewById(R.id.spin_adapter_tv_item);

//            TextView tvItem = (TextView)convertView.findViewById(R.id.spin_adapter_tv_item);
//            tvItem.setText(mCities.get(position).getName());
            convertView.setTag(holder);

        }else {
            holder = (ViewHolderItem)convertView.getTag();
        }

        City item = mCities.get(position);

        if(item != null){
            holder.cityNameTV.setText(item.getName());
            holder.cityNameTV.setTag(item.getId());
        }

        return convertView;
    }

    public static class ViewHolderItem{
        TextView cityNameTV;
    }

}
