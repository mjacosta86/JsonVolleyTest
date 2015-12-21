package com.macostay.jsonvolleytest.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.macostay.jsonvolleytest.R;
import com.macostay.jsonvolleytest.models.CategoryLiga;
import com.macostay.jsonvolleytest.models.LeagueTeam;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by macostay on 14/10/2015.
 */
public class AdapterRecyclerTeamLeagues extends RecyclerView.Adapter<AdapterRecyclerTeamLeagues.TeamLeaguesViewHolder>implements View.OnClickListener{
    private View.OnClickListener listener;
    private ArrayList<LeagueTeam> datos;
    //private Context context;
    //private static RequestQueue requestQueue;


    // Atributos
    private static final String TAG = "AdapterRecyclerTeamLeagues";
    private static final String TAG2 = "NoImagen";

    public static class TeamLeaguesViewHolder extends RecyclerView.ViewHolder {

        //@InjectView(R.id.LblTitulo)
        TextView tvName;
        //NetworkImageView ivFoto;


        ImageView ivFoto;
        Context context;


        public TeamLeaguesViewHolder(View itemView, Context c) {
            super(itemView);
            //ButterKnife.inject(this, itemView);
            tvName = (TextView)itemView.findViewById(R.id.tvName);
            //ivFoto = (NetworkImageView)itemView.findViewById(R.id.ivFoto);
            ivFoto = (ImageView)itemView.findViewById(R.id.ivFoto);
            context = c;

        }

        public TeamLeaguesViewHolder(View itemView) {
            super(itemView);
            //ButterKnife.inject(this, itemView);
            tvName = (TextView)itemView.findViewById(R.id.tvName);
            //ivFoto = (NetworkImageView)itemView.findViewById(R.id.ivFoto);
            ivFoto = (ImageView)itemView.findViewById(R.id.ivFoto);

        }

        public void bindTitular(LeagueTeam l) {
            tvName.setText(l.getNameShow());

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
            Picasso.with(ivFoto.getContext()).load(l.getShield()).error(R.mipmap.ic_launcher).into(ivFoto);


        }

    }

    public AdapterRecyclerTeamLeagues(ArrayList<LeagueTeam> datos) {
        this.datos = datos;
    }

    @Override
    public AdapterRecyclerTeamLeagues.TeamLeaguesViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.photo_list, viewGroup, false);

        itemView.setOnClickListener(this);

        //PersonViewHolder tvh = new PersonViewHolder(itemView);
        TeamLeaguesViewHolder tvh = new TeamLeaguesViewHolder(itemView,itemView.getContext());

        return tvh;
    }

    @Override
    //Encargado de actualizar los datos de un ViewHolder ya existente.
    public void onBindViewHolder(TeamLeaguesViewHolder viewHolder, int pos) {
        LeagueTeam item = datos.get(pos);
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
