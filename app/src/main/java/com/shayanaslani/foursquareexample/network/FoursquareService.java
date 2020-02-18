package com.shayanaslani.foursquareexample.network;

import com.shayanaslani.foursquareexample.model.Venue;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface FoursquareService {

    @GET("explore")
    Call<List<Venue>> loadFromApi(@Query("ll") String latLng);

    @GET("{id}")
    Call<Venue> loadDetailsFromApi(@Path("id") String venueId);
}
