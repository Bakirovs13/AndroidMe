package com.example.androidme.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.androidme.data.AndroidImageAssets;
import com.example.androidme.databinding.FragmentBodyPartBinding;

import java.util.ArrayList;
import java.util.List;


public class BodyPartFragment extends Fragment {

    FragmentBodyPartBinding binding;

    public static final  String IMAGE_ID_LIST = "image_ids";
    public static final  String LIST_INDEX = "list_index";

    List<Integer> mImageIds;
    private int mListIndex;

    public BodyPartFragment() {
        // Required empty public constructor
    }

    public void setImageIds(List<Integer> mImageIds) {
        this.mImageIds = mImageIds;
    }

    public void setListIndex(int mListIndex) {
        this.mListIndex = mListIndex;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        if (savedInstanceState!=null){
            mImageIds =savedInstanceState.getIntegerArrayList(IMAGE_ID_LIST);
            mListIndex =savedInstanceState.getInt(LIST_INDEX);
        }

        binding = FragmentBodyPartBinding.inflate(inflater,container,false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (mImageIds != null){
            binding.imageMy.setImageResource(mImageIds.get(mListIndex));
        }else {
            Toast.makeText(requireContext(), "imageView is null", Toast.LENGTH_SHORT).show();
        }

        binding.imageMy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mListIndex<mImageIds.size()-1){
                    mListIndex++;
                }else {
                   mListIndex =0;
                }
                binding.imageMy.setImageResource(mImageIds.get(mListIndex));
            }
        });
    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putIntegerArrayList(IMAGE_ID_LIST, (ArrayList<Integer>) mImageIds);
        outState.putInt(LIST_INDEX,mListIndex);

    }
}