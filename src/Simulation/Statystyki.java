package Simulation;

import Human.Agent;

import java.util.List;

public class Statystyki {

    int iloscZarazonychBakteryjnie=0;
    int iloscZarazonychWirusowo=0;
    int iloscZarazonychGrzybicznie=0;


    public int getiloscZarazonychBakteryjnie() {
        return iloscZarazonychBakteryjnie;
    }

    public int getIloscZarazonychGrzybicznie() {
        return iloscZarazonychGrzybicznie;
    }

    public int getIloscZarazonychWirusowo() {
        return iloscZarazonychWirusowo;
    }

    public void setIloscZarazonychBakteryjnie(int iloscZarazonychBakteryjnie) {
        this.iloscZarazonychBakteryjnie = iloscZarazonychBakteryjnie;
    }

    public void setIloscZarazonychWirusowo(int iloscZarazonychWirusowo) {
        this.iloscZarazonychWirusowo = iloscZarazonychWirusowo;
    }

    public void setIloscZarazonychGrzybicznie(int iloscZarazonychGrzybicznie) {
        this.iloscZarazonychGrzybicznie = iloscZarazonychGrzybicznie;
    }

    List<Agent> Humans;
    //public int Humans1;
    List<Agent> aliveHumans;
    //int humansAlive;

    List<Agent> deadHumans;
    //int deadHumans

    public void killAgent (Agent Agent){
    Humans.remove(Agent);
    }

}
