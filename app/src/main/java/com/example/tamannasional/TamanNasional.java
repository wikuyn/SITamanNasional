package com.example.tamannasional;

public class TamanNasional {

    String lokasi,url,key,nama;

    public TamanNasional() {
    }

    public TamanNasional(String lokasi, String url, String key, String nama) {
        this.lokasi = lokasi;
        this.url = url;
        this.key = key;
        this.nama = nama;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
