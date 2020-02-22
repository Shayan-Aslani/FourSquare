package com.shayanaslani.foursquareexample.view.fragment;


import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;
import com.shayanaslani.foursquareexample.R;
import com.shayanaslani.foursquareexample.adapters.VenueAdapter;
import com.shayanaslani.foursquareexample.databinding.FragmentVenueListBinding;
import com.shayanaslani.foursquareexample.eventbus.OnVenueClickedMessage;
import com.shayanaslani.foursquareexample.util.Utils;
import com.shayanaslani.foursquareexample.viewmodel.VenueListFragmentViewModel;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;


/**
 * A simple {@link Fragment} subclass.
 */
public class VenueListFragment extends Fragment {

    public static final int PERMISSION_ID = 100;

    private VenueAdapter venueAdapter;

    private FragmentVenueListBinding mBinding;
    private VenueListFragmentViewModel mViewModel;

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
        if (!Utils.checkPermissions(getContext()))
            requestPermission();
        if (!Utils.isLocationEnabled(getActivity()))
            requestLocationAccess();
        if (!Utils.isNetworkAvailable(getActivity())) {
            Toast.makeText(getContext(), R.string.offline_mode, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_venue_list, container, false);

        setupRecyclerView();
        setObservers();
        setOnClickListeners();

        mViewModel.loadVenuesFromDB();

        if (Utils.isLocationEnabled(getActivity()) && Utils.checkPermissions(getContext()) && Utils.isNetworkAvailable(getActivity()))
            requestNewLocationData();

        return mBinding.getRoot();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_ID) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(getContext(), R.string.permission_granted, Toast.LENGTH_SHORT).show();
            } else if (shouldShowRequestPermissionRationale(ACCESS_FINE_LOCATION)) {
                new AlertDialog.Builder(getActivity())
                        .setMessage(getString(R.string.request_permissions))
                        .setPositiveButton(getString(R.string.ok), (dialogInterface, i) -> requestPermission())
                        .setNegativeButton(getString(R.string.cancel), null)
                        .create()
                        .show();
            }
        }
    }

    private void setupRecyclerView() {
        venueAdapter = new VenueAdapter(getContext());
        mBinding.placeListRv.setLayoutManager(new LinearLayoutManager(getContext()));
        mBinding.placeListRv.setAdapter(venueAdapter);
        setScrollListener();
    }

    private void setObservers() {
        mViewModel.getVenueItemsLiveData().observe(this, items -> {
            if(items.size() == 0)
                mBinding.venueListLogoIv.setVisibility(View.VISIBLE);
            else
                mBinding.venueListLogoIv.setVisibility(View.GONE);

            mBinding.venueListProgressbar.setVisibility(View.GONE);
            mBinding.placeListRv.setVisibility(View.VISIBLE);
            venueAdapter.setVenueList(items);
        });
    }

    private void setOnClickListeners() {
        mBinding.venueListLocationFab.setOnClickListener(view -> {
            if(Utils.isLocationEnabled(getActivity())) {
                if (Utils.isNetworkAvailable(getActivity())) {
                    requestNewLocationData();
                }
                else
                    Toast.makeText(getContext(), R.string.network_unavailable, Toast.LENGTH_SHORT).show();
            }
            else
                requestLocationAccess();
        });
    }

    private void setScrollListener() {
        mBinding.placeListRv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                if (linearLayoutManager != null && linearLayoutManager.findLastCompletelyVisibleItemPosition() == venueAdapter.getItemCount() - 1
                        && !mViewModel.isLastItem()) {
                    mViewModel.loadVenueListFromApi(null, false, Utils.isNetworkAvailable(getActivity()));
                }

                venueAdapter.setIsLastItem(mViewModel.isLastItem());
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void OnVenueItemClicked(OnVenueClickedMessage onVenueClickedMessage) {
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, VenueDetailFragment.newInstance(onVenueClickedMessage.getVenueId()))
                .addToBackStack(null)
                .commit();
    }


    private void requestPermission() {
        requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION},
                PERMISSION_ID);
    }

    private void requestLocationAccess() {
        new AlertDialog.Builder(getActivity())
                .setMessage(getString(R.string.need_location))
                .setPositiveButton(getString(R.string.turn_on), (dialogInterface, i) -> {
                    Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                    startActivity(intent);
                })
                .setNegativeButton(getString(R.string.cancel), null)
                .create()
                .show();
    }

    @SuppressLint("MissingPermission")
    private void requestNewLocationData() {
        Toast.makeText(getContext(), "getting location", Toast.LENGTH_SHORT).show();
        android.location.LocationListener locationListener = new android.location.LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                if (mViewModel.shouldLoadNewList(location)) {
                    LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
                    mViewModel.loadVenueListFromApi(latLng, true, Utils.isNetworkAvailable(getActivity()));
                    mBinding.venueListProgressbar.setVisibility(View.VISIBLE);
                    mBinding.placeListRv.setVisibility(View.GONE);
                }
            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {

            }
        };

        int minTime = 60000;
        float minDistance = 200;
        LocationManager locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        criteria.setPowerRequirement(Criteria.POWER_LOW);
        criteria.setAccuracy(Criteria.ACCURACY_LOW);
        criteria.setAltitudeRequired(false);
        criteria.setBearingRequired(false);
        criteria.setSpeedRequired(false);
        String bestProvider = locationManager.getBestProvider(criteria, false);
        locationManager.requestLocationUpdates(bestProvider, minTime, minDistance, locationListener);
    }
}
