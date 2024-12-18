import Choroba.Choroba;
import Choroba.Grzybicza;
import Human.Agent;

import javax.swing.JPanel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Rysowanie extends JPanel {


    ArrayList<Choroba> ch = new ArrayList<Choroba>();
    public void DodajChorobe(Choroba choroba)
    {
        ch.add(choroba);
    }
    ArrayList<Agent> ag = new ArrayList<Agent>();

    public void DodajAgenta(Agent agent)
    {
        ag.add(agent);
    }

    public void paintComponent(Graphics gr)
    {
        super.paintComponent(gr);
        gr.setColor(Color.DARK_GRAY);
        gr.fillRect(0,0,Swiat.x+10,Swiat.y+10);





        //wydruk Człowieczka
        for(int i=0;i<ag.size();i++)
        {
            ag.get(i).Wydruk(gr);
            if(pierwszyZarazony==true && i==0)
            {   ag.get(i).setGrzyb(true);
                ag.get(i).setCzasDoPelnegoWyzdrowienia(ch.get(2).getCzasInkubacji());
            }
            else if(pierwszyZarazony==true && i==1)
            {
                ag.get(i).setBakteria(true);
                ag.get(i).setCzasDoPelnegoWyzdrowienia(ch.get(1).getCzasInkubacji());
            }
            else if(pierwszyZarazony==true && i==2)
            {
                ag.get(i).setWirus(true);
                pierwszyZarazony=false;
                ag.get(i).setCzasDoPelnegoWyzdrowienia(ch.get(0).getCzasInkubacji());
            }




            if(ag.get(i).getGrzyb()==true||ag.get(i).getWirus()==true||ag.get(i).getBakteria()==true)
            {
                ag.get(i).WydrukZarazony(gr);
            }
        }
    }
boolean pierwszyZarazony = true;

   public void ruch()
    {
        for(int i=0;i<ag.size();i++)
        { Agent a = ag.get(i);






            int px1;
            int py1;
            int py2=a.getY();
            int px2=a.getX();
            int odlegloscX;
            int odlegloscY;

            for(int j=0;j<=i;j++) {
                px1=ag.get(j).getX();
                py1=ag.get(j).getY();

                odlegloscX=px1-px2;
                odlegloscY=py1-py2;


                if((odlegloscX<=10 && odlegloscX>=(-10)) &&(odlegloscY>=(-10)&& odlegloscY<=10)) {

                    Random r = new Random();
                    int szansaNaZarazenie = r.nextInt(100);


                    if (ag.get(j).getGrzyb() == true && a.getGrzyb() == false && szansaNaZarazenie>=a.getSzanseNaZarazenie()) {
                        ag.get(i).setCzasDoPelnegoWyzdrowienia(ch.get(2).getCzasInkubacji());
                        ag.get(i).setGrzyb(true);
                        Swiat.zarazeniG++;
                    }else if (a.getGrzyb() == true && ag.get(j).getGrzyb() == false&& szansaNaZarazenie>=ag.get(j).getSzanseNaZarazenie()) {
                        ag.get(j).setCzasDoPelnegoWyzdrowienia(ch.get(2).getCzasInkubacji());
                        ag.get(j).setGrzyb(true);
                        Swiat.zarazeniG++;
                    }
                    int szansaNaZarazenieW = r.nextInt(100);
                    if (ag.get(j).getWirus() == true && a.getWirus() == false&& szansaNaZarazenieW>=a.getSzanseNaZarazenie()) {
                        ag.get(i).setCzasDoPelnegoWyzdrowienia(ch.get(0).getCzasInkubacji());
                        ag.get(i).setWirus(true);
                        Swiat.zarazeniW++;
                    }else if (a.getWirus() == true && ag.get(j).getWirus() == false&& szansaNaZarazenieW>=ag.get(j).getSzanseNaZarazenie()) {
                        ag.get(j).setCzasDoPelnegoWyzdrowienia(ch.get(0).getCzasInkubacji());
                        ag.get(j).setWirus(true);
                        Swiat.zarazeniW++;
                    }
                    int szansaNaZarazenieB = r.nextInt(100);
                    if (ag.get(j).getBakteria() == true && a.getBakteria() == false&& szansaNaZarazenieB>=a.getSzanseNaZarazenie()) {
                        ag.get(i).setCzasDoPelnegoWyzdrowienia(ch.get(1).getCzasInkubacji());
                        ag.get(i).setBakteria(true);
                        Swiat.zarazeniB++;
                    }else if (a.getBakteria() == true && ag.get(j).getBakteria() == false&& szansaNaZarazenieB>=ag.get(j).getSzanseNaZarazenie()) {
                        ag.get(j).setCzasDoPelnegoWyzdrowienia(ch.get(1).getCzasInkubacji());
                        ag.get(j).setBakteria(true);
                        Swiat.zarazeniB++;
                    }




                }


            }





            if(a.getCzasDoPelnegoWyzdrowienia()==0 && a.getGrzyb()==true)//Wyzdrowienie po chorobir grzybiczniej
            {
                ag.get(i).setSzanseNaZarazenie(a.getSzanseNaZarazenie()+ch.get(2).getOdpornoscPoPrzechorowaniu());
                ag.get(i).setGrzyb(false);
                Swiat.zarazeniG--;

            }else if(a.getCzasDoPelnegoWyzdrowienia()>0 && a.getGrzyb()==true )
            {
                ag.get(i).setCzasDoPelnegoWyzdrowienia(a.getCzasDoPelnegoWyzdrowienia()-1);
                ag.get(i).setHealth(a.getHealth()- ch.get(2).getSmiertelnosc());
            }

            if (a.getCzasDoPelnegoWyzdrowienia()==0 && a.getBakteria()==true) //Wyzdrowienie po chorobir bakteryjnej
            {
                ag.get(i).setSzanseNaZarazenie(a.getSzanseNaZarazenie()+ch.get(1).getOdpornoscPoPrzechorowaniu());
                ag.get(i).setBakteria(false);
                Swiat.zarazeniB--;
            }else if(a.getCzasDoPelnegoWyzdrowienia()>0 && a.getBakteria()==true)
            {
                ag.get(i).setCzasDoPelnegoWyzdrowienia(a.getCzasDoPelnegoWyzdrowienia()-1);
                ag.get(i).setHealth(a.getHealth()- ch.get(1).getSmiertelnosc());
            }

            if (a.getCzasDoPelnegoWyzdrowienia()==0 && a.getWirus()==true)//Wyzdrowienie po chorobir wirusowej
            {
                ag.get(i).setSzanseNaZarazenie(a.getSzanseNaZarazenie()+ch.get(0).getOdpornoscPoPrzechorowaniu());
                ag.get(i).setWirus(false);
                Swiat.zarazeniW--;
            }else if(a.getCzasDoPelnegoWyzdrowienia()>0 && a.getWirus()==true )
            {
                ag.get(i).setCzasDoPelnegoWyzdrowienia(a.getCzasDoPelnegoWyzdrowienia()-1);
                ag.get(i).setHealth(a.getHealth()- ch.get(0).getSmiertelnosc());
            }

            if(a.getCzasDoPelnegoWyzdrowienia()==0  && 0<a.getHealth() && a.getHealth()>a.getMaxZdrowie())//Odzyskiwanie sił po przebytych chorobach
            {
                a.setHealth(a.getHealth()+a.getOzyskiweZdrowia());
            }

            if(a.getSzanseNaZarazenie()>=100)
            {
                Swiat.pelnaOdpornosc++;

            }
            if(a.getSzanseNaZarazenie()>0)
            {

                System. out. println(i+".  "+a.getSzanseNaZarazenie());
            }

            if(a.getHealth()<=0)
            {
                if(ag.get(i).getBakteria()==true)
                    Swiat.zarazeniB--;
                if(ag.get(i).getWirus()==true)
                    Swiat.zarazeniW--;
                if(ag.get(i).getGrzyb()==true)
                    Swiat.zarazeniG--;
                ag.remove(i);//usuwa zmarłych z planszy
                Swiat.zmarli1++;
                Swiat.populacja1--;
            }


            Random rand = new Random();
            int losowa = rand.nextInt(5)+1;




                if (losowa == 4 && 0 < a.getHealth()) {
                    a.setY(a.getY() - a.getSpeed());// Poruszanie w dół
                    if ((a.getY() < 0)) {
                        a.setY(Swiat.y);

                    }
                } else if (losowa == 2 && 0 < a.getHealth()) {
                    a.setX(a.getX() + a.getSpeed());// Poruszanie do przodu
                    if (a.getX() > Swiat.x - 10 && 0 < a.getHealth()) {
                        a.setX(0);
                    }
                } else if (losowa == 3 && 0 < a.getHealth()) {
                    a.setY(a.getY() + a.getSpeed());// Poruszanie do góry
                    if (a.getY() > Swiat.y - 10 && 0 < a.getHealth()) {
                        a.setY(0);
                    }
                } else if (losowa == 5 && 0 < a.getHealth()) {
                    a.setX(a.getX() - a.getSpeed());// Poruszanie w tył
                    if (a.getX() < 0 && 0 < a.getHealth()) {
                        a.setX(Swiat.x);
                    }
                }




        }
    }






    public Rysowanie()
    {
        super();
    }

}
