package com.shayanaslani.foursquareexample.view.fragment;


import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shayanaslani.foursquareexample.R;
import com.shayanaslani.foursquareexample.databinding.FragmentVenueDetailBinding;
import com.shayanaslani.foursquareexample.databinding.FragmentVenueListBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class VenueDetailFragment extends Fragment {


    private FragmentVenueDetailBinding mBinding ;

    public static VenueDetailFragment newInstance() {
        
        Bundle args = new Bundle();
        
        VenueDetailFragment fragment = new VenueDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public VenueDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        mBinding = DataBindingUtil.inflate(inflater , R.layout.fragment_venue_detail, container, false);

        return mBinding.getRoot();
    }

}
