package com.shayanaslani.foursquareexample.viewmodel;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.google.android.gms.maps.model.LatLng;
import com.shayanaslani.foursquareexample.repository.VenueRepository;
import com.shayanaslani.foursquareexample.model.Venue;

import java.util.List;

public class VenueListFragmentViewModel extends AndroidViewModel {

    private Context mContext ;
    private VenueRepository mRepository ;

    private LiveData<List<Venue>> mVenueItems ;

    public VenueListFragmentViewModel(@NonNull Application application) {
        super(application);
        mContext = application ;
        mRepository = VenueRepository.getInstance(application);
        mVenueItems = mRepository.getVenueItems();
    }

    public LiveData<List<Venue>> getVenueItemsLiveData (){
        return mVenueItems ;
    }

    public void loadVenueListFromApi(LatLng latLng){
        mRepository.loadVenuesFromApi(latLng);
    }
}
