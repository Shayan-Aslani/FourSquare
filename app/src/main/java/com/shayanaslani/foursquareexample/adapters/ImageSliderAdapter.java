package com.shayanaslani.foursquareexample.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.shayanaslani.foursquareexample.R;
import com.shayanaslani.foursquareexample.model.VenuePhotoItem;
import com.smarteist.autoimageslider.SliderViewAdapter;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ImageSliderAdapter extends SliderViewAdapter<ImageSliderAdapter.SliderAdapterVH> {

    private Context context;
    private List<VenuePhotoItem> photoList;

    public ImageSliderAdapter(Context context, List list) {
        this.context = context;
        photoList = list;
    }

    @Override
    public ImageSliderAdapter.SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image_slider_layout, null);
        return new ImageSliderAdapter.SliderAdapterVH(inflate);
    }

    @Override
    public void onBindViewHolder(ImageSliderAdapter.SliderAdapterVH viewHolder, int position) {
        Picasso.get().load(photoList.get(position).getPrefix() + "400" + photoList.get(position).getSuffix())
                .fit()
                .into(viewHolder.imageViewBackground);
    }

    @Override
    public int getCount() {
        return photoList.size();
    }

    class SliderAdapterVH extends SliderViewAdapter.ViewHolder {
        View itemView;
        ImageView imageViewBackground;

        public SliderAdapterVH(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.image_slider_imageview);
            this.itemView = itemView;
        }
    }
}
