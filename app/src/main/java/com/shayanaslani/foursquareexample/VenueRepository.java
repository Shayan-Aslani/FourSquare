package com.shayanaslani.foursquareexample;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.maps.model.LatLng;
import com.shayanaslani.foursquareexample.model.Venue;
import com.shayanaslani.foursquareexample.network.FoursquareService;
import com.shayanaslani.foursquareexample.network.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VenueRepository {

    private static VenueRepository mInstance ;
    private Context mContext ;

    private MutableLiveData<List<Venue>> mVenueItems = new MutableLiveData<>();

    public static VenueRepository getInstance(Context context){
        if(mInstance == null)
            return new VenueRepository(context);

        return mInstance;
    }
    private VenueRepository(Context context) {
        mContext = context;
    }

    public MutableLiveData<List<Venue>> getVenueItems() {
        return mVenueItems;
    }

    public MutableLiveData<List<Venue>> loadVenuesFromApi(LatLng latLng){
        String latLngString = latLng.latitude + "," + latLng.longitude ;
        RetrofitInstance.getInstance().getRetrofit().create(FoursquareService.class).loadFromApi(latLngString).enqueue(new Callback<List<Venue>>() {
            @Override
            public void onResponse(Call<List<Venue>> call, Response<List<Venue>> response) {
                if(response.isSuccessful())
                    mVenueItems.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Venue>> call, Throwable t) {
                Log.d("network" , t.getMessage());
            }
        });
        return mVenueItems;
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
                        Log.d("network" , t.getMessage());
                    }
                });
        return venueMutableLiveData;
    }
}
