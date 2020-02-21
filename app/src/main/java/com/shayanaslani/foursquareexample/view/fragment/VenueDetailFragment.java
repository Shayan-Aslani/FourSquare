package com.shayanaslani.foursquareexample.view.fragment;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.GradientDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
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
    private String mVenueId ;

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
        mVenueId = getArguments().getString(VENUE_DETAIL_ARG);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_venue_detail, container, false);

        if (isNetworkAvailable()) {
            loadVenueDetailFromApi(mVenueId);
        }
        else
        {
            onNetworkUnavailable();
        }

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
//            if(isNetworkAvailable())
//                mViewModel.saveToDB();
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

        mBinding.venueDetailTryAgainBtn.setOnClickListener(view -> {
            if(isNetworkAvailable())
                loadVenueDetailFromApi(mVenueId);
        });

        mViewModel.getVeunePhotos().observe(getActivity(), items -> {
            mBinding.venueDetailImageSlider.setSliderAdapter(new ImageSliderAdapter(getContext(), items));
        });
    }

    private void onNetworkUnavailable(){
        mBinding.venueDetailTryAgainBtn.setVisibility(View.VISIBLE);
        mBinding.networkFailTv.setVisibility(View.VISIBLE);
        mBinding.veuneDetailProgressbar.setVisibility(View.GONE);
    }

    private void loadVenueDetailFromApi(String venueId){
        mBinding.venueDetailTryAgainBtn.setVisibility(View.GONE);
        mBinding.veuneDetailProgressbar.setVisibility(View.VISIBLE);
        mBinding.networkFailTv.setVisibility(View.GONE);
        mViewModel.loadVenueDetailFromApi(venueId);
        mViewModel.loadVenuePhotosFromApi(venueId, "10");
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
