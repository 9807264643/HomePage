package com.example.jobopportunity.tabFragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jobopportunity.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CricketFragment extends Fragment {


    public CricketFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cricket, container, false);
    }

}
