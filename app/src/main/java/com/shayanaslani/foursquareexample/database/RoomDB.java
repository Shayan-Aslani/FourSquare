package com.shayanaslani.foursquareexample.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.shayanaslani.foursquareexample.model.Venue;

@Database(entities = Venue.class, version = 1)
public abstract class RoomDB extends RoomDatabase {
    public static final String DATABASE_NAME = "foursquare.db";
    public abstract VenueDao venueDao();
    private static RoomDB instance;

    public static synchronized RoomDB getInstance(Context context) {
        if (instance == null) {
            if (instance == null) {
                instance = Room.databaseBuilder(context.getApplicationContext(), RoomDB.class,
                        DATABASE_NAME)
                        .allowMainThreadQueries()
                        .build();
            }
        }
        return instance;
    }
}
