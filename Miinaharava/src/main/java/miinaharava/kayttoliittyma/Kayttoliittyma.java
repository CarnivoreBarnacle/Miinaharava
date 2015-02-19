
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

        Valikko valikko = new Valikko(this);
        setJMenuBar(valikko);
        
        pane.add(new PiirtoAlusta(this.miinaharava));
        pane.addMouseListener(new HiiriKuuntelija(this));
        
        pack();
        
        setTitle("Miinaharava");
        setSize((this.miinaharava.getRuudukko().getKoko()*20)+50, (this.miinaharava.getRuudukko().getKoko()*20)+80);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

       
    private void paivitaRuudukko(){   
        repaint();
    }
    
    
    public void ruutuKlikattuVasen(int x, int y){
        this.miinaharava.getRuudukko().asetaNakyvaJaKetjureaktio(x, y);
        paivitaRuudukko();
    }
    
    public void ruutuKlikattuOikea(int x, int y){
        this.miinaharava.getRuudukko().merkitse(x, y, !this.miinaharava.getRuudukko().onkoMerkitty(x, y));
        paivitaRuudukko();
    }
    
    public void uusiPeli(int koko, int miinat){
        this.miinaharava = new Miinaharava(koko, miinat);
        
        setSize((this.miinaharava.getRuudukko().getKoko()*20)+50, (this.miinaharava.getRuudukko().getKoko()*20)+80);
        
        Container pane = this.getContentPane();
        pane.removeAll();
        pane.add(new PiirtoAlusta(this.miinaharava));
        
        revalidate();
    }
    
    public Miinaharava getMiinaharava(){
        return this.miinaharava;
    }
}
