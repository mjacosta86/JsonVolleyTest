package com.macostay.jsonvolleytest.fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.macostay.jsonvolleytest.R;
import com.macostay.jsonvolleytest.adapters.AdapterSectionsPager;
import com.macostay.jsonvolleytest.models.TeamList;

/**
 * Created by macostay on 15/10/2015.
 */
public class FragmentViewPager extends Fragment{

    TeamList list;
    ViewPager vpPager;
    TabLayout tabLayout;
    private AdapterSectionsPager mSectionsPagerAdapter;


    public static FragmentViewPager newInstance(TeamList list) {

        Bundle args = new Bundle();
        args.putParcelable("list", list);
        FragmentViewPager fragment = new FragmentViewPager();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_viewpager, container, false);

        list = getArguments().getParcelable("list");

        mSectionsPagerAdapter = new AdapterSectionsPager(getActivity().getSupportFragmentManager(), list);

        if(rootView != null) {
            // Instantiate a ViewPager
            vpPager = (ViewPager) rootView.findViewById(R.id.vpPager);
            tabLayout = (TabLayout)rootView.findViewById(R.id.tlTabs);
        }

        return rootView;

    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        vpPager.setAdapter(mSectionsPagerAdapter);
        tabLayout.setupWithViewPager(vpPager);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

    }
}
