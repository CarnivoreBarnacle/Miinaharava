package miinaharava.main;

import java.awt.EventQueue;
import miinaharava.kayttoliittyma.Kayttoliittyma;
import miinaharava.logiikka.Miinaharava;

public class Main {
    
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Kayttoliittyma kl = new Kayttoliittyma(new Miinaharava(10, 10, 10));
                kl.setVisible(true);
            }
        });
    }
}
