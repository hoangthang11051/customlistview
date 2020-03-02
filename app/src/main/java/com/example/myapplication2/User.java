package com.example.myapplication2;

public class User {
    private String Ten;
    private int Tuoi;


    public User(String ten, int tuoi) {
        Ten = ten;
        Tuoi = tuoi;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public int getTuoi() {
        return Tuoi;
    }

    public void setTuoi(int tuoi) {
        Tuoi = tuoi;
    }
}
