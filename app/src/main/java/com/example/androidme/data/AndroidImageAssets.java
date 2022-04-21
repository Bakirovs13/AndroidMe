package com.example.androidme.data;

import com.example.androidme.R;

import java.util.ArrayList;
import java.util.List;

public class AndroidImageAssets {

    private static final List<Integer> heads =new ArrayList<Integer>(){{

    add(R.drawable.head1);
    add(R.drawable.head5);
    add(R.drawable.head12);
    }};


    private static final List<Integer> bodies =new ArrayList<Integer>(){{

    add(R.drawable.body1);
    add(R.drawable.body4);
    add(R.drawable.body10);
    }};

  private static final List<Integer> legs =new ArrayList<Integer>(){{

    add(R.drawable.legs1);
    add(R.drawable.legs6);
    add(R.drawable.legs10);
    }};


  private static final List<Integer>all =new ArrayList<Integer>(){{
      addAll(heads);
      addAll(bodies);
      addAll(legs);
  }};


    public static List<Integer> getHeads() {
        return heads;
    }

    public static List<Integer> getBodies() {
        return bodies;
    }

    public static List<Integer> getLegs() {
        return legs;
    }

    public static List<Integer> getAll() {
        return all;
    }
}
