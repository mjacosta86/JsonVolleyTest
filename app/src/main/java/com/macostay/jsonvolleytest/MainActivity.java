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
import com.macostay.jsonvolleytest.fragments.FragmentLeagueList;
import com.macostay.jsonvolleytest.fragments.FragmentListTest;
import com.macostay.jsonvolleytest.fragments.FragmentLoading;
import com.macostay.jsonvolleytest.fragments.FragmentTeamList;
import com.macostay.jsonvolleytest.fragments.FragmentViewPager;
import com.macostay.jsonvolleytest.models.Category;
import com.macostay.jsonvolleytest.models.CategoryLiga;
import com.macostay.jsonvolleytest.models.CategoryLigas;
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
    private static final String URL2 = "http://www.resultados-futbol.com/scripts/api/api.php?tz=Europe/Madrid&format=json&req=categories&key=65f8402127f4aae612732b4cb6089c22&country=es&filter=all";
    //test con error en una imagen http://www.json-generator.com/api/json/get/bTAdMlAMpu?indent=2
    // bueno http://www.json-generator.com/api/json/get/ckEMqcXNea?indent=2
    // resultados ligas http://www.json-generator.com/api/json/get/cfIQeMCJAi?indent=2
    // resultados api http://www.resultados-futbol.com/scripts/api/api.php?tz=Europe/Madrid&format=json&req=categories&key=60888a5f28e66b62d6f29d7961be9ae8&country=es&filter=all"
    //test http://www.json-generator.com/api/json/get/cjHcMCBNlu?indent=2
    //clave gratuita en vigor 60888a5f28e66b62d6f29d7961be9ae8
    //clave caducada 65f8402127f4aae612732b4cb6089c22
    ArrayList<Teams> items;
    TeamList list;
    CategoryLigas ligas;


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

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

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
                            getSupportFragmentManager().beginTransaction()
                              .replace(R.id.flmainContainer, FragmentTeamList.newInstance(list))
                              .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)
                              .commit();
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
        } else if (id == R.id.category){

            requestQueue = Volley.newRequestQueue(this);

            Log.i(TAG,URL2);

            // Nueva petición JSONObject
            jsArrayRequest = new JsonObjectRequest(
                    Request.Method.GET,
                    URL2,
                    null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {

                            Log.i(TAG,"Entro en el onResponse");
                            ligas = new CategoryLigas();
                            ligas = parseJson2(response);
                            getSupportFragmentManager().beginTransaction()
                                    .replace(R.id.flmainContainer, FragmentLeagueList.newInstance(ligas))
                                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)
                                    .addToBackStack("FragmentLeagueList")
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

            JsonVolleyTestSingleton.getInstance(getApplicationContext()).addToRequestQueue(jsArrayRequest);//Añadimos la petición a la cola


        }


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

    public CategoryLigas parseJson2(JSONObject jsonObject){
        // Variables locales
        Log.i(TAG,"Entro en el ParseJson2");
        ArrayList<CategoryLiga> ligaList = new ArrayList<>();
        CategoryLigas listLigas = new CategoryLigas();
        try {
            // Obtener el array del objeto
            Log.i("Dato", jsonObject.getJSONObject("category").getJSONObject("spain").getJSONArray("ligas").get(0).toString());
            String json = jsonObject.toString();
            Gson gson = new Gson();
            Category categorias = gson.fromJson(json, Category.class);





            JSONObject category = jsonObject.getJSONObject("category");
            JSONObject spain = category.getJSONObject("spain");
            JSONArray ligas = spain.getJSONArray("ligas");

            for (int i = 0; i < ligas.length(); ++i)
            {
                JSONObject item = ligas.getJSONObject(i);//JSONObject arrayElement_0 = jsonArray.getJSONObject(0);

                CategoryLiga l = new CategoryLiga();
                l.setName(item.getString("name").toString().trim());
                l.setId(item.getInt("id"));
                Log.i("Name", l.getName());
                Log.i("ID", l.getId()+"");
                l.setLogo(item.getString("logo").toString().trim());

                //---print out the content of the json feed---
                ligaList.add(l);

            }



        } catch (JSONException e) {
            e.printStackTrace();
        }

        listLigas.setLigas(ligaList);
        return listLigas;
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
