package com.shayanaslani.foursquareexample.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.style.BackgroundColorSpan;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.shayanaslani.foursquareexample.R;
import com.shayanaslani.foursquareexample.databinding.ItemVenueListBinding;
import com.shayanaslani.foursquareexample.eventbus.OnVenueClickedMessage;
import com.shayanaslani.foursquareexample.model.Venue;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import static java.security.AccessController.getContext;


public class VenueAdapter extends RecyclerView.Adapter<VenueAdapter.VenueHolder> {

    private List<Venue> venueList;
    private Context mContext;

    public VenueAdapter(Context context) {
        mContext = context;
    }

    public void setVenueList(List<Venue> list) {
        venueList = list;
        notifyDataSetChanged();
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
        Venue items = venueList.get(position);
        holder.bind(items);
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
            mBinding.venueCategoryTv.setText(mVenue.getCategories().get(0).getName());
            mBinding.venueNameTv.setText(mVenue.getName());
            mBinding.venueDistanceTv.setText(mVenue.getLocation().getDistance() + "m");
            Venue.Icon icon = mVenue.getCategories().get(0).getIcon();
            Picasso.get().load(icon.getPrefix() + 88 +  icon.getSuffix()).into(mBinding.veunePhotoImageview);

            itemView.setOnClickListener(view -> {
                EventBus.getDefault().post(new OnVenueClickedMessage(mVenue.getId()));
            });
        }
    }
}
