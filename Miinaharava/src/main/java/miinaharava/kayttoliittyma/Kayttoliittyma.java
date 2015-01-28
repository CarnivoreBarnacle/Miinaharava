
package miinaharava.kayttoliittyma;

import java.awt.*;
import javax.swing.*;
import miinaharava.logiikka.Miinaharava;

public class Kayttoliittyma extends JFrame{
    private Miinaharava miinaharava;
    
    public Kayttoliittyma(Miinaharava m){
        this.miinaharava = m;
        
        valmisteleKayttoliityma();
    }
    
    private void valmisteleKayttoliityma(){
            
        Container pane = getContentPane();
        GridLayout ruudukko = new GridLayout(this.miinaharava.getRuudukko().getKorkeus(), this.miinaharava.getRuudukko().getLeveys());
        pane.setLayout(ruudukko);
        
        for(int i=0; i<this.miinaharava.getRuudukko().getKorkeus(); i++){
            for(int j=0; j<this.miinaharava.getRuudukko().getLeveys(); j++){
                JTextArea a = new JTextArea();
                if(this.miinaharava.getRuudukko().onkoMiina(i, j)){
                    a.setText("X");
                } else{
                    a.setText("" + this.miinaharava.getRuudukko().getViereisetMiinat(i, j));
                }
                pane.add(a);
            }
        }
        
        
        pack();
        
        setTitle("Miinaharava");
        setSize(800, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    
}
