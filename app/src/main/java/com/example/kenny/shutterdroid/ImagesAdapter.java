package com.example.kenny.shutterdroid;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.kenny.shutterdroid.api.Image;
import com.example.kenny.shutterdroid.api.ShutterStock;
import com.squareup.picasso.Picasso;

import java.util.Date;
import java.util.List;

import retrofit.Callback;

/**
 * Created by Kenny on 2015-07-02.
 */
public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.ViewHolder> {
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView mImageView;
        public ViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView)itemView;
        }
    }

    private List<Image> mImages;
    private Context mContext;

    public ImagesAdapter(Context context, List<Image> images) {
        mContext = context;
        mImages = images;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.grid_image, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Image image = mImages.get(i);
        Picasso.with(mContext).load(image.getLargeThumb()).into(viewHolder.mImageView);
    }

    @Override
    public int getItemCount() {
        return mImages.size();
    }
}
