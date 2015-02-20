package miinaharava.kayttoliittyma;

import java.awt.EventQueue;
import java.awt.event.*;
import javax.swing.*;

public class Valikko extends JMenuBar{
    private Kayttoliittyma kl;
    
    public Valikko(Kayttoliittyma kl){
        this.kl = kl;
        valmisteleValikko();
    }
    
    private void valmisteleValikko(){
        JMenu m = new JMenu("Valikko"); 
        
        //Uusi Peli
        JMenuItem mi1 = new JMenuItem("Uusi peli");
        mi1.setToolTipText("Aloita uusi peli");
        mi1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                kl.uusiPeli();
            }
        });
        
        //Asetukset
        JMenuItem mi3 = new JMenuItem("Asetukset");
        mi3.setToolTipText("Asetukset");
        mi3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        Asetukset a = new Asetukset(kl);
                        a.setVisible(true);
                    }
                });
            }
        });
        
        //Lopeta
        JMenuItem mi2 = new JMenuItem("Lopeta");
        mi2.setToolTipText("Sulje peli");
        mi2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });
        
        m.add(mi1);
        m.add(mi3);
        m.add(mi2);
        
        this.add(m);
    }
    
}
