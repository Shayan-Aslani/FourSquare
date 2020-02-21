package com.shayanaslani.foursquareexample.view.fragment;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shayanaslani.foursquareexample.R;
import com.shayanaslani.foursquareexample.adapters.ImageSliderAdapter;
import com.shayanaslani.foursquareexample.databinding.FragmentVenueDetailBinding;
import com.shayanaslani.foursquareexample.viewmodel.VenueDetailFragmentViewModel;


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
        mViewModel.loadVenuePhotosFromApi(getArguments().getString(VENUE_DETAIL_ARG), "10");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_venue_detail, container, false);

        mBinding.venueDetailScrollview.setVisibility(View.GONE);

        setObservers();

        /*
            Uri gmmIntentUri = Uri.parse("geo:"+mViewModel.getVenueLiveData().getValue().getLocation().getLat() +
                    "," + mViewModel.getVenueLiveData().getValue().getLocation().getLng());
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            if (mapIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                startActivity(mapIntent);
            }

         */

        mBinding.venueDetailBackMenu.setOnClickListener(view -> getActivity().onBackPressed());
        return mBinding.getRoot();
    }

    private void setObservers(){
        mViewModel.getVenueLiveData().observe(getActivity(), venue -> {

            mBinding.veuneDetailProgressbar.setVisibility(View.GONE);
            mBinding.venueDetailScrollview.setVisibility(View.VISIBLE);
            mBinding.venueDetailTv.setText(venue.getName());
            mBinding.venueDetailLikeTv.setText(String.valueOf(venue.getLikes().getCount()));
            mBinding.veuneDetailProgressbar.setVisibility(View.GONE);
            mBinding.venueDetailScrollview.setVisibility(View.VISIBLE);
            mBinding.venueDetailRateTv.setText(venue.getRating());
            ((GradientDrawable)mBinding.venueDetailRateTv.getBackground())
                    .setColor(Color.parseColor("#" + venue.getRatingColor()));
            if(mViewModel.getVenueTips() != null)
                mBinding.venueDetailTipsTv.setText(mViewModel.getVenueTips());
        });

        mViewModel.getVeunePhotos().observe(getActivity(), items -> {
            mBinding.venueDetailImageSlider.setSliderAdapter(new ImageSliderAdapter(getContext(), items));
        });
    }
}
