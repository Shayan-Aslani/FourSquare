package com.shayanaslani.foursquareexample.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.android.gms.maps.model.LatLng;
import com.google.gson.Gson;


public class Preferences {
    private static final String PREF_NAME = "Foursquare";

    private static final String PREF_LAST_LOCATION = "lastLocation";

    private static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public static LatLng getPrefLastLocation(Context context) {
        SharedPreferences prefs = getSharedPreferences(context);
        if (prefs == null)
            return null;
        Gson gson = new Gson();
        String jsonText = prefs.getString(PREF_LAST_LOCATION, null);
        LatLng latLng = gson.fromJson(jsonText, LatLng.class);

        return latLng;
    }

    public static void setPrefLastLocation(Context context, LatLng latLng) {
        SharedPreferences prefs = getSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String jsonText = gson.toJson(latLng);
        editor.putString(PREF_LAST_LOCATION, jsonText);
        editor.apply();
    }
}
