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
        
        JTextField k = new JTextField("Koko:");
        k.setEditable(false);
        final JTextField koko = new JTextField();
        koko.setText("" + this.kl.getMiinaharava().getRuudukko().getKoko());
        koko.setToolTipText("välillä 5-50");
        
        
        JTextField m = new JTextField("Miinoja:");
        m.setEditable(false);
        final JTextField miinoja = new JTextField();
        miinoja.setText("" + this.kl.getMiinaharava().getMiinoja());
        miinoja.setToolTipText("välillä 10-[ruutujen määrä]/2");
        
        
        final JTextField info = new JTextField();
        info.setEditable(false);
        
        
        pane.add(k);        
        pane.add(koko);

        pane.add(m);
        pane.add(miinoja);

        
        JButton ok = new JButton("OK");
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                int kokoI = Integer.parseInt(koko.getText());
                int miinojaI = Integer.parseInt(miinoja.getText());
                
                if(kokoI < 5 || kokoI > 50){
                    info.setText("Koon oltava välillä 5-50");
                    return;
                } else if(miinojaI < 10 || miinojaI > (kokoI*kokoI)/2){
                    info.setText("Miinoja oltava välillä 10-[ruutujen määrä]/2");
                    return;
                } else{
                    info.setText("");
                }
                
                kl.asetukset(kokoI, miinojaI);
                kl.uusiPeli();
                dispose();
            }
        });
                
        pane.add(ok);
        
        pane.add(info);
        
        setTitle("Asetukset");
        setSize(300, 300);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
