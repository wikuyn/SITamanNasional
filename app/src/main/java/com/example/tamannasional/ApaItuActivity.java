package com.example.tamannasional;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.ms.square.android.expandabletextview.ExpandableTextView;

public class ApaItuActivity extends AppCompatActivity {

    public String soal,jawab,soal1,jawab1,soal2,jawab2;

    DatabaseReference reference;
    TextView tvsoal,tvjawab,tvsoal1,tvjawab1,tvsoal2,tvjawab2;
    ShimmerFrameLayout shimmerFrameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apa_itu);

        final ExpandableTextView expTv1 = (ExpandableTextView)findViewById(R.id.expand_text_view);


        tvsoal = findViewById(R.id.tv_soal);
        tvjawab = findViewById(R.id.tv_jawab);
        tvsoal1 = findViewById(R.id.tv_soal1);
        tvjawab1 = findViewById(R.id.tv_jawab1);
        tvsoal2 = findViewById(R.id.tv_soal2);
        tvjawab2 = findViewById(R.id.expandable_text);

        shimmerFrameLayout = findViewById(R.id.shimmerapaitu);

        shimmerFrameLayout.startShimmer();
        reference = FirebaseDatabase.getInstance().getReference().child("pertanyaan");
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                soal = dataSnapshot.child("pertanyaan1").getValue().toString();
                jawab = dataSnapshot.child("jawaban1").getValue().toString();

                soal1 = dataSnapshot.child("pertanyaan2").getValue().toString();
                jawab1 = dataSnapshot.child("jawaban2").getValue().toString();

                soal2 = dataSnapshot.child("pertanyaan3").getValue().toString();
                jawab2 = dataSnapshot.child("jawaban3").getValue().toString();

                tvsoal.setText(soal);
                tvjawab.setText(jawab);
                tvsoal1.setText(soal1);
                tvjawab1.setText(jawab1);
                tvsoal2.setText(soal2);
                expTv1.setText(jawab2);
                shimmerFrameLayout.stopShimmer();
                shimmerFrameLayout.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}