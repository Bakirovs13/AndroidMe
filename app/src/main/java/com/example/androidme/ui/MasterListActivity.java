package com.example.androidme.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.example.androidme.R;
import com.example.androidme.data.AndroidImageAssets;
import com.example.androidme.databinding.ActivityMasterListBinding;

public class MasterListActivity extends AppCompatActivity implements onImageClickListener {

    ActivityMasterListBinding binding;
    private int headIndex;
    private int bodyIndex;
    private int legIndex;

    private Boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMasterListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if(binding.androidMeLinearLayout!= null){
            mTwoPane = true;

//            GridView gridView = (GridView) findViewById(R.id.images_grid_view);
//            gridView.setNumColumns(2);
//            Button nextButton = (Button) findViewById(R.id.nextBtn);
//            nextButton.setVisibility(View.GONE);


            if(savedInstanceState ==null) {

                BodyPartFragment headFragment = new BodyPartFragment();
                headFragment.setImageIds(AndroidImageAssets.getHeads());
                headFragment.setListIndex(headIndex);

                FragmentManager manager = getSupportFragmentManager();
                manager.beginTransaction().add(R.id.head_container, headFragment)
                        .commit();


                BodyPartFragment bodyFragment = new BodyPartFragment();
                bodyFragment.setImageIds(AndroidImageAssets.getBodies());
                manager.beginTransaction().add(R.id.body_container, bodyFragment).commit();


                BodyPartFragment legFragment = new BodyPartFragment();
                legFragment.setImageIds(AndroidImageAssets.getLegs());
                manager.beginTransaction().add(R.id.leg_container, legFragment).commit();

            }

        }else {
            mTwoPane = false;
        }

        MasterListFragment masterListFragment = new MasterListFragment();

        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().add(R.id.master_list_fragment, masterListFragment)
                .commit();

    }


    @Override
    public void onImageSelected(int position) {
        Toast.makeText(this, "Position clicked: "+position, Toast.LENGTH_SHORT).show();

        int bodyPartNumber = position/3;

        int listIndex =position-3*bodyPartNumber;

        if(mTwoPane){


            BodyPartFragment newFragment = new BodyPartFragment();

            // Set the currently displayed item for the correct body part fragment
            switch (bodyPartNumber) {
                case 0:
                    // A head image has been clicked
                    // Give the correct image resources to the new fragment
                    newFragment.setImageIds(AndroidImageAssets.getHeads());
                    newFragment.setListIndex(listIndex);
                    // Replace the old head fragment with a new one
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.head_container, newFragment)
                            .commit();
                    break;
                case 1:
                    newFragment.setImageIds(AndroidImageAssets.getBodies());
                    newFragment.setListIndex(listIndex);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.body_container, newFragment)
                            .commit();
                    break;
                case 2:
                    newFragment.setImageIds(AndroidImageAssets.getLegs());
                    newFragment.setListIndex(listIndex);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.leg_container, newFragment)
                            .commit();
                    break;
                default:
                    break;
            }

        }else{

        switch (bodyPartNumber){
            case 0: headIndex = listIndex;
            break;
            case 1: bodyIndex = listIndex;
            break;
            case 2: legIndex = listIndex;
            break;
            default:break;
        }

        Bundle bundle = new Bundle();
        bundle.putInt("headIndex",headIndex);
        bundle.putInt("bodyIndex",bodyIndex);
        bundle.putInt("legIndex",legIndex);

        final Intent intent = new Intent(this,MainActivity.class);
        intent.putExtras(bundle);


        Button nextBtn = findViewById(R.id.nextBtn);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }

        });

        }
    }
}