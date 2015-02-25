package miinaharava.kayttoliittyma;

import java.awt.EventQueue;
import java.awt.event.*;
import javax.swing.*;

/**
*   Luokka sisältää pelin pää-ikkunan menu-valikon.
*/
public class Valikko extends JMenuBar{
    private final Kayttoliittyma kl;
    
    public Valikko(Kayttoliittyma kl){
        this.kl = kl;
        valmisteleValikko();
    }
    
    private void valmisteleValikko(){
        JMenu m = new JMenu("Valikko"); 
        
        //Uusi Peli
        JMenuItem up = new JMenuItem("Uusi peli");
        up.setToolTipText("Aloita uusi peli");
        up.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                kl.uusiPeli();
            }
        });
        
        //Ennätykset
        JMenuItem en = new JMenuItem("Ennätykset");
        en.setToolTipText("Ennätykset");
        en.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        EnnatysIkkuna e = new EnnatysIkkuna();
                        e.setVisible(true);
                    }
                });
            }
        });
        
        //Asetukset
        JMenuItem as = new JMenuItem("Asetukset");
        as.setToolTipText("Asetukset");
        as.addActionListener(new ActionListener() {
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
        JMenuItem lo = new JMenuItem("Lopeta");
        lo.setToolTipText("Sulje peli");
        lo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });
        
        m.add(up);
        m.add(en);
        m.add(as);
        m.add(lo);
        
        this.add(m);
    }
    
}
