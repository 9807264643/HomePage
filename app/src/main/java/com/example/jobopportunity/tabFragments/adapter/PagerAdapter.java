package com.example.jobopportunity.tabFragments.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.jobopportunity.MainActivity;
import com.example.jobopportunity.fragment.FavouritesFragment;
import com.example.jobopportunity.fragment.Homefragment;
import com.example.jobopportunity.tabFragments.CricketFragment;
import com.example.jobopportunity.tabFragments.FootballFragment;
import com.example.jobopportunity.tabFragments.IplFragment;
import com.example.jobopportunity.tabFragments.WweFragment;

public class PagerAdapter extends FragmentStatePagerAdapter {
 int noOfTabs;

    public PagerAdapter(FragmentManager fm, int behavior) {
        super(fm);
        this.noOfTabs = behavior;
    }


    @Override
    public Fragment getItem(int position) {

        switch (position)
        {
            case 0:
                Homefragment homefragment = new Homefragment();
                return homefragment;

            case 1:
                IplFragment iplFragment = new IplFragment();
                return iplFragment;

            case 2:
                CricketFragment cricketFragment = new CricketFragment();

                return cricketFragment;

            case 3:
                FootballFragment footballFragment = new FootballFragment();
                return footballFragment;

            case 4:
                WweFragment wweFragment = new WweFragment();
                return wweFragment;

            case 5:
                FavouritesFragment favouritesFragment = new FavouritesFragment();
                return favouritesFragment;

                default:
                    return null;
        }

    }

    @Override
    public int getCount() {
        return noOfTabs;
    }
}
