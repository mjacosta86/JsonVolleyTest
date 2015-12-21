package com.macostay.jsonvolleytest.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.macostay.jsonvolleytest.JsonVolleyTestSingleton;
import com.macostay.jsonvolleytest.R;
import com.macostay.jsonvolleytest.adapters.AdapterRecyclerTeamDetails;
import com.macostay.jsonvolleytest.models.PlayerDetails;
import com.macostay.jsonvolleytest.models.PlayerTeam;
import com.macostay.jsonvolleytest.models.PlayerTeamList;
import com.macostay.jsonvolleytest.models.TeamDetails;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by macostay on 15/10/2015.
 */
public class FragmentPlayerDetails extends Fragment {


    private static final String TAG = "FragmentPlayerDetails";
    PlayerDetails playerDetails = new PlayerDetails();


    //Controles
    @Bind(R.id.tvIdPlayer)
    TextView tvIdPlayer;

    @Bind(R.id.tvNamePlayer)
    TextView tvNamePlayer;

    @Bind(R.id.tvNickPlayer)
    TextView tvNickPlayer;

    @Bind(R.id.tvLastName)
    TextView tvLastName;

    @Bind(R.id.tvRole)
    TextView tvRole;

    @Bind(R.id.tvCountry)
    TextView tvCountry;

    @Bind(R.id.tvBirthDate)
    TextView tvBirthDate;

    @Bind(R.id.tvAgePlayer)
    TextView tvAgePlayer;

    @Bind(R.id.tvCountryCodePlayer)
    TextView tvCountryCodePlayer;

    @Bind(R.id.tvWeightPlayer)
    TextView tvWeightPlayer;

    @Bind(R.id.tvHeightPlayer)
    TextView tvHeightPlayer;

    @Bind(R.id.tvTwitterPlayer)
    TextView tvTwitterPlayer;

    @Bind(R.id.tvWebsitePlayer)
    TextView tvWebsitePlayer;

    @Bind(R.id.tvSquadPlayer)
    TextView tvSquadPlayer;

    @Bind(R.id.ivAvatarPlayer)
    ImageView ivAvatarPlayer;

    @Bind(R.id.ivAvatarCountryPlayer)
    ImageView ivAvatarCountryPlayer;

    @Bind(R.id.ivAvatarTeamPlayer)
    ImageView ivAvatarTeamPlayer;

    @Bind(R.id.tvInfoPlayer)
    TextView tvInfoPlayer;


    public static FragmentPlayerDetails newInstance(PlayerDetails playerDetails) {

        Bundle args = new Bundle();
        args.putParcelable("playerDetails", playerDetails);
        FragmentPlayerDetails fragment = new FragmentPlayerDetails();
        fragment.setArguments(args);
        return fragment;
    }

    public static FragmentPlayerDetails newInstance() {

        Bundle args = new Bundle();
        FragmentPlayerDetails fragment = new FragmentPlayerDetails();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_player_details, container, false);
        ButterKnife.bind(this, rootView);
        playerDetails = getArguments().getParcelable("playerDetails");

//        if(rootView != null) {
//            rvList = (RecyclerView) rootView.findViewById(R.id.rvList);
//        }
        return rootView;

    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle(playerDetails.getNick());

        //cargamos las imagenes
        Picasso.with(ivAvatarPlayer.getContext()).load(playerDetails.getPlayer_avatar()).error(R.mipmap.ic_launcher).into(ivAvatarPlayer);
        Picasso.with(ivAvatarCountryPlayer.getContext()).load(playerDetails.getCountry_flag()).error(R.mipmap.ic_launcher).into(ivAvatarCountryPlayer);
        Picasso.with(ivAvatarTeamPlayer.getContext()).load(playerDetails.getTeam_shield()).error(R.mipmap.ic_launcher).into(ivAvatarTeamPlayer);


        tvIdPlayer.setText("ID: " + playerDetails.getPlayer_id());
        tvNickPlayer.setText("Nick: "+playerDetails.getNick());
        tvCountry.setText("Pais: "+playerDetails.getCountry());
        tvNamePlayer.setText("Nombre: "+playerDetails.getName());
        tvLastName.setText("Apellido: "+playerDetails.getLast_name());
        tvBirthDate.setText("Fecha Nacimiento: "+playerDetails.getBirthdate());
        tvRole.setText("Rol: "+playerDetails.getRole());
        tvAgePlayer.setText("Edad: "+playerDetails.getAge());
        tvCountryCodePlayer.setText("Codigo Pais: "+playerDetails.getCountryCode());
        tvWeightPlayer.setText("Peso: "+playerDetails.getWeight());
        tvHeightPlayer.setText("Altura: "+playerDetails.getHeight());
        tvTwitterPlayer.setText("Twitter: "+playerDetails.getTwitter());
        tvSquadPlayer.setText("Numero: "+playerDetails.getSquad_number());
        tvWebsitePlayer.setText("Web: "+playerDetails.getWebsite());

        tvInfoPlayer.setText(playerDetails.getPlayer_id());

//        int goles = playerDetails.getStadisticsResume().getStadistics_resume().get(0).getGoals();
//        Log.i("Goles", goles+"");


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
