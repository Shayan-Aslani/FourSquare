package com.shayanaslani.foursquareexample.view.fragment;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.model.LatLng;
import com.shayanaslani.foursquareexample.R;
import com.shayanaslani.foursquareexample.VenueRepository;
import com.shayanaslani.foursquareexample.adapters.VenueItemsAdapter;
import com.shayanaslani.foursquareexample.databinding.FragmentVenueListBinding;
import com.shayanaslani.foursquareexample.viewmodel.VenueListFragmentViewModel;

import java.util.ArrayList;
import java.util.List;

import static com.shayanaslani.foursquareexample.model.FourSquareJSON.*;


/**
 * A simple {@link Fragment} subclass.
 */
public class VenueListFragment extends Fragment {

    private FragmentVenueListBinding mBinding ;
    private VenueListFragmentViewModel mViewModel ;
    private VenueItemsAdapter venueItemsAdapter ;

    public static VenueListFragment newInstance() {

        Bundle args = new Bundle();

        VenueListFragment fragment = new VenueListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public VenueListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = ViewModelProviders.of(getActivity()).get(VenueListFragmentViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater , R.layout.fragment_venue_list, container, false);

        setupRecyclerView();

        mViewModel.loadVenueListFromApi(new LatLng(35.69,51.40));

        mViewModel.getVenueItemsLiveData().observe(this , items -> {
            venueItemsAdapter.setVenueItemsList(items);
        });


        return mBinding.getRoot();
    }

    private void setupRecyclerView(){
        venueItemsAdapter = new VenueItemsAdapter(getContext());
        mBinding.placeListRv.setLayoutManager(new LinearLayoutManager(getContext()));
        mBinding.placeListRv.setAdapter(venueItemsAdapter);
    }

}
