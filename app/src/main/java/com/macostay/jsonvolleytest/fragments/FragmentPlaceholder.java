package com.macostay.jsonvolleytest.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.macostay.jsonvolleytest.R;
import com.macostay.jsonvolleytest.models.Teams;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by macostay on 22/10/2015.
 */
public class FragmentPlaceholder extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    private static final String ARG_PERSON = "person";
    private static final String TAG = "FragmentPlaceHolder";
    Teams teams;

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    //Controles
    @Bind(R.id.sectionLabel)
    TextView sectionLabel;
    @Bind(R.id.ivEscudo)
    ImageView ivEscudo;


    public static FragmentPlaceholder newInstance(Teams teams) {
        Log.i(TAG, "Method newInstance");
        FragmentPlaceholder fragment = new FragmentPlaceholder();
        Bundle args = new Bundle();
        args.putParcelable(ARG_PERSON, teams);
        fragment.setArguments(args);
        return fragment;
    }

    public FragmentPlaceholder() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "Method onCreate");
        this.teams = getArguments().getParcelable(ARG_PERSON);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        Log.i(TAG, "Method onCreateView");
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, rootView);

        sectionLabel.setText("Name: "+ teams.getName()+"\n"+
                        "GroupCode: "+ teams.getGroupCode()+"\n"+
                        "Image: "+ teams.getImage());

        String bigImage = teams.getImage();

        if(teams.getImage().contains("small")){
            bigImage = teams.getImage().replace("small","big");
            Log.i("Big Image", bigImage);
        }

//        Picasso.with(inflater.getContext()).load(bigImage).error(R.mipmap.ic_launcher).fit().transform(new RoundedTransformation()).into(ivEscudo);
        Picasso.with(inflater.getContext()).load(bigImage).error(R.mipmap.ic_launcher).into(ivEscudo);
        return rootView;
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
