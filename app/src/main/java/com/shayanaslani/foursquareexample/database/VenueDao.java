package com.shayanaslani.foursquareexample.database;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.shayanaslani.foursquareexample.model.Venue;

import java.util.List;

@Dao
public interface VenueDao {
    @Query("SELECT * FROM venue")
    List<Venue> getAllVenues();
    @Query("SELECT * FROM venue WHERE id = :venueId")
    Venue getVenueById(String venueId);
    @Insert()
    void insertVenueList(List<Venue> venue);
    @Insert()
    void insertVenue(Venue venue);
    @Update
    void update(Venue venue);
    @Query("DELETE FROM venue")
    void clearVenues();
}
