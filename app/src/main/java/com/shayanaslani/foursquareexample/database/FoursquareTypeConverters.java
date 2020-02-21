package com.shayanaslani.foursquareexample.database;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.shayanaslani.foursquareexample.model.Venue;

import java.lang.reflect.Type;
import java.util.List;

public class FoursquareTypeConverters {

    @TypeConverter
    public static List<Venue.Categories> stringToCategoriesList(String data) {
        if (data == null) {
            return null ;
        }
        Gson gson = new Gson();
        Type typeToken = new TypeToken<List<Venue.Categories>>() {}.getType();
        return gson.fromJson(data, typeToken);
    }

    @TypeConverter
    public static String categoriesListToString(List<Venue.Categories> categoriesList) {
        Gson gson = new Gson();
        return gson.toJson(categoriesList);
    }
}
