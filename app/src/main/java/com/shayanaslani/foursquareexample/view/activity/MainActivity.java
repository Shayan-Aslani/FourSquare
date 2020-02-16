package com.shayanaslani.foursquareexample.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.shayanaslani.foursquareexample.R;
import com.shayanaslani.foursquareexample.view.fragment.PlaceListFragment;

public class MainActivity extends SingleFragmentActivity {

    @Override
    public Fragment createFragment() {
        return PlaceListFragment.newInstance();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_fragment);
    }
}
