package com.example.tamannasional;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AvesFragment extends Fragment {

    View view;
    RecyclerView recyclerView;
    ArrayList<FloraFauna>faunaaves;
    DatabaseReference reference;
    RecyclerView.Adapter adapter;
    TextView tvkosong;

    Context context;


    public AvesFragment() {
        // Required empty public constructor
    }

    public static AvesFragment getInstance() {
        AvesFragment fragment = new AvesFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_aves, container, false);
        recyclerView = view.findViewById(R.id.rv_aves);
        tvkosong = view.findViewById(R.id.tvKosong);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        tvkosong.setVisibility(View.GONE);
        Bundle ambil = getActivity().getIntent().getExtras();
        String key = ambil.getString("kode_key");

        reference = FirebaseDatabase.getInstance().getReference().child("taman").child(key).child("faunaaves");
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                faunaaves = new ArrayList<>();
                if (dataSnapshot.exists()){

                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                        FloraFauna floraFauna = dataSnapshot1.getValue(FloraFauna.class);
                        floraFauna.setKey(dataSnapshot1.getRef().getKey());
                        faunaaves.add(floraFauna);
                        tvkosong.setVisibility(View.GONE);
                    }
                }else {
                    tvkosong.setVisibility(View.VISIBLE);
                }
                adapter = new MamaliaAdapter(context,faunaaves);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        return view;
    }
}