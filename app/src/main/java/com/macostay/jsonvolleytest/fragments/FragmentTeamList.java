package com.macostay.jsonvolleytest.fragments;

import android.content.Context;
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
import android.widget.Toast;
import com.macostay.jsonvolleytest.R;
import com.macostay.jsonvolleytest.adapters.AdapterRecyclerTeams;
import com.macostay.jsonvolleytest.models.TeamList;
import com.macostay.jsonvolleytest.models.Teams;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by macostay on 15/10/2015.
 */
public class FragmentTeamList extends Fragment {


    private static final String TAG = "FragmentTeamList";
    TeamList list;

    //Controles
    @Bind(R.id.rvList)
    RecyclerView rvList;


    public static FragmentTeamList newInstance(TeamList list) {

        Bundle args = new Bundle();
        args.putParcelable("list", list);
        FragmentTeamList fragment = new FragmentTeamList();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_team, container, false);
        ButterKnife.bind(this, rootView);
        list = getArguments().getParcelable("list");

//        if(rootView != null) {
//            rvList = (RecyclerView) rootView.findViewById(R.id.rvList);
//        }
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
