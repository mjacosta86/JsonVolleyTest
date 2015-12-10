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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.macostay.jsonvolleytest.JsonVolleyTestSingleton;
import com.macostay.jsonvolleytest.R;
import com.macostay.jsonvolleytest.adapters.AdapterRecyclerLeagues;
import com.macostay.jsonvolleytest.adapters.AdapterRecyclerTeamLeagues;
import com.macostay.jsonvolleytest.models.Category;
import com.macostay.jsonvolleytest.models.CategoryLiga;
import com.macostay.jsonvolleytest.models.CategoryLigas;
import com.macostay.jsonvolleytest.models.LeagueTeam;
import com.macostay.jsonvolleytest.models.LeagueTeamList;
import com.macostay.jsonvolleytest.models.PlayerTeam;
import com.macostay.jsonvolleytest.models.PlayerTeamList;
import com.macostay.jsonvolleytest.models.TeamDetails;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by macostay on 15/10/2015.
 */
public class FragmentLeague extends Fragment {


    private static final String TAG = "FragmentLeague";
    LeagueTeamList list;
    String toolbar;
    private RequestQueue requestQueue;
    JsonObjectRequest jsArrayRequest;
    TeamDetails teamDetails = new TeamDetails();
    private static final String URL2 = "http://www.resultados-futbol.com/scripts/api/api.php?tz=Europe/Madrid&format=json&req=categories&key=65f8402127f4aae612732b4cb6089c22&country=es&filter=all";

    //Controles
    @Bind(R.id.rvLiga)
    RecyclerView rvLiga;


    public static FragmentLeague newInstance(LeagueTeamList list, String toolbar) {

        Bundle args = new Bundle();
        args.putParcelable("list", list);
        args.putString("toolbar", toolbar);
        FragmentLeague fragment = new FragmentLeague();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_league, container, false);
        ButterKnife.bind(this, rootView);
        list = getArguments().getParcelable("list");
        toolbar = getArguments().getString("toolbar");

//        if(rootView != null) {
//            rvList = (RecyclerView) rootView.findViewById(R.id.rvList);
//        }
        return rootView;

    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle(toolbar);

        final ArrayList<LeagueTeam> items = list.getTeam();

        AdapterRecyclerTeamLeagues adapterRecyclerContracts = new AdapterRecyclerTeamLeagues(items);

        rvLiga.setAdapter(adapterRecyclerContracts);

        rvLiga.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        rvLiga.setItemAnimator(new DefaultItemAnimator());


        adapterRecyclerContracts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Pulsado el elemento " + rvLiga.getChildAdapterPosition(v));
                Toast.makeText(getActivity(), "Pulsado el elemento " + rvLiga.getChildAdapterPosition(v), Toast.LENGTH_LONG).show();
                String url = "http://www.resultados-futbol.com/scripts/api/api.php?tz=Europe/Madrid&format=json&req=team&key=65f8402127f4aae612732b4cb6089c22&id="+items.get(rvLiga.getChildAdapterPosition(v)).getId();
                //http://www.resultados-futbol.com/scripts/api/api.php?tz=Europe/Madrid&format=json&req=teams&key=65f8402127f4aae612732b4cb6089c22&league=1&year=2015
                //getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.flmainContainer, FragmentDetails.newInstance(items.get(rvList.getChildAdapterPosition(v)))).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE).addToBackStack("DetailsFragment").commit();
                requestQueue = Volley.newRequestQueue(getActivity());

                Log.i(TAG,url);

                // Nueva petición JSONObject
                jsArrayRequest = new JsonObjectRequest(
                        Request.Method.GET,
                        url,
                        null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {

                                Log.i(TAG,"Entro en el onResponse");
                                //ligas = new CategoryLigas();
                                teamDetails = parseJson(response);
                                getActivity().getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.flmainContainer, FragmentTeamDetails.newInstance(teamDetails))
                                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)
                                        .addToBackStack("FragmentTeamDetails")
                                        .commit();

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Log.e(TAG, "Error Respuesta en JSON: " + error.getMessage());

                            }
                        }
                );

                JsonVolleyTestSingleton.getInstance(getActivity()).addToRequestQueue(jsArrayRequest);//Añadimos la petición a la cola
            }
        });

    }
    public TeamDetails parseJson(JSONObject jsonObject){
        // Variables locales
        Log.i(TAG, "Entro en el ParseJson2");
        TeamDetails teamDetails = new TeamDetails();
        PlayerTeamList list = new PlayerTeamList();
        ArrayList<PlayerTeam> arrayPlayer = new ArrayList<>();

        try {
            // Obtener el array del objeto
            //Log.i("Dato", jsonObject.getString("id"));
            Log.i("Dato", jsonObject.toString());
            String json = jsonObject.toString();
            Gson gson = new Gson();
            teamDetails = gson.fromJson(json, TeamDetails.class);

            JSONObject object = jsonObject.getJSONObject("team");
            teamDetails.setNameShow(object.getString("nameShow"));
            Log.i(TAG, "NameShow: " + teamDetails.getNameShow());
            JSONArray array = object.getJSONArray("squad");

            for (int i = 0; i < array.length(); ++i)
            {
                JSONObject item = array.getJSONObject(i);//JSONObject arrayElement_0 = jsonArray.getJSONObject(0);

                PlayerTeam l = new PlayerTeam();
                l.setId(item.getString("id").toString().trim());
                Log.i("Name", l.getId());
                l.setNick(item.getString("nick").toString().trim());
                Log.i("Nick", l.getNick());
                l.setImage(item.getString("image").toString().trim());
                Log.i("Image", l.getImage());

                //---print out the content of the json feed---
                arrayPlayer.add(l);

            }



        } catch (JSONException e) {
            e.printStackTrace();
        }

        list.setList(arrayPlayer);
        teamDetails.setSquad(list);

        return teamDetails;
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
