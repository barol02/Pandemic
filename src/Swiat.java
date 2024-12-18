import Choroba.Choroba;
import Human.AgentDorosly;
import Human.AgentDziecko;
import Human.AgentStary;
import Simulation.Statystyki;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Swiat implements ActionListener, Runnable{
    JFrame farme = new JFrame("Symulacja epidemi");
    Rysowanie rys = new Rysowanie();
    Statystyki statystyki= new Statystyki();
    JLabel populacja = new JLabel();
    JLabel zmarli = new JLabel();
    JLabel czas1 = new JLabel();
    JLabel pelnaOdpornosc1 = new JLabel();
    JLabel zarazeniW1 = new JLabel();
    JLabel zarazeniB1 = new JLabel();
    JLabel zarazeniG1 = new JLabel();
    static int populacja1;
    int czas=0;
    static int zmarli1;
    static int zarazeniG=1;
    static int pelnaOdpornosc=0;
    static int zarazeniW=1;
    static int zarazeniB=1;

    static int x =600;//Wielkość świata

   static int y=600;
   boolean running = false;
JButton start = new JButton("START");
JButton stop = new JButton("STOP");
Container s = new Container();
Container es = new Container();
    public Swiat()
    {
        Choroba chorobaW= new Choroba("Wirus",100,2,6);
        rys.DodajChorobe(chorobaW);
        Choroba chorobaB= new Choroba("Bakteria",300,6,12);
        rys.DodajChorobe(chorobaB);
        Choroba chorobaG= new Choroba("Brzybiczna",200,4,13);
        rys.DodajChorobe(chorobaG);


        farme.setSize(x,y);
        farme.setLayout(new BorderLayout());
        farme.add(rys, BorderLayout.CENTER);

        s.setLayout(new GridLayout(1,2));//guziki
        s.add(start);
        start.addActionListener(this);
        s.add(stop);
        stop.addActionListener(this);



        es.setLayout(new GridLayout(10,1));//Statystyki
        es.add(populacja);
        es.add(zmarli);
        es.add(zarazeniB1);
        es.add(zarazeniW1);
        es.add(zarazeniG1);
        es.add(czas1);
        es.add(pelnaOdpornosc1);



        farme.add(s, BorderLayout.SOUTH);
        farme.add(es, BorderLayout.EAST);
        farme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        farme.setVisible(true);

        Random rand = new Random();
        int losowaIloscDoroslych = rand.nextInt(50)+60;
        int losowaIloscDzieci = rand.nextInt(50)+40;
        int losowaIloscStarszych = rand.nextInt(50)+40;
        populacja1 = losowaIloscStarszych+losowaIloscDoroslych+losowaIloscDzieci;


        populacja.setText("  Ilosc ludzi: "+ populacja1);
        zmarli.setText("  Ilosc zmarłych ludzi: "+ zmarli1);
        czas1.setText("  Czas: "+ czas);
        zarazeniB1.setText("  Ilosc zarazonych ludzi: "+ zarazeniB);
        zarazeniW1.setText("  Ilosc zarazonych ludzi: "+ zarazeniW);
        zarazeniG1.setText("  Ilosc zarazonych ludzi: "+ zarazeniG);
        pelnaOdpornosc1.setText("  Osoby z pełną odpornoscia : "+ pelnaOdpornosc);



        for(int i=0;i<losowaIloscDzieci;i++)
        {Random r = new Random();
            int x1 = r.nextInt(Swiat.x);
            int y1 = r.nextInt(Swiat.y);
        AgentDziecko dziecko = new AgentDziecko(x1,y1);
        rys.DodajAgenta(dziecko);
        farme.repaint();
        }
        for(int i=0;i<losowaIloscDoroslych;i++)
        {
            Random r = new Random();
            int x1 = r.nextInt(Swiat.x);
            int y1 = r.nextInt(Swiat.y);
        AgentDorosly dorosly = new AgentDorosly(x1,y1);
        rys.DodajAgenta(dorosly);
        farme.repaint();
        }
        for(int i=0;i<losowaIloscStarszych;i++) {

            Random r = new Random();
            int x1 = r.nextInt(Swiat.x);
            int y1 = r.nextInt(Swiat.y);
            AgentStary stary = new AgentStary(x1,y1);
            rys.DodajAgenta(stary);
            farme.repaint();
        }
    }


    public static void main(String[] args) {    new Swiat();}

    @Override
    public void actionPerformed(ActionEvent event) {
if(event.getSource().equals(start))
{
    if(!running)
    {
        running=true;
        Thread t = new Thread(this);
                t.start();
    }
}if(event.getSource().equals(stop))
        {
            running = false;
        }
    }

    @Override
    public void run() {
        while(running)
        {
            rys.ruch();
            czas++;
            farme.repaint();
            //populacja1--;



            populacja.setText("  Ilosc ludzi: "+ populacja1);
            zmarli.setText("  Ilosc zmarłych : "+ zmarli1);
            czas1.setText("  Czas trwania : "+ czas);
            zarazeniB1.setText("  Ilosc zarazonych Bakteria : "+ zarazeniB);
            zarazeniW1.setText("  Ilosc zarazonych Wirusem : "+ zarazeniW);
            zarazeniG1.setText("  Ilosc zarazonych Grzybicznie : "+ zarazeniG);
            pelnaOdpornosc1.setText("  Osoby z pełną odpornoscia : "+ pelnaOdpornosc);
            pelnaOdpornosc=0;

            try
            {
                Thread.sleep(40);
            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }


}