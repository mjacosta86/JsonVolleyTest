package com.macostay.jsonvolleytest;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.support.v4.view.GravityCompat;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.macostay.jsonvolleytest.fragments.FragmentListTest;
import com.macostay.jsonvolleytest.fragments.FragmentLoading;
import com.macostay.jsonvolleytest.fragments.FragmentTeamList;
import com.macostay.jsonvolleytest.fragments.FragmentViewPager;
import com.macostay.jsonvolleytest.models.Player;
import com.macostay.jsonvolleytest.models.PlayerList;
import com.macostay.jsonvolleytest.models.TeamList;
import com.macostay.jsonvolleytest.models.Teams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{


    private static final String TAG = "MainActivity";
    private RequestQueue requestQueue;
    JsonObjectRequest jsArrayRequest;
    private static final String URL = "http://www.json-generator.com/api/json/get/ckEMqcXNea?indent=2";
    ArrayList<Teams> items;
    TeamList list;

    //Controles
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.drawer_layout)
    DrawerLayout drawer;
    @Bind(R.id.nav_view)
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Log.i(TAG,"Method onCreate");


        //Toolbar toolbar  = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        //NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        if(Conexion() == true){
            getSupportFragmentManager().beginTransaction().replace(R.id.flmainContainer, FragmentLoading.newInstance()).commit();

            // Crear nueva cola de peticiones

            requestQueue = Volley.newRequestQueue(this);

            Log.i(TAG,URL);

            // Nueva petición JSONObject
            jsArrayRequest = new JsonObjectRequest(
                    Request.Method.GET,
                    URL,
                    null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {

                            items = parseJson(response);
                            list = new TeamList(items);
                            getSupportFragmentManager().beginTransaction().replace(R.id.flmainContainer, FragmentTeamList.newInstance(list)).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE).commit();
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.d(TAG, "Error Respuesta en JSON: " + error.getMessage());

                        }
                    }
            );

            JsonVolleyTestSingleton.getInstance(getApplicationContext()).addToRequestQueue(jsArrayRequest);//Añadimos la petición a la cola

        } else {
            Toast.makeText(getApplicationContext(), "No hay conexión", Toast.LENGTH_LONG).show();
            finish();
        }




    }
    protected void onStart(){
        super.onStart();
        Log.i(TAG, "Method onStart");
    }
    protected void onResume(){
        super.onResume();
        Log.i(TAG, "Method onResume");
    }
    protected void onStop(){
        super.onStop();
        Log.i(TAG, "Method onStop");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Method onDestroy");

        //gateway.getQueue().getCache().clear();
    }
    @Override
    public void onBackPressed() {
        //DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            getSupportFragmentManager().beginTransaction().replace(R.id.flmainContainer, FragmentTeamList.newInstance(list)).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE).addToBackStack(null).commit();
        } else if (id == R.id.nav_gallery) {
            getSupportFragmentManager().beginTransaction().replace(R.id.flmainContainer, FragmentViewPager.newInstance(list)).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE).addToBackStack(null).commit();
        } else if (id == R.id.test){
            getSupportFragmentManager().beginTransaction().replace(R.id.flmainContainer, FragmentListTest.newInstance(list)).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE).addToBackStack(null).commit();
        }

        //DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public boolean Conexion(){
        //Recogemos el servicio ConnectivityManager el cual se encarga de todas las conexiones del terminal
        ConnectivityManager conMan = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        //Recogemos el estado del 3G como vemos se recoge con el parámetro 0
        NetworkInfo.State internet_movil = conMan.getNetworkInfo(0).getState();
//        boolean mobile = conMan.getActiveNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState();
        //Recogemos el estado del wifi En este caso se recoge con el parámetro 1
        NetworkInfo.State wifi = conMan.getNetworkInfo(1).getState();
        //Miramos si el internet 3G está conectado o conectandose...
        if (internet_movil == NetworkInfo.State.CONNECTED || internet_movil == NetworkInfo.State.CONNECTING) {
            ///////////////
            //El movil está conectado por 3G
            //En este ejemplo mostraríamos mensaje por pantalla
            return true;
            //Si no esta por 3G comprovamos si está conectado o conectandose al wifi...
        } else if (wifi == NetworkInfo.State.CONNECTED || wifi == NetworkInfo.State.CONNECTING) {
            ///////////////
            //El movil está conectado por WIFI
            //En este ejemplo mostraríamos mensaje por pantalla
            return true;
        }else{
            Toast.makeText(getApplicationContext(), "No hay conexión", Toast.LENGTH_LONG).show();
            return false;
        }
    }

    public ArrayList<Teams> parseJson(JSONObject jsonObject){
        // Variables locales
        ArrayList<Teams> posts = new ArrayList<>();
        JSONArray jsonArray;


        try {
            // Obtener el array del objeto
            jsonArray = jsonObject.getJSONArray("items");

            for(int i=0; i<jsonArray.length(); i++){

                try {

                    JSONObject objeto = jsonArray.getJSONObject(i);

                    String json = objeto.toString();
                    Gson gson = new Gson();
                    Teams team = gson.fromJson(json, Teams.class);

                    posts.add(team);

                } catch (JSONException e) {
                    Log.e(TAG, "Error de parsing: "+ e.getMessage());
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }


        return posts;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.show_all_items) {
            getSupportFragmentManager().beginTransaction().replace(R.id.flmainContainer, FragmentViewPager.newInstance(list)).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE).addToBackStack(null).commit();
            return true;
        }


        return super.onOptionsItemSelected(item);
    }



}
