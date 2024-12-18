package Human;

import java.awt.*;

    public class AgentDorosly extends Agent {

        private static final int BasicHealth = 1000;

        public AgentDorosly(int nowaPozycjaX, int nowaPozycjaY)
        {
            super(nowaPozycjaX, nowaPozycjaY);
            szybkoscPoruszania=5;
            czasDoPelnegoWyzdrowienia=10;
            typChoroby=null;
            health = 1000;
            szybkoscOzyskiwaniaZdrowia=10;

            czasDoPelnegoWyzdrowienia=0;
            maxZdrowie=1000;
            czyZarazonyWirusem=false;
            czyZarazonyGrzybem=false;
            czyZarazonyBakteria=false;


        }

        public void Wydruk(Graphics gr)
        {
            gr.setColor(Color.RED);
           gr.fillRect(x,y,10,10);
            //gr.drawArc(x,y,10,10,1000,1000);
        }
        public void WydrukZarazony(Graphics gr)
        {
//            gr.	setXORMode(Color.GREEN);
            gr.setColor(Color.GREEN);
            gr.fillRect(x,y,10,10);

        }public void WydrukPelnaOdpornosc(Graphics gr)
        {
//            gr.	setXORMode(Color.GREEN);
            gr.setColor(Color.WHITE);
            gr.fillRect(x,y,10,10);

        }

    }


