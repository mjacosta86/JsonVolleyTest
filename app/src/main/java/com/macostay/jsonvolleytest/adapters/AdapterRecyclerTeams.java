package com.macostay.jsonvolleytest.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.macostay.jsonvolleytest.JsonVolleyTestSingleton;
import com.macostay.jsonvolleytest.R;
import com.macostay.jsonvolleytest.models.Teams;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by macostay on 14/10/2015.
 */
public class AdapterRecyclerTeams extends RecyclerView.Adapter<AdapterRecyclerTeams.TeamsViewHolder>implements View.OnClickListener{
    private View.OnClickListener listener;
    private ArrayList<Teams> datos;
    //private Context context;
    //private static RequestQueue requestQueue;


    // Atributos
    private static final String TAG = "AdapterRecyclerPerson";
    private static final String TAG2 = "NoImagen";

    public static class TeamsViewHolder extends RecyclerView.ViewHolder {

        //@InjectView(R.id.LblTitulo)
        TextView tvName;
        //NetworkImageView ivFoto;
        ImageView ivFoto;
        Context context;


        public TeamsViewHolder(View itemView, Context c) {
            super(itemView);
            //ButterKnife.inject(this, itemView);
            tvName = (TextView)itemView.findViewById(R.id.tvName);
            //ivFoto = (NetworkImageView)itemView.findViewById(R.id.ivFoto);
            ivFoto = (ImageView)itemView.findViewById(R.id.ivFoto);
            context = c;

        }

        public TeamsViewHolder(View itemView) {
            super(itemView);
            //ButterKnife.inject(this, itemView);
            tvName = (TextView)itemView.findViewById(R.id.tvName);
            //ivFoto = (NetworkImageView)itemView.findViewById(R.id.ivFoto);
            ivFoto = (ImageView)itemView.findViewById(R.id.ivFoto);

        }

        public void bindTitular(Teams t) {
            tvName.setText(t.getName());

//            try {
//                // Petición el image loader
//                ImageLoader imageLoader = JsonVolleyTestSingleton.getInstance(context).getImageLoader();
//                // Petición
//                Log.i(TAG,t.getImage());
//                if((t.getImage()==null)||(t.getImage().isEmpty())) {
//                    ivFoto.setImageResource(R.mipmap.ic_launcher);
//                }
//                else{
//                    ivFoto.setImageUrl(t.getImage(), imageLoader);
//                }
//            }catch (Exception e){
//
//            }


            //cargamos la imagen con picasso
            Picasso.with(ivFoto.getContext()).load(t.getImage()).error(R.mipmap.ic_launcher).into(ivFoto);


        }

    }

    public AdapterRecyclerTeams(ArrayList<Teams> datos) {
        this.datos = datos;
    }

    @Override
    public TeamsViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.photo_list, viewGroup, false);

        itemView.setOnClickListener(this);

        //PersonViewHolder tvh = new PersonViewHolder(itemView);
        TeamsViewHolder tvh = new TeamsViewHolder(itemView,itemView.getContext());

        return tvh;
    }

    @Override
    //Encargado de actualizar los datos de un ViewHolder ya existente.
    public void onBindViewHolder(TeamsViewHolder viewHolder, int pos) {
        Teams item = datos.get(pos);
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
