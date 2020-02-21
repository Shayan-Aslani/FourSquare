package com.shayanaslani.foursquareexample.database;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.shayanaslani.foursquareexample.model.Venue;

import java.util.List;

@Dao
public interface VenueDao {
    @Query("SELECT * FROM venue")
    List<Venue> getAllVenues();
    @Insert()
    void insert(List<Venue> venue);
    @Query("DELETE FROM venue")
    void clear();
}
