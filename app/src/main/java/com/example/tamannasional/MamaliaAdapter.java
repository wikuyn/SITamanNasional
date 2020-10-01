package com.example.tamannasional;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MamaliaAdapter extends RecyclerView.Adapter<MamaliaAdapter.MyViewHolder> {
    private Context konteks;
    private ArrayList<FloraFauna> mfloraFaunas;

    public MamaliaAdapter(Context context,ArrayList<FloraFauna> floraFaunas){
        this.konteks = context;
        this.mfloraFaunas = floraFaunas;
    }
    @NonNull
    @Override
    public MamaliaAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recyclerview_florafauna,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MamaliaAdapter.MyViewHolder holder, final int position) {

        holder.nama.setText(mfloraFaunas.get(position).getNama());
        Picasso.get().load(mfloraFaunas.get(position).getImg()).into(holder.img);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String key = mfloraFaunas.get(position).getKey();
                //Bundle bundle = new Bundle();
                //bundle.putString("key",key);
                //dialogflora dialog = new dialogflora();
                //dialog.setArguments(bundle);
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                View view1 =  LayoutInflater.from(view.getContext()).inflate(R.layout.dialog_florafauna,null);
                TextView tvnama = view1.findViewById(R.id.tv_namabinatang);
                TextView tvbobot = view1.findViewById(R.id.tv_bobot);
                TextView tvmakanan = view1.findViewById(R.id.tv_makanan);
                TextView tvstatus = view1.findViewById(R.id.tv_status);
                ImageView ivgambar = view1.findViewById(R.id.iv_gambarbinatang);

                tvbobot.setText(mfloraFaunas.get(position).getBerat());
                tvnama.setText(mfloraFaunas.get(position).getNama());
                tvmakanan.setText(mfloraFaunas.get(position).getMakanan());
                tvstatus.setText(mfloraFaunas.get(position).getStatus());
                Picasso.get().load(mfloraFaunas.get(position).getImg()).into(ivgambar);
                builder.setView(view1);
                AlertDialog alertDialog = builder.create();
                alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                alertDialog.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mfloraFaunas.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView nama;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.ivflora);
            nama = itemView.findViewById(R.id.tvketflora);
        }
    }
}
