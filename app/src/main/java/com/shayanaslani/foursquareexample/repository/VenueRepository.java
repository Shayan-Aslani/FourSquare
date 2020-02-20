package com.shayanaslani.foursquareexample.repository;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.maps.model.LatLng;
import com.shayanaslani.foursquareexample.model.VenueListResponse;
import com.shayanaslani.foursquareexample.model.VenuePhotoItem;
import com.shayanaslani.foursquareexample.model.Venue;
import com.shayanaslani.foursquareexample.network.FoursquareService;
import com.shayanaslani.foursquareexample.network.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VenueRepository {

    public static final String NETWORK_TAG = "network";

    private static VenueRepository mInstance ;
    private Context mContext ;

    private MutableLiveData<List<Venue>> mVenueItems = new MutableLiveData<>();
    private int totalResults = 0 ;

    public static VenueRepository getInstance(Context context){
        if(mInstance == null)
            return new VenueRepository(context);
        return mInstance;
    }

    private VenueRepository(Context context) {
        mContext = context;
        mVenueItems.postValue(new ArrayList<>());
    }

    public MutableLiveData<List<Venue>> getVenueItems() {
        return mVenueItems;
    }

    public void loadVenuesFromApi(LatLng latLng , int offset , boolean newLatLng){
        String latLngString = latLng.latitude + "," + latLng.longitude ;

        if(newLatLng)
            mVenueItems.setValue(new ArrayList<>());
        RetrofitInstance.getInstance().getRetrofit().create(FoursquareService.class).loadFromApi(latLngString , offset).
                enqueue(new Callback<VenueListResponse>() {
            @Override
            public void onResponse(Call<VenueListResponse> call, Response<VenueListResponse> response) {
                if(response.isSuccessful()) {
                    List<Venue> list = mVenueItems.getValue();
                    list.addAll(response.body().getVenueList());
                    mVenueItems.postValue(list);
                    totalResults = response.body().getTotalResults();
                }
            }

            @Override
            public void onFailure(Call<VenueListResponse> call, Throwable t) {
                Log.d(NETWORK_TAG , t.getMessage());
            }
        });
    }

    public LiveData<Venue> loadVenueDetailsById(String id){
        MutableLiveData<Venue> venueMutableLiveData = new MutableLiveData<>();
        RetrofitInstance.getInstance().getRetrofit().create(FoursquareService.class).loadDetailsFromApi(id).
                enqueue(new Callback<Venue>() {
                    @Override
                    public void onResponse(Call<Venue> call, Response<Venue> response) {
                        if(response.isSuccessful()){
                            venueMutableLiveData.postValue(response.body());
                        }
                    }
                    @Override
                    public void onFailure(Call<Venue> call, Throwable t) {
                        Log.d(NETWORK_TAG , t.getMessage());
                    }
                });
        return venueMutableLiveData;
    }

    public LiveData<List<VenuePhotoItem>> loadVenuePhotos(String id , String limit){
        MutableLiveData<List<VenuePhotoItem>> photosResponseMutableLiveData = new MutableLiveData<>();
        RetrofitInstance.getInstance().getRetrofit().create(FoursquareService.class).loadVenuePhotos(id , limit)
                .enqueue(new Callback<List<VenuePhotoItem>>() {
            @Override
            public void onResponse(Call<List<VenuePhotoItem>> call, Response<List<VenuePhotoItem>> response) {
                if(response.isSuccessful())
                    photosResponseMutableLiveData.postValue(response.body());
                else if(response.raw().code() == 429)
                    Toast.makeText(mContext, "Quota exceeded", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<VenuePhotoItem>> call, Throwable t) {
                Log.d(NETWORK_TAG , t.getMessage());
            }
        });
        return photosResponseMutableLiveData;
    }

    public int getTotalResults() {
        return totalResults;
    }
}
