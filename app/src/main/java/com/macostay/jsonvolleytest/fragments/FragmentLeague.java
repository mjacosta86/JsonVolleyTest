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
//                Toast.makeText(getActivity(), "Pulsado el elemento " + rvLiga.getChildAdapterPosition(v), Toast.LENGTH_LONG).show();
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
            JSONObject object = jsonObject.getJSONObject("team");
            Log.i("Dato2", object.toString());
//            String json = jsonObject.toString();
//            Gson gson = new Gson();
//            teamDetails = gson.fromJson(json, TeamDetails.class);
            teamDetails = RellenarDatosEquipo(object);
            //teamDetails.setNameShow(object.getString("nameShow"));
            Log.i(TAG, "NameShow: " + teamDetails.getNameShow());
            Log.i(TAG, "ID: " + teamDetails.getId());
            JSONArray array = object.getJSONArray("squad");

            for (int i = 0; i < array.length(); ++i)
            {
                JSONObject item = array.getJSONObject(i);//JSONObject arrayElement_0 = jsonArray.getJSONObject(0);

                PlayerTeam l = new PlayerTeam();
                String json2 = item.toString();
                Gson gson2 = new Gson();
                l = gson2.fromJson(json2, PlayerTeam.class);
                //l.setId(item.getString("id").toString().trim());
                Log.i("Name", l.getId());
                //l.setNick(item.getString("nick").toString().trim());
                Log.i("Nick", l.getNick());
                //l.setImage(item.getString("image").toString().trim());
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

    public TeamDetails RellenarDatosEquipo(JSONObject objeto){
        TeamDetails detallesEquipo = new TeamDetails();
        try{
            detallesEquipo.setId(objeto.getString("id"));
            detallesEquipo.setNameShow(objeto.getString("nameShow"));
            detallesEquipo.setBasealias(objeto.getString("basealias"));
            detallesEquipo.setCountryCode(objeto.getString("CountryCode"));
            detallesEquipo.setLocation(objeto.getString("location"));
            detallesEquipo.setBasename(objeto.getString("basename"));
            detallesEquipo.setStadium(objeto.getString("stadium"));
            detallesEquipo.setShort_name(objeto.getString("short_name"));
            detallesEquipo.setManagerNow(objeto.getString("managerNow"));
            detallesEquipo.setSeats(objeto.getString("seats"));
            detallesEquipo.setWebsite(objeto.getString("website"));
            detallesEquipo.setYearFoundation(objeto.getString("yearFoundation"));
            detallesEquipo.setCity(objeto.getString("city"));
            detallesEquipo.setAddress(objeto.getString("address"));
            detallesEquipo.setPhone(objeto.getString("phone"));
            detallesEquipo.setFax(objeto.getString("fax"));
            detallesEquipo.setChairman(objeto.getString("chairman"));
            detallesEquipo.setFullName(objeto.getString("fullName"));
            detallesEquipo.setYearlyBudget(objeto.getString("yearlyBudget"));
            detallesEquipo.setInfo(objeto.getString("info"));

            detallesEquipo.setFans(objeto.getString("fans"));
            detallesEquipo.setTypefield(objeto.getString("typefield"));
            detallesEquipo.setCtype(objeto.getString("ctype"));
            detallesEquipo.setYearlyBudget(objeto.getString("yearBuilt"));
            detallesEquipo.setSize(objeto.getString("size"));
            detallesEquipo.setHistorical(objeto.getString("historical"));
            detallesEquipo.setComments(objeto.getString("comments"));
            detallesEquipo.setColor1(objeto.getString("color1"));
            detallesEquipo.setColor2(objeto.getString("color2"));
            detallesEquipo.setKit_home(objeto.getString("kit_home"));
            detallesEquipo.setKit_away(objeto.getString("kit_away"));
            detallesEquipo.setKit_third(objeto.getString("kit_third"));
            detallesEquipo.setCity(objeto.getString("city"));
            detallesEquipo.setTwitter(objeto.getString("twitter"));
            detallesEquipo.setTwitter_coach(objeto.getString("twitter_coach"));
            detallesEquipo.setTwitter_president(objeto.getString("twitter_president"));
            detallesEquipo.setTwitter_b(objeto.getString("twitter_b"));
            detallesEquipo.setQod(objeto.getString("qod"));
            detallesEquipo.setPod(objeto.getString("pod"));
            detallesEquipo.setLast_change(objeto.getString("last_change"));

            detallesEquipo.setRelations(objeto.getString("relations"));
            detallesEquipo.setRelatedImg(objeto.getString("relatedImg"));
            detallesEquipo.setBasealias_old(objeto.getString("basealias_old"));
            detallesEquipo.setPatrocinador(objeto.getString("patrocinador"));
            detallesEquipo.setPatrocinador_b(objeto.getString("patrocinador_b"));
            detallesEquipo.setTeam_b(objeto.getString("team_b"));
            detallesEquipo.setProveedor(objeto.getString("proveedor"));
            detallesEquipo.setLugar_entrenamiento(objeto.getString("lugar_entrenamiento"));
            detallesEquipo.setRepeat_year(objeto.getString("repeat_year"));
            detallesEquipo.setNo_year(objeto.getString("no_year"));
            detallesEquipo.setError_date(objeto.getString("error_date"));
            detallesEquipo.setFifaId(objeto.getString("fifaId"));
            detallesEquipo.setMain_image(objeto.getString("main_image"));
            detallesEquipo.setType_team(objeto.getString("type_team"));
            detallesEquipo.setActive_relations(objeto.getString("active_relations"));
            detallesEquipo.setMatch_played(objeto.getString("match_played"));
            detallesEquipo.setMatch_to_play(objeto.getString("match_to_play"));
            detallesEquipo.setLocalidad(objeto.getString("localidad"));
            detallesEquipo.setGeonameid(objeto.getString("geonameid"));
            detallesEquipo.setHid(objeto.getString("hid"));

            detallesEquipo.setHid_B(objeto.getString("hid_B"));
            detallesEquipo.setTranslate(objeto.getString("translate"));
            detallesEquipo.setEmail(objeto.getString("email"));
            detallesEquipo.setName(objeto.getString("Name"));
            detallesEquipo.setContinent(objeto.getString("Continent"));
            detallesEquipo.setRegion(objeto.getString("Region"));
            detallesEquipo.setShield(objeto.getString("shield"));
            detallesEquipo.setImg_stadium(objeto.getString("img_stadium"));
            detallesEquipo.setPosition(objeto.getInt("position"));
            detallesEquipo.setT_squad(objeto.getInt("t_squad"));
            detallesEquipo.setHasNews(objeto.getBoolean("hasNews"));

        }
        catch(JSONException e){
            e.printStackTrace();
        }


//        private String id;
//        private String nameShow;
//        private String basealias;
//        private String CountryCode;
//        private String location;
//        private String basename;
//        private String stadium;
//        private String short_name;
//        private String managerNow;
//        private String seats;
//        private String website;
//        private String yearFoundation;
//        private String city;
//        private String address;
//        private String phone;
//        private String fax;
//        private String chairman;
//        private String fullName;
//        private String yearlyBudget;
//        private String info;
//        private String fans;
//        private String typefield;
//        private String ctype;
//        private String yearBuilt;
//        private String size;
//        private String historical;
//        private String comments;
//        private String color1;
//        private String color2;
//        private String kit_home;
//        private String kit_away;
//        private String kit_third;
//        private String twitter;
//        private String twitter_coach;
//        private String twitter_president;
//        private String twitter_b;
//        private String qod;
//        private String pod;
//        private String last_change;
//        private String relations;
//        private String relatedImg;
//        private String basealias_old;
//        private String patrocinador;
//        private String patrocinador_b;
//        private String team_b;
//        private String proveedor;
//        private String lugar_entrenamiento;
//        private String repeat_year;
//        private String no_year;
//        private String error_date;
//        private String fifaId;
//        private String main_image;
//        private String type_team;
//        private String active_relations;
//        private String match_played;
//        private String match_to_play;
//        private String localidad;
//        private String geonameid;
//        private String hid;
//        private String hid_B;
//        private String translate;
//        private String email;
//        private String Name;
//        private String Continent;
//        private String Region;
//        private String shield;
//        private String img_stadium;

        return detallesEquipo;
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
