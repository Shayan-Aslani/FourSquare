package com.shayanaslani.foursquareexample.view.fragment;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.shayanaslani.foursquareexample.R;
import com.shayanaslani.foursquareexample.databinding.FragmentVenueDetailBinding;
import com.shayanaslani.foursquareexample.model.Venue;
import com.shayanaslani.foursquareexample.network.FoursquareService;
import com.shayanaslani.foursquareexample.network.RetrofitInstance;
import com.shayanaslani.foursquareexample.viewmodel.VenueDetailFragmentViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class VenueDetailFragment extends Fragment {

    private static final String VENUE_DETAIL_ARG = "venueIdArg";

    private FragmentVenueDetailBinding mBinding;
    private VenueDetailFragmentViewModel mViewModel;

    public static VenueDetailFragment newInstance(String venueId) {

        Bundle args = new Bundle();
        args.putString(VENUE_DETAIL_ARG, venueId);
        VenueDetailFragment fragment = new VenueDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public VenueDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(VenueDetailFragmentViewModel.class);
        mViewModel.loadVenueDetailFromApi(getArguments().getString(VENUE_DETAIL_ARG));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_venue_detail, container, false);


        return mBinding.getRoot();
    }
}
