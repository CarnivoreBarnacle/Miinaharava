package miinaharava.main;

import java.awt.EventQueue;
import miinaharava.kayttoliittyma.Kayttoliittyma;
import miinaharava.logiikka.Miinaharava;

public class Main {
    
    public static void main(String[] args){
        final Miinaharava m = new Miinaharava("default", 20, 50);

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Kayttoliittyma kl = new Kayttoliittyma(m);
                kl.setVisible(true);
            }
        });
    }
}
