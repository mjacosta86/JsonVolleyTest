package com.macostay.jsonvolleytest.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.macostay.jsonvolleytest.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by macostay on 15/10/2015.
 */
public class FragmentLoading extends Fragment {

    private static final String TAG = "FragmentLoading";

    //Controles
    @Bind(R.id.progressBar)
    ProgressBar progressBar;

    public static FragmentLoading newInstance() {

        Log.i(TAG, "Method newInstance");
        Bundle args = new Bundle();
        FragmentLoading fragment = new FragmentLoading();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_loading, container, false);
        ButterKnife.bind(this, rootView);
        Log.i(TAG, "Method onCreateView");
//        if(rootView != null) {
//            progressBar = (ProgressBar) rootView.findViewById(R.id.progressBar);
//        }
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i(TAG, "Method onViewCreated");
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
