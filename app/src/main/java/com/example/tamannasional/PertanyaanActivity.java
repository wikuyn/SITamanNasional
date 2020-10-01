package com.example.tamannasional;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PertanyaanActivity extends AppCompatActivity {

    TextView tvSoal,tvnyawa;
    Button cekjawaban,btntutup;
    EditText edtJawaban;
    ImageView gambarSoal;
    int nyawa = 3;
    int arr;
    int x = 0;
    String jawaban;
    Dialog dialog;

    SoalPertanyaan soal = new SoalPertanyaan();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pertanyaan);

        tvSoal = findViewById(R.id.tvSoal);
        btntutup = findViewById(R.id.tutup);
        tvnyawa = findViewById(R.id.tv_nyawa);
        cekjawaban = findViewById(R.id.btn_cek);
        edtJawaban = findViewById(R.id.etjawab);
        gambarSoal = findViewById(R.id.gambar);

        setSoal();

        tampilInfo();


        cekjawaban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cekjawaban();
            }
        });

    }

    public void tampilInfo(){
        dialog = new Dialog(this);

        dialog.setContentView(R.layout.fragment_dialogflora);
        btntutup = dialog.findViewById(R.id.tutup);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
        btntutup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        /*final AlertDialog.Builder builder=new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View alertLayout = inflater.inflate(R.layout.fragment_dialogflora,null);
        builder.setView(alertLayout);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

         */
    }

    public void setSoal(){
        edtJawaban.setText(null);
        arr = soal.pertanyaan.length;
        if (x >= arr){
            Intent pindah = new Intent(PertanyaanActivity.this,MenangActivity.class);
            startActivity(pindah);
            finish();
        }else{
            tvSoal.setText(soal.getPertanyaan(x));
            jawaban = soal.getJawabanBenar(x);
            ubahGambar();
        }
        x++;
    }

    public void ubahGambar(){
        Resources res = getResources();
        String gambar = soal.getGambar(x);
        int idgambar = res.getIdentifier(gambar,"drawable",getPackageName());
        Drawable drawable = res.getDrawable(idgambar);
        gambarSoal.setImageDrawable(drawable);

    }

    public void cekjawaban(){
        if (!edtJawaban.getText().toString().isEmpty()){
            if (edtJawaban.getText().toString().equalsIgnoreCase(jawaban)){
                Toast.makeText(this, "Jawaban anda benar", Toast.LENGTH_SHORT).show();
                setSoal();
            }else{
                nyawa -= 1;
                String nyawafinal = String.valueOf(nyawa);
                tvnyawa.setText(nyawafinal);
                if (nyawa <= 0){
                    Intent pindah = new Intent(PertanyaanActivity.this, KalahActivity.class);
                    startActivity(pindah);
                    finish();
                }else{
                    setSoal();
                }
                Toast.makeText(this, "Jawaban anda salah", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Pastikan Jawaban Terisi", Toast.LENGTH_SHORT).show();
        }
    }
}