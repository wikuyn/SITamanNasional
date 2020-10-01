package com.example.tamannasional;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.ms.square.android.expandabletextview.ExpandableTextView;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TamanNasionalDetailsActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {

    private double mLat, mLng;
    private String nama,lokasi,imageUrl,deskripsi,video,imgurlfauna,ketfauna,imgurlflora,ketflora;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;

    TextView tvlokasi,tvnama,tvketfauna,tvketflora;
    ImageView foto,fotofauna,fotoflora;
    ExpandableTextView expandableTextView;
    Button btnMaps;
    ShimmerFrameLayout shimmerFrameLayout;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    ArrayList<FloraFauna> mlist;

    String key;

    DatabaseReference reference,reference1;
    StorageReference storageReference;
    YouTubePlayerView youTubePlayerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taman_nasional_details);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tabLayout = findViewById(R.id.tabLayout);

        viewPager = findViewById(R.id.viewpager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.AddFragmant(MamaliaFragment.getInstance(),"Mamalia");
        viewPagerAdapter.AddFragmant(ReptilFragment.getInstance(),"Air,Reptil & Amfibi");
        viewPagerAdapter.AddFragmant(AvesFragment.getInstance(),"Aves");
        viewPagerAdapter.AddFragmant(FloraFragment.getInstance(),"Flora & Terumbu Karang");

        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        tvlokasi = findViewById(R.id.tvlokasi);
        foto = findViewById(R.id.foto);
        tvnama = findViewById(R.id.tvnama);
        expandableTextView = findViewById(R.id.expandable_text_view);
        tvketflora = findViewById(R.id.tvketflora);
        fotoflora = findViewById(R.id.ivflora);
        youTubePlayerView = findViewById(R.id.video_player);
        btnMaps = findViewById(R.id.btn_afd_maps);

        reference1 = FirebaseDatabase.getInstance().getReference();
        storageReference = FirebaseStorage.getInstance().getReference();
        mlist = new ArrayList<>();

        Bundle bundle = getIntent().getExtras();
        key = bundle.getString("kode_key");
        reference = FirebaseDatabase.getInstance().getReference().child("taman").child(key);
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    mLat = (double) dataSnapshot.child("lokasi_lat").getValue();
                    mLng = (double) dataSnapshot.child("lokasi_lng").getValue();
                    nama = dataSnapshot.child("nama").getValue().toString();
                    lokasi = dataSnapshot.child("lokasi").getValue().toString();
                    imageUrl = dataSnapshot.child("url").getValue().toString();
                    deskripsi = dataSnapshot.child("deskripsi").getValue().toString();
                    video = dataSnapshot.child("video_id").getValue().toString();


                    Picasso.get().load(imageUrl).into(foto);
                    tvnama.setText(nama);
                    expandableTextView.setText(deskripsi);
                    tvlokasi.setText(lokasi);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(YouTubePlayer youTubePlayer) {
                super.onReady(youTubePlayer);
                youTubePlayer.cueVideo(video,0);
            }
        });

        btnMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goMaps = new Intent(TamanNasionalDetailsActivity.this, LokasiActivity.class);
                goMaps.putExtra("LatArgs", mLat);
                goMaps.putExtra("LngArgs", mLng);
                goMaps.putExtra("NamaTaman", nama);
                startActivity(goMaps);
            }
        });

    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
