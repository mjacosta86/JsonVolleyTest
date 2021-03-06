package com.macostay.jsonvolleytest.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
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
public class FragmentPersonList extends Fragment {

    RecyclerView rvList;
    private static final String TAG = "PersonListFragment";
    TeamList list;
    //PersonList list;
    ImageView ivIconToolbar;
    TextView tvTitleToolbar;


    public static FragmentPersonList newInstance(PersonList list) {

        Bundle args = new Bundle();
        args.putParcelable("list", list);
        FragmentPersonList fragment = new FragmentPersonList();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_person, container, false);

        list = getArguments().getParcelable("list");

        if(rootView != null) {
            rvList = (RecyclerView) rootView.findViewById(R.id.rvList);
            ivIconToolbar = (ImageView) rootView.findViewById(R.id.ivIconToolbar);
            tvTitleToolbar = (TextView) rootView.findViewById(R.id.tvTitleToolbar);
        }
        return rootView;

    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("Lista de Personas");

        final ArrayList<Teams> items = list.getList();
        //final ArrayList<Person> items = list.getList();

//      Context c = getActivity().getApplicationContext();

        AdapterRecyclerTeams adapterRecyclerContracts = new AdapterRecyclerTeams(items);
//        AdapterRecyclerPerson adapterRecyclerContracts = new AdapterRecyclerPerson(items);
//      AdapterRecyclerPerson adapterRecyclerContracts = new AdapterRecyclerPerson(items, c);

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

        ivIconToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.flmainContainer, FragmentViewPager.newInstance(list)).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE).addToBackStack(null).commit();
            }
        });




    }
}
