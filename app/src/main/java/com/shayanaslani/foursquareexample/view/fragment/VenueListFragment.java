package com.shayanaslani.foursquareexample.view.fragment;


import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;
import com.shayanaslani.foursquareexample.R;
import com.shayanaslani.foursquareexample.adapters.VenueAdapter;
import com.shayanaslani.foursquareexample.databinding.FragmentVenueListBinding;
import com.shayanaslani.foursquareexample.viewmodel.VenueListFragmentViewModel;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;


/**
 * A simple {@link Fragment} subclass.
 */
public class VenueListFragment extends Fragment {

    public static final int PERMISSION_ID = 100;
    private FragmentVenueListBinding mBinding;
    private VenueListFragmentViewModel mViewModel;

    private VenueAdapter venueAdapter;

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
        if (!checkPermissions()) {
            requestPermission();
        }
        if (!isLocationEnabled()) {
            requestLocation();
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
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_ID) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(getContext(), "permissin", Toast.LENGTH_SHORT).show();
            } else if (shouldShowRequestPermissionRationale(ACCESS_FINE_LOCATION)) {
                new AlertDialog.Builder(getActivity())
                        .setMessage("You need to allow access to both the permissions")
                        .setPositiveButton("OK", (dialogInterface, i) -> requestPermission())
                        .setNegativeButton("Cancel", null)
                        .create()
                        .show();
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_venue_list, container, false);

        setupRecyclerView();

        mViewModel.loadVenueListFromApi(new LatLng(35.69, 51.40));

        mViewModel.getVenueItemsLiveData().observe(this, items -> {
            venueAdapter.setVenueList(items);
        });

        return mBinding.getRoot();
    }

    private void setupRecyclerView() {
        venueAdapter = new VenueAdapter(getContext());
        mBinding.placeListRv.setLayoutManager(new LinearLayoutManager(getContext()));
        mBinding.placeListRv.setAdapter(venueAdapter);
    }

    private boolean checkPermissions() {
        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            return true;
        }
        return false;
    }

    private void requestPermission() {
        requestPermissions(
                new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION},
                PERMISSION_ID
        );
    }

    private boolean isLocationEnabled() {
        LocationManager locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(
                LocationManager.NETWORK_PROVIDER
        );
    }

    private void requestLocation() {
        new AlertDialog.Builder(getActivity())
                .setMessage("You need to turn on location")
                .setPositiveButton("Turn on", (dialogInterface, i) -> {
                            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                            startActivity(intent);
                        })
                .setNegativeButton("Cancel", null)
                .create()
                .show();
    }
}
