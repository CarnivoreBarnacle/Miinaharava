package miinaharava.kayttoliittyma;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import miinaharava.logiikka.Miinaharava;

public class Asetukset extends JFrame{
    private Kayttoliittyma kl;
    
    public Asetukset(Kayttoliittyma kl){
        this.kl = kl;
        
        valmisteleAsetukset();
    }
    
    private void valmisteleAsetukset(){        
        Container pane = getContentPane();
        
        GridLayout layout = new GridLayout(5,2);
        pane.setLayout(layout);
        
        luoKomponentit(pane);
        
        setTitle("Asetukset");
        setSize(300, 300);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    private void luoKomponentit(Container pane){
        JTextField n = new JTextField("Nimi:");
        n.setEditable(false);
        final JTextField nimi = new JTextField();
        nimi.setText(this.kl.getMiinaharava().getNimi());
        nimi.setToolTipText("nimi jota käytetään ennätyksiä tallennettaessa");
        
        JTextField k = new JTextField("Koko:");
        k.setEditable(false);
        final JTextField koko = new JTextField();
        koko.setText("" + this.kl.getMiinaharava().getRuudukko().getKoko());
        koko.setToolTipText("10-50");
        
        
        JTextField m = new JTextField("Miinoja:");
        m.setEditable(false);
        final JTextField miinoja = new JTextField();
        miinoja.setText("" + this.kl.getMiinaharava().getMiinoja());
        miinoja.setToolTipText("10-puolet ruutujen määrästä");
        
        
        final JTextField info = new JTextField();
        info.setEditable(false);
        
        
        pane.add(n);
        pane.add(nimi);
        
        pane.add(k);        
        pane.add(koko);

        pane.add(m);
        pane.add(miinoja);

        
        JButton ok = new JButton("OK");
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                String nimiI = nimi.getText();
                int kokoI = Integer.parseInt(koko.getText());
                int miinojaI = Integer.parseInt(miinoja.getText());
                
                if(nimiI.equals("")){
                    info.setText("Nimi ei voi olla tyhjä.");
                    return;
                } else if(nimiI.length() > 12){
                    info.setText("Nimi voi olla korkeintaan 12 merkkiä pitkä.");
                    return;
                }
                
                if(kokoI < 10 || kokoI > 50){
                    info.setText("Koon oltava 10-50");
                    return;
                } else if(miinojaI < 10 || miinojaI > (kokoI*kokoI)/2){
                    info.setText("Miinoja oltava 10-" + ((Integer.parseInt(koko.getText())*Integer.parseInt(koko.getText()))/2));
                    return;
                } else{
                    info.setText("");
                }
                
                kl.tallennaAsetukset(nimiI, kokoI, miinojaI);
                kl.uusiPeli();
                dispose();
            }
        });
                
        pane.add(ok);
        
        pane.add(info);
    }
}
