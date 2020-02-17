package com.shayanaslani.foursquareexample.adapters;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.shayanaslani.foursquareexample.R;
import com.shayanaslani.foursquareexample.databinding.ItemVenueListBinding;
import com.shayanaslani.foursquareexample.eventbus.OnVenueClickedMessage;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import static com.shayanaslani.foursquareexample.model.FourSquareJSON.*;

public class VenueItemsAdapter extends RecyclerView.Adapter<VenueItemsAdapter.VenueItemHolder> {

    private List<Items> venueItemsList;
    private Context mContext;

    public VenueItemsAdapter(Context context) {
        mContext = context;
    }

    public void setVenueItemsList(List<Items> list)
    {
        venueItemsList = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public VenueItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Activity activity = (Activity) parent.getContext();
        ItemVenueListBinding binding = DataBindingUtil.inflate(activity.getLayoutInflater(),
                R.layout.item_venue_list, parent, false);

        return new VenueItemHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull VenueItemHolder holder, int position) {
        Items items = venueItemsList.get(position);
        holder.bind(items);
    }

    @Override
    public int getItemCount() {
        return venueItemsList == null ? 0 : venueItemsList.size();
    }

    public class VenueItemHolder extends RecyclerView.ViewHolder {

        private ItemVenueListBinding mBinding;
        private Items mItems;

        public VenueItemHolder(@NonNull ItemVenueListBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        public void bind(Items items) {
            mItems = items;
            mBinding.venueAddressTv.setText(mItems.getVenue().getLocation().getAddress());
            mBinding.venueNameTv.setText(mItems.getVenue().getName());

            itemView.setOnClickListener(view -> {
                EventBus.getDefault().post(new OnVenueClickedMessage(mItems.getVenue().getId()));
            });
        }

    }
}
