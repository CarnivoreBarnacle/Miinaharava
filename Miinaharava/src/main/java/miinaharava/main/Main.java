package miinaharava.main;

import java.awt.EventQueue;
import miinaharava.kayttoliittyma.Kayttoliittyma;
import miinaharava.logiikka.Miinaharava;

public class Main {
    
    public static void main(String[] args){
        final Miinaharava m = new Miinaharava(50, 50, 100);
        
        //m.getRuudukko().asetaNakyvaJaKetjureaktio(22, 22);
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Kayttoliittyma kl = new Kayttoliittyma(m);
                kl.setVisible(true);
            }
        });
    }
}
