package com.shayanaslani.foursquareexample.network;

import com.shayanaslani.foursquareexample.model.VenueListResponse;
import com.shayanaslani.foursquareexample.model.VenuePhotoItem;
import com.shayanaslani.foursquareexample.model.Venue;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface FoursquareService {

    @GET("explore")
    Call<VenueListResponse> loadFromApi(@Query("ll") String latLng , @Query("offset") int offset);

    @GET("{id}")
    Call<Venue> loadDetailsFromApi(@Path("id") String venueId);

    @GET("{id}/photos")
    Call<List<VenuePhotoItem>> loadVenuePhotos(@Path("id") String venueId, @Query("limit") String limit);
}
