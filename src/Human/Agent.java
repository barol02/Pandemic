package Human;

import java.awt.*;

public class Agent {
    int x;
    int y;//pozycje
   protected int szanseNaZarazenie; //odpornosc - agent nabywa po przechorowaniu choroby (zakres od 1 do 100 % na zarazenie)
   int szybkoscOzyskiwaniaZdrowia;
   int maxZdrowie;
   protected int szybkoscPoruszania;
   protected int health;
   boolean czyZarazonyWirusem;
   boolean czyZarazonyGrzybem;
   boolean czyZarazonyBakteria;

   int czasDoPelnegoWyzdrowienia;


   String typChoroby;




   public Agent(int nowaPozycjaX, int nowaPozycjaY)
   {
       x= nowaPozycjaX;
       y= nowaPozycjaY;

   }
    public void WydrukZarazony(Graphics gr)
    {

    }

public void Wydruk(Graphics gr)
{

}

    public int getX()
{
    return x;
}
    public void setX(int nowyX)
{
    x= nowyX;
}
    public int getY()
    {
        return y;
    }
    public boolean getWirus()
    {
        return czyZarazonyWirusem;
    }
    public void setWirus(boolean wirus)
    {
        czyZarazonyWirusem=wirus;
    }

    public boolean getBakteria()
    {
        return czyZarazonyBakteria;
    }
    public void setBakteria(boolean bakt)
    {
        czyZarazonyBakteria=bakt;
    }

    public boolean getGrzyb()
    {
        return czyZarazonyGrzybem;
    }
    public void setGrzyb(boolean grzyb)
    {
         czyZarazonyGrzybem = grzyb;
    }
    public void setCzasDoPelnegoWyzdrowienia(int wyzdrowienie) { czasDoPelnegoWyzdrowienia=wyzdrowienie;}
    public int getCzasDoPelnegoWyzdrowienia()
{
    return czasDoPelnegoWyzdrowienia;
}
    public void setY(int nowyY)
    {
        y= nowyY;
    }

    public int getSpeed()
    {
        return szybkoscPoruszania;
    }

    public int getSzanseNaZarazenie() {return szanseNaZarazenie;}
    public void setSzanseNaZarazenie(int szanseNaZarazenie) {this.szanseNaZarazenie = szanseNaZarazenie;}
    public int getHealth()
    {
        return health;
    }

    public void setHealth(int h)
    {
        health =h;
    }
    public int getMaxZdrowie() { return maxZdrowie;}
    public int getOzyskiweZdrowia() {return szybkoscOzyskiwaniaZdrowia;}
}
