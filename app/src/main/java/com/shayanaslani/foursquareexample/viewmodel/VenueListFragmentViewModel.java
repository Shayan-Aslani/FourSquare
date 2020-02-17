package com.shayanaslani.foursquareexample.viewmodel;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.maps.model.LatLng;
import com.shayanaslani.foursquareexample.VenueRepository;
import com.shayanaslani.foursquareexample.model.FourSquareJSON;
import com.shayanaslani.foursquareexample.network.RetrofitInstance;

import java.util.List;

public class VenueListFragmentViewModel extends AndroidViewModel {

    private Context mContext ;
    private VenueRepository mRepository ;

    private LiveData<List<FourSquareJSON.Items>> mVenueItems ;

    public VenueListFragmentViewModel(@NonNull Application application) {
        super(application);
        mContext = application ;
        mRepository = VenueRepository.getInstance(application);
        mVenueItems = mRepository.getVenueItems();
    }

    public LiveData<List<FourSquareJSON.Items>> getVenueItemsLiveData (){
        return mVenueItems ;
    }

    public void loadVenueListFromApi(LatLng latLng){
        mRepository.loadVenuesFromApi(latLng);
    }
}
