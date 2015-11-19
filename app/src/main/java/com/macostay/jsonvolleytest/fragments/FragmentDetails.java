package com.macostay.jsonvolleytest.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.macostay.jsonvolleytest.R;
import com.macostay.jsonvolleytest.models.Person;
import com.macostay.jsonvolleytest.models.Teams;

/**
 * Created by macostay on 15/10/2015.
 */
public class FragmentDetails extends Fragment{

    //Person person;
    Teams teams;
    //TextView tvDetailsIndex, tvDetailsName, tvDetailsAge, tvDetailsAddress, tvDetailsPhone, tvDetailsEmail;
    TextView tvDetails;
    public static FragmentDetails newInstance(Teams t) {

        Bundle args = new Bundle();
        args.putParcelable("teams", t);
        FragmentDetails fragment = new FragmentDetails();
        fragment.setArguments(args);
        return fragment;
    }
//    public static FragmentDetails newInstance(Person p) {
//
//        Bundle args = new Bundle();
//        args.putParcelable("person", p);
//        FragmentDetails fragment = new FragmentDetails();
//        fragment.setArguments(args);
//        return fragment;
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_details, container, false);

//        person = getArguments().getParcelable("person");
        teams = getArguments().getParcelable("teams");

        if(rootView != null) {
            tvDetails = (TextView)rootView.findViewById(R.id.tvDetails);

        }
        return rootView;

    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvDetails.setText("Name: "+ teams.getName()+"\n"+
                "Grupo: "+ teams.getGroupCode()+"\n"+
                "Image: "+ teams.getImage());


//        tvDetails.setText("Name: "+ person.getName()+"\n"+
//                "Age: "+ person.getAge()+"\n"+
//                "Phone: "+ person.getPhone()+"\n"+
//                "Address: "+ person.getAddress()+"\n"+
//                "Email: "+ person.getEmail());



    }
}
