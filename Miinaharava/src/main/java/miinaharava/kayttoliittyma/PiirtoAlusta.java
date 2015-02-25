package miinaharava.kayttoliittyma;

import java.awt.*;
import javax.swing.*;
import miinaharava.logiikka.Miinaharava;

/**
*   Luokan tehtävä on piirtää logiikan Ruudukko javan Graphics-kirjastoa käyttäen.
*/
public class PiirtoAlusta extends JPanel{
    private final Miinaharava miinaharava;
    
    public PiirtoAlusta(Miinaharava mh){
        this.miinaharava = mh;
    }
    
    private void piirraRuudukko(Graphics g){
        status(g);
        for(int i=0; i<this.miinaharava.getRuudukko().getKoko(); i++){
            for(int j=0; j<this.miinaharava.getRuudukko().getKoko(); j++){
                piirraRuutu(i, j, g);
            }
        }
        
    }
            
    private void piirraRuutu(int x, int y, Graphics g){
        if(!this.miinaharava.getRuudukko().onkoNakyva(x, y)){
            g.setColor(Color.BLACK);
            g.drawRect(20+(x*20), 20+(y*20), 20, 20);
            g.setColor(Color.DARK_GRAY);
            g.fillRect(20+(x*20)+1, 20+(y*20)+1, 19, 19);        
            if(this.miinaharava.getRuudukko().onkoMerkitty(x, y)){
                g.setColor(Color.GREEN);
                g.drawString("?", 25+(x*20), 35+(y*20));
            }
            
        }else{
            g.setColor(Color.BLACK);
            g.drawRect(20+(x*20), 20+(y*20), 20, 20);
            if(this.miinaharava.getRuudukko().onkoMiina(x, y)){
                g.setColor(Color.RED);
                g.fillRect(20+(x*20)+1, 20+(y*20)+1, 19, 19);
                g.setColor(Color.BLACK);
                g.drawString("X", 25+(x*20), 35+(y*20));
            }else if(this.miinaharava.getRuudukko().getViereisetMiinat(x, y) != 0){
                g.setColor(Color.LIGHT_GRAY);
                g.fillRect(20+(x*20)+1, 20+(y*20)+1, 19, 19);
                g.setColor(Color.BLUE);
                g.drawString("" + this.miinaharava.getRuudukko().getViereisetMiinat(x, y), 25+(x*20), 35+(y*20));
            }            
        }
    }
    
    private void status(Graphics g){
        if(this.miinaharava.tarkastaVoitto()){
            g.setColor(Color.BLUE);
            g.drawString("VOITIT PELIN", 15, 15);
            g.setColor(Color.BLACK);
            g.drawString("P: " + this.miinaharava.getPisteet(), 100, 15);
        } else if(this.miinaharava.onkoLoppu()){
            g.setColor(Color.RED);
            g.drawString("HÄVISIT PELIN", 15, 15);
        }
        
        g.setColor(Color.BLACK);
        g.drawString("" + this.miinaharava.getAika(), (this.miinaharava.getRuudukko().getKoko()*20)-20, 15);
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        super.setBackground(Color.LIGHT_GRAY);
        piirraRuudukko(g);
    }
}
