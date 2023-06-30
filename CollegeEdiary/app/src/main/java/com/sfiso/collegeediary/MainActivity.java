package com.sfiso.collegeediary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private SectionsPageAdapter mSectionPageAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSectionPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
        mViewPager = findViewById(R.id.view_pager);

        setupViewPager(mViewPager);

        TabLayout tabLayout = findViewById(R.id.AppTabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

    private void setupViewPager(ViewPager viewPager)
    {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());

        adapter.addFragment(new createtab_Fragment(), "CREATE");
        adapter.addFragment(new readtab_Fragment() ,"READ");
        adapter.addFragment(new updatetab_Fragment() ,"UPDATE");
        viewPager.setAdapter(adapter);
    }
}