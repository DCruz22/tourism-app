package com.example.darielcruzhdez.tourismapp.main.ui.activities;

import com.example.darielcruzhdez.tourismapp.main.adapters.CitiesAdapter;
import com.example.darielcruzhdez.tourismapp.main.adapters.TourismPageAdapter;
import com.example.darielcruzhdez.tourismapp.main.models.City;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

import com.example.darielcruzhdez.tourismapp.R;
import com.example.darielcruzhdez.tourismapp.main.ui.fragments.CitiesFragment;
import com.example.darielcruzhdez.tourismapp.main.ui.fragments.DestinationsFragment;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = MainActivity.class.getCanonicalName();

    private ViewPager mViewPager;
    private TabLayout mTab;

    private static List<City> mCities;

    private TourismPageAdapter mPageAdapter;
    private CitiesAdapter mCitiesAdapter;
    private ArrayAdapter<String> mDestinationsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mViewPager = findViewById(R.id.pager);
        mTab = findViewById(R.id.tab_layout);

        mPageAdapter = new TourismPageAdapter(getSupportFragmentManager());
        mPageAdapter.addFragment(new CitiesFragment(), getString(R.string.cities_page_title));
        mPageAdapter.addFragment(new DestinationsFragment(), getString(R.string.destinations_page_title));

        mViewPager.setAdapter(mPageAdapter);
        mTab.setupWithViewPager(mViewPager);

        /*  Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + city.getName() + ", " + destination);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);*/

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
