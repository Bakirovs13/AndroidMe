package com.example.androidme.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

// Custom adapter class that displays a list of Android-Me images in a GridView
public class MasterListAdapter extends BaseAdapter {

    private Context mContext;
    private List<Integer>  mImageIds ;


    public MasterListAdapter(Context mContext, List<Integer> mImageIds) {
        this.mContext = mContext;
        this.mImageIds = mImageIds;
    }


    @Override
    public int getCount() {
        return mImageIds.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int pos, View view, ViewGroup viewGroup) {
        ImageView imageView;
        if(view ==null){
            imageView = new ImageView(mContext);
            imageView.setAdjustViewBounds(true);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8,8,8,8);
        }else{
            imageView = (ImageView) view;
        }
        imageView.setImageResource(mImageIds.get(pos));
        return imageView;
    }
}
