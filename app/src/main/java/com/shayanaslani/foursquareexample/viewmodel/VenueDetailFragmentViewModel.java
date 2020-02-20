package com.shayanaslani.foursquareexample.viewmodel;

import android.app.Application;
import android.content.Context;
import android.graphics.Color;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.shayanaslani.foursquareexample.repository.VenueRepository;
import com.shayanaslani.foursquareexample.model.VenuePhotoItem;
import com.shayanaslani.foursquareexample.model.Venue;

import java.util.List;

public class VenueDetailFragmentViewModel extends AndroidViewModel {

    private VenueRepository mRepository ;
    private Context mContext ;
    private LiveData<Venue> mVenue ;
    private LiveData<List<VenuePhotoItem>> mPhotos ;

    public VenueDetailFragmentViewModel(@NonNull Application application) {
        super(application);
        mContext = application;
        mRepository = VenueRepository.getInstance(application);
        mVenue = new MutableLiveData<>();
        mPhotos = new MutableLiveData<>();
    }

    public LiveData<Venue> getVenueLiveData(){
        return mVenue ;
    }

    public void loadVenueDetailFromApi(String id){
        mVenue = mRepository.loadVenueDetailsById(id);
    }

    public LiveData<List<VenuePhotoItem>> getVeunePhotos(){
        return mPhotos;
    }

    public void loadVenuePhotosFromApi(String id , String limit){
        mPhotos = mRepository.loadVenuePhotos(id , limit) ;
    }

    public String getVenueTips(){
        if(mVenue.getValue().getTips().getCount()!=0)
            return mVenue.getValue().getTips().getGroups().get(0).getItems().get(0).getText();
        return null;
    }
}
