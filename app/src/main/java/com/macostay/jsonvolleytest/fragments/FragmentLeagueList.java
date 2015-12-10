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
import com.macostay.jsonvolleytest.adapters.AdapterRecyclerTeams;
import com.macostay.jsonvolleytest.models.Category;
import com.macostay.jsonvolleytest.models.CategoryLiga;
import com.macostay.jsonvolleytest.models.CategoryLigas;
import com.macostay.jsonvolleytest.models.LeagueTeam;
import com.macostay.jsonvolleytest.models.LeagueTeamList;
import com.macostay.jsonvolleytest.models.TeamList;
import com.macostay.jsonvolleytest.models.Teams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by macostay on 15/10/2015.
 */
public class FragmentLeagueList extends Fragment {


    private static final String TAG = "FragmentLeagueList";
    CategoryLigas ligas;
    ArrayList<LeagueTeam> arrayListTeams = new ArrayList<>();
    LeagueTeamList list = new LeagueTeamList();
    private RequestQueue requestQueue;
    JsonObjectRequest jsArrayRequest;
    private static final String URL2 = "http://www.resultados-futbol.com/scripts/api/api.php?tz=Europe/Madrid&format=json&req=categories&key=65f8402127f4aae612732b4cb6089c22&country=es&filter=all";

    //Controles
    @Bind(R.id.rvLigas)
    RecyclerView rvLigas;


    public static FragmentLeagueList newInstance(CategoryLigas ligas) {

        Bundle args = new Bundle();
        args.putParcelable("ligas", ligas);
        FragmentLeagueList fragment = new FragmentLeagueList();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_leagues, container, false);
        ButterKnife.bind(this, rootView);
        ligas = getArguments().getParcelable("ligas");

//        if(rootView != null) {
//            rvList = (RecyclerView) rootView.findViewById(R.id.rvList);
//        }
        return rootView;

    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("Ligas");

        final ArrayList<CategoryLiga> items = ligas.getLigas();

        AdapterRecyclerLeagues adapterRecyclerContracts = new AdapterRecyclerLeagues(items);

        rvLigas.setAdapter(adapterRecyclerContracts);

        rvLigas.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        rvLigas.setItemAnimator(new DefaultItemAnimator());


        adapterRecyclerContracts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String url = "http://www.resultados-futbol.com/scripts/api/api.php?tz=Europe/Madrid&format=json&req=teams&key=65f8402127f4aae612732b4cb6089c22&league="+ligas.getLigas().get(rvLigas.getChildAdapterPosition(v)).getId()+"&year=2016";
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
                                arrayListTeams = parseJson(response);
                                list.setTeam(arrayListTeams);
                                getActivity().getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.flmainContainer, FragmentLeague.newInstance(list))
                                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)
                                        .addToBackStack("FragmentLeagueList")
                                        .commit();
                                //ligas = new CategoryLigas();
                                /*ligas = parseJson(response);
                                getActivity().getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.flmainContainer, FragmentLeagueList.newInstance(ligas))
                                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)
                                        .addToBackStack("FragmentLeagueList")
                                        .commit();*/

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
    public ArrayList<LeagueTeam> parseJson(JSONObject jsonObject){
        // Variables locales
        Log.i(TAG, "Entro en el ParseJson2");
        ArrayList<LeagueTeam> ligaList = new ArrayList<>();
        try {
            // Obtener el array del objeto
            Log.i("Dato", jsonObject.getJSONArray("team").get(0).toString());
            String json = jsonObject.toString();
            Gson gson = new Gson();
            LeagueTeamList list = gson.fromJson(json, LeagueTeamList.class);

            JSONArray ligas = jsonObject.getJSONArray("team");

            for (int i = 0; i < ligas.length(); ++i)
            {
                JSONObject item = ligas.getJSONObject(i);//JSONObject arrayElement_0 = jsonArray.getJSONObject(0);

                LeagueTeam l = new LeagueTeam();
                l.setFullName(item.getString("fullName").toString().trim());
                l.setShield(item.getString("shield").toString().trim());
                l.setId(item.getString("id").toString().trim());
                Log.i("Name", l.getFullName());
                Log.i("Escudo", l.getShield());
                Log.i("ID", l.getId());

                //---print out the content of the json feed---
                ligaList.add(l);

            }



        } catch (JSONException e) {
            e.printStackTrace();
        }


        return ligaList;
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
