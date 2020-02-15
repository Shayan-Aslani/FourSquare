package com.shayanaslani.foursquareexample.view.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shayanaslani.foursquareexample.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class PlaceDetailFragment extends Fragment {

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
        return inflater.inflate(R.layout.fragment_place_detail, container, false);
    }

}
