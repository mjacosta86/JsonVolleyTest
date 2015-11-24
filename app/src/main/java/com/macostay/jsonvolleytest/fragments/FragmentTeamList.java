package com.macostay.jsonvolleytest.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.macostay.jsonvolleytest.R;
import com.macostay.jsonvolleytest.adapters.AdapterRecyclerPerson;
import com.macostay.jsonvolleytest.adapters.AdapterRecyclerTeams;
import com.macostay.jsonvolleytest.models.Person;
import com.macostay.jsonvolleytest.models.PersonList;
import com.macostay.jsonvolleytest.models.TeamList;
import com.macostay.jsonvolleytest.models.Teams;

import java.util.ArrayList;

/**
 * Created by macostay on 15/10/2015.
 */
public class FragmentTeamList extends Fragment {

    RecyclerView rvList;
    private static final String TAG = "PersonListFragment";
    TeamList list;


    public static FragmentTeamList newInstance(TeamList list) {

        Bundle args = new Bundle();
        args.putParcelable("list", list);
        FragmentTeamList fragment = new FragmentTeamList();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_person, container, false);

        list = getArguments().getParcelable("list");

        if(rootView != null) {
            rvList = (RecyclerView) rootView.findViewById(R.id.rvList);
        }
        return rootView;

    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("Lista de Equipos");

        final ArrayList<Teams> items = list.getList();

        AdapterRecyclerTeams adapterRecyclerContracts = new AdapterRecyclerTeams(items);

        rvList.setAdapter(adapterRecyclerContracts);

        rvList.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        rvList.setItemAnimator(new DefaultItemAnimator());


        adapterRecyclerContracts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Pulsado el elemento " + rvList.getChildAdapterPosition(v));
                Toast.makeText(getActivity(), "Pulsado el elemento " + rvList.getChildAdapterPosition(v), Toast.LENGTH_LONG).show();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.flmainContainer, FragmentDetails.newInstance(items.get(rvList.getChildAdapterPosition(v)))).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE).addToBackStack("DetailsFragment").commit();
            }
        });

    }
}
