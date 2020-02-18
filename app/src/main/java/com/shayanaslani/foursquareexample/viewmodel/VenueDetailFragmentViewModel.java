package com.shayanaslani.foursquareexample.viewmodel;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.shayanaslani.foursquareexample.VenueRepository;
import com.shayanaslani.foursquareexample.model.Venue;

public class VenueDetailFragmentViewModel extends AndroidViewModel {

    private VenueRepository mRepository ;
    private Context mContext ;
    private LiveData<Venue> mVenue ;

    public VenueDetailFragmentViewModel(@NonNull Application application) {
        super(application);
        mContext = application;
        mRepository = VenueRepository.getInstance(application);
        mVenue = new MutableLiveData<>();
    }

    public LiveData<Venue> getVenueLiveData(){
        return mVenue ;
    }

    public void loadVenueDetailFromApi(String id){
        mRepository.loadVenueDetailsById(id);
    }
}
