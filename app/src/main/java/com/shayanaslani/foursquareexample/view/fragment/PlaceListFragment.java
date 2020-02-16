package com.shayanaslani.foursquareexample.view.fragment;


import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shayanaslani.foursquareexample.R;
import com.shayanaslani.foursquareexample.databinding.FragmentPlaceListBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class PlaceListFragment extends Fragment {

    private FragmentPlaceListBinding mBinding ;

    public static PlaceListFragment newInstance() {

        Bundle args = new Bundle();

        PlaceListFragment fragment = new PlaceListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public PlaceListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater , R.layout.fragment_place_list, container, false);

        return mBinding.getRoot();
    }

}
