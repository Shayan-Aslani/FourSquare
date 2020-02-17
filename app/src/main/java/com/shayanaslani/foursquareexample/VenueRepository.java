package com.shayanaslani.foursquareexample;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.maps.model.LatLng;
import com.shayanaslani.foursquareexample.model.FourSquareJSON;
import com.shayanaslani.foursquareexample.network.FoursquareService;
import com.shayanaslani.foursquareexample.network.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VenueRepository {

    private static VenueRepository mInstance ;
    private Context mContext ;

    private MutableLiveData<List<FourSquareJSON.Items>> mVenueItems = new MutableLiveData<>();

    public static VenueRepository getInstance(Context context){
        if(mInstance == null)
            return new VenueRepository(context);

        return mInstance;
    }
    private VenueRepository(Context context) {
        mContext = context;
    }

    public MutableLiveData<List<FourSquareJSON.Items>> getVenueItems() {
        return mVenueItems;
    }

    public MutableLiveData<List<FourSquareJSON.Items>> loadVenuesFromApi(LatLng latLng){
        String latLngString = latLng.latitude + "," + latLng.longitude ;
        RetrofitInstance.getInstance().getRetrofit().create(FoursquareService.class).loadFromApi(latLngString).enqueue(new Callback<FourSquareJSON>() {
            @Override
            public void onResponse(Call<FourSquareJSON> call, Response<FourSquareJSON> response) {
                if(response.isSuccessful())
                    mVenueItems.postValue(response.body().getResponse().getGroups().get(0).getItems());
            }

            @Override
            public void onFailure(Call<FourSquareJSON> call, Throwable t) {

            }
        });

        return mVenueItems;
    }

    public void loadVenueDetailsById(String id){

    }
}
