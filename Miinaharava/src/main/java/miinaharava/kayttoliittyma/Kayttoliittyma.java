
package miinaharava.kayttoliittyma;

import java.awt.*;
import javax.swing.*;
import miinaharava.logiikka.Miinaharava;

public class Kayttoliittyma extends JFrame{
    private Miinaharava miinaharava;
    private final HiiriKuuntelija hk;
    private java.util.Timer t;
    private int koko;
    private int miinoja;
    
    public Kayttoliittyma(Miinaharava m){
        this.miinaharava = m;
        this.hk = new HiiriKuuntelija(this);
        this.koko = m.getRuudukko().getKoko();
        this.miinoja = m.getMiinoja();      
        this.t = new java.util.Timer();
        
        valmisteleKayttoliityma();
        kaynnistaAjastin();
    }
    
    private void kaynnistaAjastin(){       
        this.t = new java.util.Timer();
        this.t.scheduleAtFixedRate(new AjastinTehtava(this), 1000, 1000);
    }
    
    private void pysaytaAjastin(){
        this.t.cancel();
        this.t.purge();
    }
    
    private void valmisteleKayttoliityma(){             
        Container pane = getContentPane();

        Valikko valikko = new Valikko(this);
        setJMenuBar(valikko);
        
        pane.add(new PiirtoAlusta(this.getMiinaharava()));
        pane.addMouseListener(this.hk);
        
        pack();
        
        setTitle("Miinaharava");
        setSize((this.miinaharava.getRuudukko().getKoko()*20)+50, (this.miinaharava.getRuudukko().getKoko()*20)+80);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

       
    public void paivita(){   
        repaint();
    }
    
    
    public void ruutuKlikattuVasen(int x, int y){           
        this.miinaharava.getRuudukko().asetaNakyvaJaKetjureaktio(x, y);
        paivita();
        
        if(this.miinaharava.getRuudukko().onkoMiina(x, y)){
            this.miinaharava.loppu();
            peliLoppu();
        }
        
        if(this.miinaharava.tarkastaVoitto()){
            peliLoppu();
        }
    }
    
    public void ruutuKlikattuOikea(int x, int y){                
        this.miinaharava.getRuudukko().merkitse(x, y, !this.miinaharava.getRuudukko().onkoMerkitty(x, y));
        paivita();
        
        if(this.miinaharava.tarkastaVoitto()){
            peliLoppu();
        }
    }
    
    public void uusiPeli(){
        peliLoppu();
        
        kaynnistaAjastin();
        
        Container pane = getContentPane();
        pane.addMouseListener(this.hk);
        
        this.miinaharava = new Miinaharava(this.koko, this.miinoja);
        
        setSize((this.miinaharava.getRuudukko().getKoko()*20)+50, (this.miinaharava.getRuudukko().getKoko()*20)+80);

        pane.removeAll();
        pane.add(new PiirtoAlusta(this.miinaharava));
        
        revalidate();
    }
    
    public Miinaharava getMiinaharava(){
        return this.miinaharava;
    }
    
    public void tallennaAsetukset(int koko, int miinoja){
        this.koko = koko;
        this.miinoja = miinoja;
    }
    
    public void peliLoppu(){
        pysaytaAjastin();
        Container pane = getContentPane();
        pane.removeMouseListener(this.hk);
    }
}
