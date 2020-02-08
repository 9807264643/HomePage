package com.example.jobopportunity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.example.jobopportunity.bookmarksActivity.BooksmarksActivities;
import com.example.jobopportunity.fragment.FavouritesFragment;
import com.example.jobopportunity.fragment.Homefragment;
import com.example.jobopportunity.fragment.MatchesFragment;
import com.example.jobopportunity.fragment.VideosFragment;
import com.example.jobopportunity.tabFragments.adapter.PagerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener,
        BottomNavigationView.OnNavigationItemSelectedListener {


    public DrawerLayout drawer;
    LinearLayout fav_lin, bookmark_lin, feedback_lin, rate_lin, setting_lin, policies_lin;
    TextView txt_navHeader;
    BottomNavigationView bottomNavigationView;

    ViewPager viewPager;
    TabLayout tabLayout;
    FrameLayout frameLayout;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer);
        init();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        toolbar.setLogo(R.drawable.logo);
        setTitle("Home");
//        toolbar.setTitleTextColor(0x333333);
        NavigationView navigationView = findViewById(R.id.nav_view);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

//        setFragments(new Homefragment());
        clickDrawer();

        bottomNavigationView.setOnNavigationItemSelectedListener(this);


        tabLayout = findViewById(R.id.tablayout);
        tabLayout.addTab(tabLayout.newTab().setText("All"));
        tabLayout.addTab(tabLayout.newTab().setText("IPL"));
        tabLayout.addTab(tabLayout.newTab().setText("Cricket"));
        tabLayout.addTab(tabLayout.newTab().setText("Football"));
        tabLayout.addTab(tabLayout.newTab().setText("WWE"));
        tabLayout.addTab(tabLayout.newTab().setText("Khabadi"));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        viewPager = findViewById(R.id.view_pager);
        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        ;
    }


    private void init()
    {
        fav_lin = findViewById(R.id.lin_favourites);
        bookmark_lin = findViewById(R.id.lin_bookmark);
        feedback_lin = findViewById(R.id.lin_feedback);
        rate_lin = findViewById(R.id.lin_rateApp);
        setting_lin = findViewById(R.id.lin_setting);
        policies_lin = findViewById(R.id.lin_policy);

        txt_navHeader = findViewById(R.id.txt_header);
        drawer = findViewById(R.id.drawer_layout);
        bottomNavigationView = findViewById(R.id.bottom_nav);
        frameLayout = findViewById(R.id.main_fragment);

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
         id = menuItem.getItemId();
        switch (id) {
            case R.id.navigation_home:
                setFragments(new Homefragment());
                frameLayout.setVisibility(View.GONE);
                viewPager.setVisibility(View.VISIBLE);
                tabLayout.setVisibility(View.VISIBLE);
                final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
                viewPager.setAdapter(adapter);
                break;

            case R.id.navigation_fav:
                setFragments(new FavouritesFragment());
                viewPager.setVisibility(View.GONE);
                tabLayout.setVisibility(View.GONE);
                frameLayout.setVisibility(View.VISIBLE);
                break;

            case R.id.navigation_video:
                setFragments(new VideosFragment());
                viewPager.setVisibility(View.GONE);
                tabLayout.setVisibility(View.GONE);
                frameLayout.setVisibility(View.VISIBLE);
                break;

            case R.id.navigation_match:
                setFragments(new MatchesFragment());
                viewPager.setVisibility(View.GONE);
                tabLayout.setVisibility(View.GONE);
                frameLayout.setVisibility(View.VISIBLE);
                break;


        }

        return true;
    }

    public void closeDrawer() {

        drawer.closeDrawer(GravityCompat.START);

    }

    public void setFragments(Fragment fragments) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_fragment, fragments);
        fragmentTransaction.commit();
    }

    private void clickDrawer(){

        fav_lin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setFragments(new FavouritesFragment());
                frameLayout.setVisibility(View.VISIBLE);
                closeDrawer();

            }
        });

        bookmark_lin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this, BooksmarksActivities.class);
                startActivity(intent);
            }
        });

    }


}
