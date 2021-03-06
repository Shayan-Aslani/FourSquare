package com.shayanaslani.foursquareexample.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.shayanaslani.foursquareexample.R;
import com.shayanaslani.foursquareexample.databinding.ItemVenueListBinding;
import com.shayanaslani.foursquareexample.databinding.ItemVenueLoadingBinding;
import com.shayanaslani.foursquareexample.eventbus.OnVenueClickedMessage;
import com.shayanaslani.foursquareexample.model.Venue;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;

import java.util.List;


public class VenueAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final int VIEW_TYPE_ITEM = 0;
    private final int VIEW_TYPE_LOADING = 1;

    private boolean isLastPage = true ;

    private List<Venue> venueList;
    private Context mContext;

    public VenueAdapter(Context context) {
        mContext = context;
    }

    public void setVenueList(List<Venue> list) {
        venueList = list;
        notifyDataSetChanged();
    }


    public void setIsLastItem(boolean isLastPage) {
        this.isLastPage = isLastPage;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Activity activity = (Activity) parent.getContext();

        if(viewType == VIEW_TYPE_ITEM) {
            ItemVenueListBinding binding = DataBindingUtil.inflate(activity.getLayoutInflater(),
                    R.layout.item_venue_list, parent, false);
            return new VenueHolder(binding);
        }
        else {
                ItemVenueLoadingBinding loadingBinding = DataBindingUtil.inflate(activity.getLayoutInflater() ,
                        R.layout.item_venue_loading , parent , false);
                return new LoadingViewHolder(loadingBinding);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof VenueHolder)
            ((VenueHolder) holder).bind((venueList.get(position)));
    }

    @Override
    public int getItemCount() {
        return venueList == null ? 0 : venueList.size()  ;
    }

    @Override
    public int getItemViewType(int position) {
        if(isLastPage)
            return VIEW_TYPE_ITEM;
        return position == venueList.size() - 1  ? VIEW_TYPE_LOADING : VIEW_TYPE_ITEM;
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

    private class LoadingViewHolder extends RecyclerView.ViewHolder {
        public LoadingViewHolder(@NonNull ItemVenueLoadingBinding binding) {
            super(binding.getRoot());
        }
    }
}
