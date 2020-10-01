package com.example.tamannasional;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class MenuActivity extends AppCompatActivity {

    RelativeLayout bntMain,btnTtg,btnKuis,btnApaItu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        bntMain = findViewById(R.id.btn_Main);
        btnTtg = findViewById(R.id.btn_tentang);
        btnKuis = findViewById(R.id.btn_soal);
        btnApaItu = findViewById(R.id.btn_apaitu);

        bntMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(MenuActivity.this,MainActivity.class);
                startActivity(pindah);
            }
        });

        btnTtg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(MenuActivity.this, TentangActivity.class);
                startActivity(pindah);
            }
        });

        btnKuis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(MenuActivity.this,PertanyaanActivity.class);
                startActivity(pindah);
            }
        });

        btnApaItu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(MenuActivity.this,ApaItuActivity.class);
                startActivity(pindah);
            }
        });

    }
}