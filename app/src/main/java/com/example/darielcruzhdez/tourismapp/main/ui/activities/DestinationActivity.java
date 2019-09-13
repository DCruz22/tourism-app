package com.example.darielcruzhdez.tourismapp.main.ui.activities;

import com.example.darielcruzhdez.tourismapp.main.ui.fragments.DestinationsFragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.darielcruzhdez.tourismapp.R;

public class DestinationActivity extends AppCompatActivity {

    private final static String TAG = DestinationActivity.class.getCanonicalName();

    private DestinationsFragment mDestinationFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination);

        Intent i = getIntent();
        mDestinationFragment = new DestinationsFragment();
        String cityName;

        if((cityName = i.getStringExtra("CITY_NAME")) != null){
            Bundle bundle = new Bundle();
            bundle.putString("CITY_NAME", cityName);
            mDestinationFragment.setArguments(bundle);
        }

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fav_destinations_frame, mDestinationFragment);
        ft.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
