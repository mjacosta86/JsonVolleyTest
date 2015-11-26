package com.macostay.jsonvolleytest.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.macostay.jsonvolleytest.R;
import com.macostay.jsonvolleytest.models.Teams;

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
    Teams teams;

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */

    public static FragmentPlaceholder newInstance(Teams teams) {
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

        this.teams = getArguments().getParcelable(ARG_PERSON);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.section_label);

        textView.setText("Name: "+ teams.getName()+"\n"+
                        "GroupCode: "+ teams.getGroupCode()+"\n"+
                        "Image: "+ teams.getImage());
        return rootView;
    }
}
