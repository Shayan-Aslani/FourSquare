package com.shayanaslani.foursquareexample;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.shayanaslani.foursquareexample.model.FourSquareJSON;

public class Repository {

    private static Repository mInstance ;
    private Context mContext ;

    private MutableLiveData<FourSquareJSON.Venue> mVenues ;

    public static Repository getInstance(Context context){
        if(mInstance == null)
            return new Repository(context);

        return mInstance;
    }
    private Repository(Context context) {
        mContext = context;
    }

    public MutableLiveData<FourSquareJSON.Venue> getVenues() {
        return mVenues;
    }

}
