package com.example.androidme.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;

import com.example.androidme.R;
import com.example.androidme.data.AndroidImageAssets;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState ==null) {
            BodyPartFragment headFragment = new BodyPartFragment();

            headFragment.setImageIds(AndroidImageAssets.getHeads());
            int headIndex = getIntent().getIntExtra("headIndex", 0);
            headFragment.setListIndex(headIndex);


            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().add(R.id.head_container, headFragment)
                    .commit();


            BodyPartFragment bodyFragment = new BodyPartFragment();
            bodyFragment.setImageIds(AndroidImageAssets.getBodies());
            int bodyIndex = getIntent().getIntExtra("bodyIndex",0);
            bodyFragment.setListIndex(bodyIndex);
            manager.beginTransaction().add(R.id.body_container, bodyFragment).commit();

            BodyPartFragment legFragment = new BodyPartFragment();
            legFragment.setImageIds(AndroidImageAssets.getLegs());
            int legIndex = getIntent().getIntExtra("legIndex",0);
            legFragment.setListIndex(legIndex);
            manager.beginTransaction().add(R.id.leg_container, legFragment).commit();

        }
    }


}