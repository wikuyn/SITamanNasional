package com.example.tamannasional;

public class SoalPertanyaan {

    public String pertanyaan[] = {
            "Apa nama taman nasional yang terletak di DKI Jakarta ?",
            "Taman nasional diatas merupakan salah satu taman nasional di jawa timur, taman nasional tersebut terkenal dengan gunungnya tertinggi di pulau jawa taman nasional apakah itu ?",
            "Hewan ini merupakan hewan khas salah satu taman nasional di indonesia, hewan ini sudah diambang kepunahan hewan apakah itu?",
            "Ada berapa jumlah taman nasional di indonesia ?",
            "Taman nasional apakah yang memiliki pemandangan layaknya di savana afrika ? ",
            "Spesies penyu terbesar di indonesia namun keberadaannya sudah terancam punah adalah ?",
            "Hewan di atas merupakan primata yang bisa di temui di beberapa taman nasional di jawa barat dan jawa timur berbentuk seperti kera apakah itu?",
            "Hewan ini sudah punah dan hanya tinggal cerita, dahulu dapat dijumpai di hutan-hutan pada pulau jawa apakah itu?",
            "Ayam yang ada dihutan disebut dengan ...",
            "Hewan diatas dapat dijumpai di beberapa taman nasional di indonesia dan juga menjadi maskot kota jakarta adalah ..."
    };

    public String gambar[] = {
            "monas",
            "bromo",
            "badak",
            "jawa",
            "baluran",
            "penyu",
            "owa",
            "harimau",
            "ayam",
            "elang"

    };

    public String jawabanBenar[] = {
            "Kepulauan Seribu",
            "Bromo Tengger Semeru",
            "Badak Jawa",
            "12",
            "Baluran",
            "Penyu belimbing",
            "Owa Jawa",
            "Harimau Jawa",
            "Ayam Hutan",
            "Elang Bondol"
    };

    public String getPertanyaan(int x) {
        String soal = pertanyaan[x];
        return soal;
    }

    public String getGambar(int x) {
        String foto = gambar[x];
        return foto;
    }

    public String getJawabanBenar(int x) {
        String jawab = jawabanBenar[x];
        return jawab;
    }
}
