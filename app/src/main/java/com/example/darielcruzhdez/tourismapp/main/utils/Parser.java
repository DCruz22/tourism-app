package com.example.darielcruzhdez.tourismapp.main.utils;

import android.content.Context;
import android.content.res.Resources;

import com.example.darielcruzhdez.tourismapp.R;
import com.example.darielcruzhdez.tourismapp.main.models.City;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

/**
 * Created by darielcruzhdez on 1/1/17.
 */

public class Parser {

    private static Gson gson = new Gson();

    public static List<City> getCitiesFromJson(Context c) {

        try {
            Resources res = c.getResources();
            InputStream in_s = res.openRawResource(R.raw.locations);

            byte[] b = new byte[in_s.available()];

            in_s.read(b);
            return Arrays.asList(gson.fromJson(new String(b), City[].class));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
