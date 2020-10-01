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


public class ReptilFragment extends Fragment {

    View view;
    RecyclerView recyclerView;
    ArrayList<FloraFauna> faunaudara;
    DatabaseReference reference;
    RecyclerView.Adapter adapter;
    TextView tvkosong;

    Context context;

    public ReptilFragment() {
        // Required empty public constructor
    }

    public static ReptilFragment getInstance() {
        ReptilFragment fragment = new ReptilFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_reptil, container, false);
        recyclerView = view.findViewById(R.id.rv_udara);
        tvkosong = view.findViewById(R.id.tvKosong);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        tvkosong.setVisibility(View.GONE);
        Bundle ambil = getActivity().getIntent().getExtras();
        String key = ambil.getString("kode_key");

        reference = FirebaseDatabase.getInstance().getReference().child("taman").child(key).child("faunareptil");
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                faunaudara = new ArrayList<>();
                if (dataSnapshot.exists()){
                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()){
                        FloraFauna fauna = dataSnapshot1.getValue(FloraFauna.class);
                        fauna.setKey(dataSnapshot1.getRef().getKey());
                        faunaudara.add(fauna);
                        tvkosong.setVisibility(View.GONE);
                    }
                }else{
                    tvkosong.setVisibility(View.VISIBLE);
                }
                adapter = new MamaliaAdapter(context,faunaudara);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        return view;
    }
}