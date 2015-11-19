package com.macostay.jsonvolleytest.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.macostay.jsonvolleytest.R;

/**
 * Created by macostay on 15/10/2015.
 */
public class FragmentLoading extends Fragment {

    ProgressBar progressBar;


    public static FragmentLoading newInstance() {

        Bundle args = new Bundle();
        FragmentLoading fragment = new FragmentLoading();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_loading, container, false);
        if(rootView != null) {
            progressBar = (ProgressBar) rootView.findViewById(R.id.progressBar);
        }
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onPause() {
        super.onPause();

    }

    @Override
    public void onStop() {
        super.onStop();
    }
}
