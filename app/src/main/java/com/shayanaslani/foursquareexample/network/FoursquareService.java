package com.shayanaslani.foursquareexample.network;

import com.google.android.gms.maps.model.LatLng;
import com.shayanaslani.foursquareexample.model.FourSquareJSON;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface FoursquareService {

    @GET("explore")
    Call<FourSquareJSON> loadFromApi(@Query("latLng") String latLng);

//    @GET("{id}")
//    Call<> loadDetailsFromApi(@Path("id") String venueId);
}
