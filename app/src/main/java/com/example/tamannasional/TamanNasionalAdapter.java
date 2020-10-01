package com.example.tamannasional;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TamanNasionalAdapter extends RecyclerView.Adapter<TamanNasionalAdapter.MyViewHolder> {

    private Context mcontext;
    private ArrayList<TamanNasional> tamanNasionals;

    public TamanNasionalAdapter(Context context,ArrayList<TamanNasional> tamanNasionals){
        this.mcontext = context;
        this.tamanNasionals = tamanNasionals ;
    }

    @NonNull
    @Override
    public TamanNasionalAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(mcontext).inflate(R.layout.item_taman_recyclerview,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.tvNama.setText(tamanNasionals.get(position).getNama());
        holder.tvLokasi.setText(tamanNasionals.get(position).getLokasi());
        Picasso.get().load(tamanNasionals.get(position).getUrl()).into(holder.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String key = tamanNasionals.get(position).getKey();
                Intent gotodetail = new Intent(mcontext, TamanNasionalDetailsActivity.class);
                gotodetail.putExtra("kode_key",key);
                mcontext.startActivity(gotodetail);
            }
        });
    }

    @Override
    public int getItemCount() {
        return tamanNasionals.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView tvLokasi,tvNama;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            tvNama = itemView.findViewById(R.id.tvNamaTaman);
            tvLokasi = itemView.findViewById(R.id.tvLokasi);
        }
    }
}
