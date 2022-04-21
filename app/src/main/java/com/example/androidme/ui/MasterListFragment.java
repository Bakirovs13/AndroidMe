package com.example.androidme.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.androidme.R;
import com.example.androidme.data.AndroidImageAssets;
import com.example.androidme.databinding.FragmentMasterListBinding;


public class MasterListFragment extends Fragment {

    FragmentMasterListBinding binding;
    onImageClickListener mCallback;

    public MasterListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentMasterListBinding.inflate(inflater,container,false);
        MasterListAdapter adapter = new MasterListAdapter(getContext(), AndroidImageAssets.getAll());
        binding.imagesGridView.setAdapter(adapter);
        binding.imagesGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                mCallback.onImageSelected(pos);
            }
        });
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            mCallback = (onImageClickListener) context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString()
            +"must implement OnImageCLickListener");
        }
    }
}