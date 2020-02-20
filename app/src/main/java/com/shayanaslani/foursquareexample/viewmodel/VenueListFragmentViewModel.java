package com.shayanaslani.foursquareexample.viewmodel;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.maps.model.LatLng;
import com.shayanaslani.foursquareexample.repository.VenueRepository;
import com.shayanaslani.foursquareexample.model.Venue;

import java.util.ArrayList;
import java.util.List;

public class VenueListFragmentViewModel extends AndroidViewModel {

    private Context mContext ;
    private VenueRepository mRepository ;
    private LatLng latLng ;
    private int offset = 0 ;

    private MutableLiveData<List<Venue>> mVenueItems ;

    public VenueListFragmentViewModel(@NonNull Application application) {
        super(application);
        mContext = application ;
        mRepository = VenueRepository.getInstance(application);
        mVenueItems = mRepository.getVenueItems();
    }

    public LiveData<List<Venue>> getVenueItemsLiveData (){
        return mVenueItems ;
    }

    public void loadVenueListFromApi(LatLng latLng , boolean newLatLng){
        if(newLatLng) {
            offset = 0 ;
            this.latLng = latLng;
            mVenueItems.setValue(new ArrayList<>());
            mRepository.loadVenuesFromApi(latLng, offset);
        }
        else {
            offset += 30 ;
            mRepository.loadVenuesFromApi(this.latLng , offset);
        }
    }

    public boolean isLastItem(){

        return false;
    }
}
