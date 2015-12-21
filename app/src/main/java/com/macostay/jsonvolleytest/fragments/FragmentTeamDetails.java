package com.macostay.jsonvolleytest.fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
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
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.macostay.jsonvolleytest.JsonVolleyTestSingleton;
import com.macostay.jsonvolleytest.R;
import com.macostay.jsonvolleytest.adapters.AdapterRecyclerTeamDetails;
import com.macostay.jsonvolleytest.adapters.AdapterRecyclerTeamLeagues;
import com.macostay.jsonvolleytest.models.LeagueTeam;
import com.macostay.jsonvolleytest.models.LeagueTeamList;
import com.macostay.jsonvolleytest.models.PlayerDetails;
import com.macostay.jsonvolleytest.models.PlayerTeam;
import com.macostay.jsonvolleytest.models.PlayerTeamList;
import com.macostay.jsonvolleytest.models.StadisticsPlayer;
import com.macostay.jsonvolleytest.models.StadisticsResume;
import com.macostay.jsonvolleytest.models.TeamDetails;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by macostay on 15/10/2015.
 */
public class FragmentTeamDetails extends Fragment {

    //ProgressDialog progress_dialog;
    private static final String TAG = "FragmentTeamDetails";
    TeamDetails teamDetails = new TeamDetails();
    private RequestQueue requestQueue;
    JsonObjectRequest jsonObjectRequest;
    JsonArrayRequest jsArrayRequest;
    ProgressDialog progress_dialog;
    private static final String URL2 = "http://www.resultados-futbol.com/scripts/api/api.php?tz=Europe/Madrid&format=json&req=categories&key=65f8402127f4aae612732b4cb6089c22&country=es&filter=all";

    //Controles
    @Bind(R.id.rvEquipoDetalle)
    RecyclerView rvEquipoDetalle;
    @Bind(R.id.ivImagenEscudo)
    ImageView ivImagenEscudo;
    @Bind(R.id.ivImagenEstadio)
    ImageView ivImagenEstadio;
    @Bind(R.id.tvBaseName)
    TextView tvBaseName;
    @Bind(R.id.tvCiudad)
    TextView tvCiudad;
    @Bind(R.id.tvDireccionEstadio)
    TextView tvDireccionEstadio;
    @Bind(R.id.tvAñoFundacion)
    TextView tvAñoFundacion;
    @Bind(R.id.tvSocios)
    TextView tvSocios;
    @Bind(R.id.tvPresupuesto)
    TextView tvPresupuesto;
    @Bind(R.id.tvPresidente)
    TextView tvPresidente;
    @Bind(R.id.tvEntrenador)
    TextView tvEntrenador;
    @Bind(R.id.tvEstadio)
    TextView tvEstadio;
    @Bind(R.id.tvLugarEntrenamiento)
    TextView tvLugarEntrenamiento;
    @Bind(R.id.tvAforoEstadio)
    TextView tvAforoEstadio;
    @Bind(R.id.tvAñoConstruccion)
    TextView tvAñoConstruccion;
    @Bind(R.id.tvDimensionesEstadio)
    TextView tvDimensionesEstadio;
    @Bind(R.id.tvPatrocinador)
    TextView tvPatrocinador;
    @Bind(R.id.tvHistorical)
    TextView tvHistorical;



    public static FragmentTeamDetails newInstance(TeamDetails teamDetails) {

        Bundle args = new Bundle();
        args.putParcelable("teamDetails", teamDetails);
        FragmentTeamDetails fragment = new FragmentTeamDetails();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_team_details, container, false);
        ButterKnife.bind(this, rootView);
        teamDetails = getArguments().getParcelable("teamDetails");

//        if(rootView != null) {
//            rvList = (RecyclerView) rootView.findViewById(R.id.rvList);
//        }
        return rootView;

    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle(teamDetails.getNameShow());
        //Cargamos las imagenes
        Picasso.with(ivImagenEscudo.getContext()).load(teamDetails.getShield()).error(R.mipmap.ic_launcher).into(ivImagenEscudo);
        Picasso.with(ivImagenEstadio.getContext()).load(teamDetails.getImg_stadium()).error(R.mipmap.ic_launcher).into(ivImagenEstadio);
        //Cargamos los detalles
        tvBaseName.setText(teamDetails.getBasename());
        tvCiudad.setText("Ciudad: "+teamDetails.getCity());
        tvDireccionEstadio.setText("Dirección: "+teamDetails.getAddress());
        tvAñoFundacion.setText("Año de Fundación: "+teamDetails.getYearFoundation());
        tvSocios.setText("Socios: "+teamDetails.getFans());
        tvPresupuesto.setText("Presupuesto: "+teamDetails.getYearlyBudget());
        tvPresidente.setText("Presidente: "+teamDetails.getChairman());
        tvEntrenador.setText("Entrenador: "+teamDetails.getManagerNow());
        tvEstadio.setText("Estadio: "+teamDetails.getStadium());
        tvLugarEntrenamiento.setText("Lugar de Entrenamiento: "+teamDetails.getLugar_entrenamiento());
        tvAforoEstadio.setText("Aforo: "+teamDetails.getSeats());
        tvAñoConstruccion.setText("Año construcción: "+teamDetails.getYearBuilt());
        tvDimensionesEstadio.setText("Dimensiones Estadio: "+teamDetails.getSize());
        tvPatrocinador.setText("Patrocinador: "+teamDetails.getPatrocinador());
        tvHistorical.setText("Palmarés: "+teamDetails.getHistorical());

        final ArrayList<PlayerTeam> items = teamDetails.getSquad().getList();

        AdapterRecyclerTeamDetails adapterRecyclerContracts = new AdapterRecyclerTeamDetails(items);

        rvEquipoDetalle.setAdapter(adapterRecyclerContracts);

        rvEquipoDetalle.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        rvEquipoDetalle.setItemAnimator(new DefaultItemAnimator());


        adapterRecyclerContracts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Pulsado el elemento " + rvEquipoDetalle.getChildAdapterPosition(v));
//                Toast.makeText(getActivity(), "Pulsado el elemento " + rvEquipoDetalle.getChildAdapterPosition(v), Toast.LENGTH_LONG).show();
                String url = "http://www.resultados-futbol.com/scripts/api/api.php?tz=Europe/Madrid&format=json&req=player&key=65f8402127f4aae612732b4cb6089c22&id="+items.get(rvEquipoDetalle.getChildAdapterPosition(v)).getId();
                String url2 = "http://www.json-generator.com/api/json/get/ckEMqcXNea?indent=2";
                //http://www.resultados-futbol.com/scripts/api/api.php?tz=Europe/Madrid&format=json&req=teams&key=65f8402127f4aae612732b4cb6089c22&league=1&year=2015
                //getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.flmainContainer, FragmentDetails.newInstance(items.get(rvList.getChildAdapterPosition(v)))).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE).addToBackStack("DetailsFragment").commit();
                requestQueue = Volley.newRequestQueue(getActivity());

                Log.i(TAG,url);
                // Nueva petición JSONObject

                jsonObjectRequest = new JsonObjectRequest(
                        Request.Method.GET,
                        url,
                        null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {

                                Log.i(TAG, "Entro en el onResponse");
                                //ligas = new CategoryLigas();

                                getActivity().getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.flmainContainer, FragmentPlayerDetails.newInstance(parseJson(response)))
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

                JsonVolleyTestSingleton.getInstance(getActivity()).addToRequestQueue(jsonObjectRequest);//Añadimos la petición a la cola
            }
        });

    }
    public PlayerDetails parseJson(JSONObject jsonObject){
        // Variables locales
        Log.i(TAG, "Entro en el ParseJson2");
        PlayerDetails player = new PlayerDetails();

        Log.i("Dato", jsonObject.toString());
        String json = jsonObject.toString();
        Gson gson = new Gson();
        player = gson.fromJson(json, PlayerDetails.class);

        StadisticsResume stadisticsResume = new StadisticsResume();
        try{
            JSONArray jsonArray = jsonObject.getJSONArray("statistics_resume");
            ArrayList<StadisticsPlayer> list = new ArrayList<StadisticsPlayer>();
            for(int i = 0; i < jsonArray.length(); ++i){

                JSONObject item = jsonArray.getJSONObject(i);

                StadisticsPlayer stadisticsPlayer = new StadisticsPlayer();
                String json2 = item.toString();
                Gson gson2 = new Gson();
                stadisticsPlayer = gson2.fromJson(json2, StadisticsPlayer.class);
                list.add(stadisticsPlayer);

            }
            stadisticsResume.setStadistics_resume(list);

        }catch(JSONException e){
            e.printStackTrace();
        }

        player.setStadisticsResume(stadisticsResume);

        return player;
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
