package com.macostay.jsonvolleytest.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.macostay.jsonvolleytest.R;
import com.macostay.jsonvolleytest.adapters.AdapterSectionsPager;
import com.macostay.jsonvolleytest.models.TeamList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by macostay on 15/10/2015.
 */
public class FragmentViewPager extends Fragment{

    TeamList list;
    private AdapterSectionsPager mSectionsPagerAdapter;
    private static final String TAG = "FragmentViewPager";

    //Controles
    @Bind(R.id.vpPager)
    ViewPager vpPager;
    @Bind(R.id.tlTabs)
    TabLayout tlTabs;


    public static FragmentViewPager newInstance(TeamList list) {
        Log.i(TAG, "Method newInstance");
        Bundle args = new Bundle();
        args.putParcelable("list", list);
        FragmentViewPager fragment = new FragmentViewPager();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_viewpager, container, false);
        ButterKnife.bind(this, rootView);
        Log.i(TAG, "Method onCreateView");
        list = getArguments().getParcelable("list");

        mSectionsPagerAdapter = new AdapterSectionsPager(getActivity().getSupportFragmentManager(), list);

//        if(rootView != null) {
//            // Instantiate a ViewPager
//            vpPager = (ViewPager) rootView.findViewById(R.id.vpPager);
//            tlTabs = (TabLayout)rootView.findViewById(R.id.tlTabs);
//        }

        return rootView;

    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i(TAG, "Method onViewCreated");
        vpPager.setAdapter(mSectionsPagerAdapter);
        tlTabs.setupWithViewPager(vpPager);
        tlTabs.setTabMode(TabLayout.MODE_SCROLLABLE);

    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i(TAG, "Method onAttach");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, "Method onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "Method onResume");
    }

    @Override
    public void onPause() {
        Log.i(TAG, "Method onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.i(TAG, "Method onStop");
        super.onStop();
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "Method onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDestroyView() {
        Log.i(TAG, "Method onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDetach() {
        Log.i(TAG, "Method onDetach");
        super.onDetach();
    }
}
