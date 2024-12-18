package Human;

import java.awt.*;

public class AgentDziecko extends Agent {

    private static final int BasicHealth = 900;

    public AgentDziecko(int nowaPozycjaX, int nowaPozycjaY)
    {
        super(nowaPozycjaX, nowaPozycjaY);
        szybkoscPoruszania=6;
        czasDoPelnegoWyzdrowienia=10;
        szybkoscOzyskiwaniaZdrowia=6;

        health = 900;

       czasDoPelnegoWyzdrowienia=0;
        maxZdrowie=900;
        czyZarazonyWirusem=false;
        czyZarazonyGrzybem=false;
        czyZarazonyBakteria=false;
    }


public void Wydruk(Graphics gr)
{
    gr.setColor(Color.MAGENTA);
    gr.fillRect(x,y,10,10);
}
    public void WydrukZarazony(Graphics gr)
    {
//            gr.	setXORMode(Color.GREEN);
        gr.setColor(Color.GREEN);
            gr.fillRect(x,y,10,10);

    }
}
