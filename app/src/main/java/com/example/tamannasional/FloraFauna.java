package com.example.tamannasional;

public class FloraFauna {
    String img,nama,key,berat,makanan,status;

    public FloraFauna() {
    }

    public FloraFauna(String img, String nama, String key, String berat, String makanan, String status) {
        this.img = img;
        this.nama = nama;
        this.key = key;
        this.berat = berat;
        this.makanan = makanan;
        this.status = status;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getBerat() {
        return berat;
    }

    public void setBerat(String berat) {
        this.berat = berat;
    }

    public String getMakanan() {
        return makanan;
    }

    public void setMakanan(String makanan) {
        this.makanan = makanan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
