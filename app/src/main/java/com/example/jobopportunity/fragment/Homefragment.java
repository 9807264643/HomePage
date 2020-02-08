package com.example.jobopportunity.fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.jobopportunity.R;
import com.example.jobopportunity.detailPageActivity.DetailPageActivities;

/**
 * A simple {@link Fragment} subclass.
 */
public class Homefragment extends Fragment {
    LinearLayout linearLayout;



    public Homefragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view =  inflater.inflate(R.layout.activity_main, container, false);

        linearLayout = view.findViewById(R.id.linear);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), DetailPageActivities.class);
                startActivity(i);
            }
        });

        return view;
    }

}
