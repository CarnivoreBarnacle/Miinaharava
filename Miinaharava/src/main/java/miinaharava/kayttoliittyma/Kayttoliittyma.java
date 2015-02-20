
package miinaharava.kayttoliittyma;

import java.awt.*;
import javax.swing.*;
import miinaharava.logiikka.Miinaharava;

public class Kayttoliittyma extends JFrame{
    private Miinaharava miinaharava;
    private int koko;
    private int miinoja;
    
    public Kayttoliittyma(Miinaharava m){
        this.miinaharava = m;
        this.koko = m.getRuudukko().getKoko();
        this.miinoja = m.getMiinoja();
        
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
    
    public void uusiPeli(){
        this.miinaharava = new Miinaharava(this.koko, this.miinoja);
        
        setSize((this.miinaharava.getRuudukko().getKoko()*20)+50, (this.miinaharava.getRuudukko().getKoko()*20)+80);
        
        Container pane = this.getContentPane();
        pane.removeAll();
        pane.add(new PiirtoAlusta(this.miinaharava));
        
        revalidate();
    }
    
    public Miinaharava getMiinaharava(){
        return this.miinaharava;
    }
    
    public void asetukset(int koko, int miinoja){
        this.koko = koko;
        this.miinoja = miinoja;
    }
}
