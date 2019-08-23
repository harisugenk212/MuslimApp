package com.example.sholatapp;

public class kota {
    private int id;
    private String nama;

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String toString(){
        return nama.toString();
    }

    public void setId(int id) {
        this.id = id;
    }
}
