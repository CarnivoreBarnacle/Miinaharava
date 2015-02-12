package miinaharava.main;

import java.awt.EventQueue;
import miinaharava.kayttoliittyma.Kayttoliittyma;
import miinaharava.logiikka.Miinaharava;

public class Main {
    
    public static void main(String[] args){
        final Miinaharava m = new Miinaharava(20, 20, 50);
        
        //m.getRuudukko().asetaNakyvaJaKetjureaktio(0, 0);
        //m.getRuudukko().asetaNakyvaJaKetjureaktio(19, 19);
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Kayttoliittyma kl = new Kayttoliittyma(m);
                kl.setVisible(true);
            }
        });
    }
}
