package com.shayanaslani.foursquareexample.view.fragment;


import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shayanaslani.foursquareexample.R;
import com.shayanaslani.foursquareexample.Repository;
import com.shayanaslani.foursquareexample.databinding.FragmentPlaceDetailBinding;
import com.shayanaslani.foursquareexample.network.RetrofitInstance;

import retrofit2.Retrofit;


/**
 * A simple {@link Fragment} subclass.
 */
public class PlaceDetailFragment extends Fragment {


    private FragmentPlaceDetailBinding mBinding ;

    public static PlaceDetailFragment newInstance() {
        
        Bundle args = new Bundle();
        
        PlaceDetailFragment fragment = new PlaceDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public PlaceDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        mBinding = DataBindingUtil.inflate(inflater , R.layout.fragment_place_detail, container, false);

        return mBinding.getRoot();
    }

}
