package com.macostay.jsonvolleytest;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.macostay.jsonvolleytest.fragments.FragmentLoading;
import com.macostay.jsonvolleytest.fragments.FragmentPersonList;
import com.macostay.jsonvolleytest.fragments.FragmentTeamList;
import com.macostay.jsonvolleytest.fragments.FragmentViewPager;
import com.macostay.jsonvolleytest.models.Person;
import com.macostay.jsonvolleytest.models.PersonList;
import com.macostay.jsonvolleytest.models.PersonSerialized;
import com.macostay.jsonvolleytest.models.TeamList;
import com.macostay.jsonvolleytest.models.Teams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";
    private RequestQueue requestQueue;
    JsonObjectRequest jsArrayRequest;
    private static final String URL = "http://www.json-generator.com/api/json/get/bQReIxvKGa?indent=2";
    //http://www.json-generator.com/api/json/get/cdzINsfyYy?indent=2 escudos
    //http://www.json-generator.com/api/json/get/cePSSbCklK?indent=2
    //http://www.json-generator.com/api/json/get/ciZuOHcvGW?indent=2 ultima con equipos
//    http://www.json-generator.com/api/json/get/bQReIxvKGa?indent=2 definitivo
    //http://www.resultados-futbol.com/scripts/api/api.php?tz=Europe/Madrid&format=&req=teams&key=9fb0641102eeb3cd7d7db99606624a08&league=107&year=2014&group=playoff
    //ArrayList<Person> items;
    ArrayList<Teams> items;
    TeamList list;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


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
                            //PersonList list = new PersonList(items);
                            list = new TeamList(items);
                            //getSupportFragmentManager().beginTransaction().replace(R.id.flmainContainer, FragmentPersonList.newInstance(list)).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE).commit();
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

            JsonVolleyTestSingleton.getInstance(getApplicationContext()).addToRequestQueue(jsArrayRequest);

        } else {
            Toast.makeText(getApplicationContext(), "No hay conexión", Toast.LENGTH_LONG).show();
            finish();
        }




    }
    public boolean Conexion(){
        //Recogemos el servicio ConnectivityManager el cual se encarga de todas las conexiones del terminal
        ConnectivityManager conMan = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        //Recogemos el estado del 3G como vemos se recoge con el parámetro 0
        NetworkInfo.State internet_movil = conMan.getNetworkInfo(0).getState();
        //Recogemos el estado del wifi En este caso se recoge con el parámetro 1
        NetworkInfo.State wifi = conMan.getNetworkInfo(1).getState();
        //Miramos si el internet 3G está conectado o conectandose...
        if (internet_movil == NetworkInfo.State.CONNECTED || internet_movil == NetworkInfo.State.CONNECTING) {
            ///////////////
            //El movil está conectado por 3G
            //En este ejemplo mostraríamos mensaje por pantalla
            //Toast.makeText(getApplicationContext(), "Conectado por 3G", Toast.LENGTH_LONG).show();
            return true;
            //Si no esta por 3G comprovamos si está conectado o conectandose al wifi...
        } else if (wifi == NetworkInfo.State.CONNECTED || wifi == NetworkInfo.State.CONNECTING) {
            ///////////////
            //El movil está conectado por WIFI
            //En este ejemplo mostraríamos mensaje por pantalla
            //Toast.makeText(getApplicationContext(), "Conectado por WIFI", Toast.LENGTH_LONG).show();
            return true;
        }else{
            //Toast.makeText(getApplicationContext(), "No hay conexión", Toast.LENGTH_LONG).show();
            return false;
        }
    }
//    public ArrayList<Person> parseJson(JSONObject jsonObject){
//        // Variables locales
//        ArrayList<Person> posts = new ArrayList<>();
//        JSONArray jsonArray;
//
//        try {
//            // Obtener el array del objeto
//            jsonArray = jsonObject.getJSONArray("items");
//
//            for(int i=0; i<jsonArray.length(); i++){
//
//                try {
//                    JSONObject objeto= jsonArray.getJSONObject(i);
//
//
//                    Person person = new Person(
//                            objeto.getInt("index"),
//                            objeto.getString("name"),
//                            objeto.getInt("age"),
//                            objeto.getString("address"),
//                            objeto.getString("email"),
//                            objeto.getString("phone"),
//                            objeto.getString("image"));
//
//
//                    posts.add(person);
//
//                } catch (JSONException e) {
//                    Log.e(TAG, "Error de parsing: "+ e.getMessage());
//                }
//            }
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//

//        return posts;
//    }
    public ArrayList<Teams> parseJson(JSONObject jsonObject){
        // Variables locales
        ArrayList<Teams> posts = new ArrayList<>();
        JSONArray jsonArray;

        try {
            // Obtener el array del objeto
            jsonArray = jsonObject.getJSONArray("items");

            for(int i=0; i<jsonArray.length(); i++){

                try {
                    JSONObject objeto= jsonArray.getJSONObject(i);


                    Teams team = new Teams(
                            objeto.getString("id"),
                            objeto.getString("name"),
                            objeto.getString("group_code"),
                            objeto.getString("image"));


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
        else if(id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("destroy", "destroy");

        //gateway.getQueue().getCache().clear();
    }


}
