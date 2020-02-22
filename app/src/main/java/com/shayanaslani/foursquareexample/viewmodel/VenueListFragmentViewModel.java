package com.shayanaslani.foursquareexample.viewmodel;

import android.app.Application;
import android.content.Context;
import android.location.Location;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.maps.model.LatLng;
import com.shayanaslani.foursquareexample.repository.VenueRepository;
import com.shayanaslani.foursquareexample.model.Venue;

import java.util.List;

public class VenueListFragmentViewModel extends AndroidViewModel {

    private Context mContext ;
    private VenueRepository mRepository ;
    private LatLng latLng ;
    private int offset = 0 ;
    private boolean isEndOfList = false;

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

    public void loadVenueListFromApi(LatLng latLng , boolean newLatLng , boolean isNetworkAvailable){
        if(!isNetworkAvailable)
            return;
        if(newLatLng) {
            offset = 0 ;
            isEndOfList = false;
            this.latLng = latLng;
            mRepository.loadVenuesFromApi(latLng, offset , true);
        } else {
            offset += 30 ;
            mRepository.loadVenuesFromApi(this.latLng , offset , false);
            if(offset >= mRepository.getTotalResults())
                isEndOfList = true;
        }
    }

    public boolean isLastItem(){
        return isEndOfList;
    }

    public void loadVenuesFromDB(){
        mRepository.loadVenuesFromDB();
    }

    public void setLastLocation(LatLng latLng){
        mRepository.setLastLocation(latLng);
    }

    public boolean shouldLoadNewList(Location location){
        LatLng currentLatLng = new LatLng(location.getLatitude() , location.getLongitude());
        if(mRepository.getLastLocation() !=null) {
            LatLng lastLatLng = mRepository.getLastLocation();
            float[] result = new float[1];
            Location.distanceBetween(currentLatLng.latitude, currentLatLng.longitude, lastLatLng.latitude, lastLatLng.longitude, result);
            if (result[0] < 200) {
                isEndOfList = true;
                return false;
            }
        }
        isEndOfList = false;
        setLastLocation(currentLatLng);
        return true;
    }
}
