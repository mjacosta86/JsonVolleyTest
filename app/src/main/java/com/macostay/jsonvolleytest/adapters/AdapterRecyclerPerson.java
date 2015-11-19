package com.macostay.jsonvolleytest.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;
import com.macostay.jsonvolleytest.JsonVolleyTestSingleton;
import com.macostay.jsonvolleytest.R;
import com.macostay.jsonvolleytest.models.Person;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by macostay on 14/10/2015.
 */
public class AdapterRecyclerPerson extends RecyclerView.Adapter<AdapterRecyclerPerson.PersonViewHolder>implements View.OnClickListener{
    private View.OnClickListener listener;
    private ArrayList<Person> datos;
    //private Context context;
    //private static RequestQueue requestQueue;


    // Atributos
    private static final String TAG = "AdapterRecyclerPerson";
    private static final String TAG2 = "NoImagen";

    public static class PersonViewHolder extends RecyclerView.ViewHolder {

        //@InjectView(R.id.LblTitulo)
        TextView tvName;
        NetworkImageView ivFoto;
        //ImageView ivFoto;
        Context context;


        public PersonViewHolder(View itemView, Context c) {
            super(itemView);
            //ButterKnife.inject(this, itemView);
            tvName = (TextView)itemView.findViewById(R.id.tvName);
            ivFoto = (NetworkImageView)itemView.findViewById(R.id.ivFoto);
            //ivFoto = (ImageView)itemView.findViewById(R.id.ivFoto);
            context = c;

        }

        public PersonViewHolder(View itemView) {
            super(itemView);
            //ButterKnife.inject(this, itemView);
            tvName = (TextView)itemView.findViewById(R.id.tvName);
            ivFoto = (NetworkImageView)itemView.findViewById(R.id.ivFoto);
            //ivFoto = (ImageView)itemView.findViewById(R.id.ivFoto);

        }

        public void bindTitular(Person p) {
            tvName.setText(p.getName());

            try {
                // Petición el image loader
                ImageLoader imageLoader = JsonVolleyTestSingleton.getInstance(context).getImageLoader();
                // Petición
                Log.i(TAG,p.getImage());
                if((p.getImage()==null)||(p.getImage().isEmpty())) {
                    ivFoto.setImageResource(R.mipmap.ic_launcher);
                }
                else{
                    ivFoto.setImageUrl(p.getImage(), imageLoader);
                }
            }catch (Exception e){

            }


            //cargamos la imagen con picasso
            /*if((p.getImage().compareTo("")==0)||(p.getImage().compareTo(null)==0)){
                Picasso.with(ivFoto.getContext()).load(R.mipmap.ic_launcher);
            }
            else {
            Picasso.with(ivFoto.getContext()).load(p.getImage()).into(ivFoto);
            }*/


        }
    }

    public AdapterRecyclerPerson(ArrayList<Person> datos) {
        this.datos = datos;
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.person, viewGroup, false);

        itemView.setOnClickListener(this);

        //PersonViewHolder tvh = new PersonViewHolder(itemView);
        PersonViewHolder tvh = new PersonViewHolder(itemView,itemView.getContext());

        return tvh;
    }

    @Override
    //Encargado de actualizar los datos de un ViewHolder ya existente.
    public void onBindViewHolder(PersonViewHolder viewHolder, int pos) {
        Person item = datos.get(pos);
        viewHolder.bindTitular(item);
    }

    @Override

    public int getItemCount() {
        return datos!=null ? datos.size():0;
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if(listener != null)
            listener.onClick(view);
    }

}
