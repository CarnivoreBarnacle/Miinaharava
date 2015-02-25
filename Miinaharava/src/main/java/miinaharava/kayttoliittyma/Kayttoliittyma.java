package miinaharava.kayttoliittyma;

import java.awt.*;
import javax.swing.*;
import miinaharava.ajastin.Ajastin;
import miinaharava.logiikka.Miinaharava;

public class Kayttoliittyma extends JFrame{
    private Miinaharava miinaharava;
    private final HiiriKuuntelija hk;
    private Ajastin ajastin;
    private int koko;
    private int miinoja;
    
    public Kayttoliittyma(Miinaharava m){
        this.miinaharava = m;
        this.hk = new HiiriKuuntelija(this);
        this.koko = m.getRuudukko().getKoko();
        this.miinoja = m.getMiinoja();      
               
        valmisteleKayttoliityma();
        kaynnistaAjastin();
    }
    
    private void kaynnistaAjastin(){
        this.ajastin = new Ajastin();
        this.ajastin.KaynnistaAjastin(this);
    }
    
    private void pysaytaAjastin(){
        this.ajastin.pysaytaAjastin();
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
                
        String edellinenNimi = this.miinaharava.getNimi();
        this.miinaharava = new Miinaharava(edellinenNimi, this.koko, this.miinoja);
        
        setSize((this.miinaharava.getRuudukko().getKoko()*20)+50, (this.miinaharava.getRuudukko().getKoko()*20)+80);

        pane.removeAll();
        pane.add(new PiirtoAlusta(this.miinaharava));
        
        revalidate();
    }
    
    public Miinaharava getMiinaharava(){
        return this.miinaharava;
    }
    
    public void tallennaAsetukset(String nimi, int koko, int miinoja){
        this.miinaharava.asetaNimi(nimi);
        this.koko = koko;
        this.miinoja = miinoja;
    }
    
    public void peliLoppu(){
        pysaytaAjastin();
        Container pane = getContentPane();
        pane.removeMouseListener(this.hk);
    }
}
