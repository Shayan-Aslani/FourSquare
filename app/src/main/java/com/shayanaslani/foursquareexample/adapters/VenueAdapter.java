package com.shayanaslani.foursquareexample.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.shayanaslani.foursquareexample.R;
import com.shayanaslani.foursquareexample.databinding.ItemVenueListBinding;

import java.util.List;

import static com.shayanaslani.foursquareexample.model.FourSquareJSON.*;

public class VenueAdapter extends RecyclerView.Adapter<VenueAdapter.VenueHolder> {

    private List<Venue> venueList;
    private Context mContext;

    public VenueAdapter(Context context, List<Venue> venues) {
        mContext = context;
        venueList = venues;
    }

    @NonNull
    @Override
    public VenueHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Activity activity = (Activity) parent.getContext();
        ItemVenueListBinding binding = DataBindingUtil.inflate(activity.getLayoutInflater(),
                R.layout.item_venue_list, parent, false);

        return new VenueHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull VenueHolder holder, int position) {
        Venue venue = venueList.get(position);
        holder.bind(venue);
    }

    @Override
    public int getItemCount() {
        return venueList == null ? 0 : venueList.size();
    }

    public class VenueHolder extends RecyclerView.ViewHolder {

        private ItemVenueListBinding mBinding;
        private Venue mVenue;

        public VenueHolder(@NonNull ItemVenueListBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        public void bind(Venue venue) {
            mVenue = venue;
        }
    }
}
