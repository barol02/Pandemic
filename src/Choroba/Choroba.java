package Choroba;


public class Choroba {
    int smiertelnosc;
    int OdpornoscPoPrzechorowaniu;
    int czasInkubacji;


    String Nazwa;


    public Choroba() {
        Nazwa = "";
        smiertelnosc = 0;
        czasInkubacji = 0;
        OdpornoscPoPrzechorowaniu=0;
    }

    public Choroba(String nazwa, int czas, int obrazenia,int odpornoscPoPrzechorowaniu) {
        Nazwa = nazwa;
        smiertelnosc = obrazenia;
        czasInkubacji = czas;
        OdpornoscPoPrzechorowaniu = odpornoscPoPrzechorowaniu;
    }

    public int getSmiertelnosc() {
        return smiertelnosc;
    }
    public int getCzasInkubacji() {
        return czasInkubacji;
    }

    public int getOdpornoscPoPrzechorowaniu() {
        return OdpornoscPoPrzechorowaniu;
    }
}


