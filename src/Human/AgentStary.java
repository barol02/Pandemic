package Human;

import java.awt.*;

public class AgentStary extends Agent {

    private static final int BasicHealth = 700;

        public AgentStary(int nowaPozycjaX, int nowaPozycjaY)
        {
            super(nowaPozycjaX, nowaPozycjaY);
            szybkoscPoruszania=3;

            typChoroby=null;
            health = 700;

            maxZdrowie=700;
            szybkoscOzyskiwaniaZdrowia=3;
            czasDoPelnegoWyzdrowienia=10;
            czyZarazonyWirusem=false;
            czyZarazonyGrzybem=false;
            czyZarazonyBakteria=false;
        }

        public void Wydruk(Graphics gr)
        {
            gr.setColor(Color.ORANGE);
            gr.fillRect(x,y,10,10);
        }

    public void WydrukZarazony(Graphics gr)
    {
//            gr.	setXORMode(Color.GREEN);
        gr.setColor(Color.GREEN);
            gr.fillRect(x,y,10,10);

    }
}
