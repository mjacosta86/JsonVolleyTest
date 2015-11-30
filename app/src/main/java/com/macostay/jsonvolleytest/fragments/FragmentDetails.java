package com.macostay.jsonvolleytest.fragments;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.macostay.jsonvolleytest.R;
import com.macostay.jsonvolleytest.models.Teams;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by macostay on 15/10/2015.
 */
public class FragmentDetails extends Fragment{

    Teams teams;
    private static final String TAG = "FragmentDetails";

    //Controles
    @Bind(R.id.tvDetails)
    TextView tvDetails;

    public static FragmentDetails newInstance(Teams t) {

        Log.i(TAG, "Method newInstance");
        Bundle args = new Bundle();
        args.putParcelable("teams", t);
        FragmentDetails fragment = new FragmentDetails();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Log.i(TAG, "Method onCreateView");
        View rootView = inflater.inflate(R.layout.fragment_details, container, false);
        ButterKnife.bind(this, rootView);
        teams = getArguments().getParcelable("teams");

//        if(rootView != null) {
//            tvDetails = (TextView)rootView.findViewById(R.id.tvDetails);
//        }

        return rootView;

    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        Log.i(TAG, "Method onViewCreated");

        tvDetails.setText("Name: " + teams.getName() + "\n" +
                "Grupo: " + teams.getGroupCode() + "\n" +
                "Image: " + teams.getImage()
                + "\n" + "Player: " + teams.getPlayers().getList().get(0).getInfo());


    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i(TAG, "Method onAttach");


    }
//    @Override
//    public void onAttach(Activity activity) {
//        super.onAttach(activity);
//        Log.i(TAG, "Method onAttach");
//
//        // This makes sure that the container activity has implemented
//        // the callback interface. If not, it throws an exception
//        try {
//            mCallback = (OnHeadlineSelectedListener) activity;
//        } catch (ClassCastException e) {
//            throw new ClassCastException(activity.toString()
//                    + " must implement OnHeadlineSelectedListener");
//        }
//    }
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
