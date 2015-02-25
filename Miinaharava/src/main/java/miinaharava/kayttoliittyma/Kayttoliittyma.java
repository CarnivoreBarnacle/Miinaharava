package miinaharava.kayttoliittyma;

import java.awt.*;
import javax.swing.*;
import miinaharava.ajastin.Ajastin;
import miinaharava.logiikka.Miinaharava;

/**
*   Luokka sisältää pelin pääkäyttöliittymän.
*/
public class Kayttoliittyma extends JFrame{
    private final HiiriKuuntelija hk;
    private Miinaharava miinaharava;
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
    
    /**
    *   Luo uuden ajastimen ja käynnistää sen.
    *   @see miinaharava.ajastin.Ajastin#kaynnistaAjastin(Kayttoliittyma)
    */
    private void kaynnistaAjastin(){
        this.ajastin = new Ajastin();
        this.ajastin.kaynnistaAjastin(this);
    }
    
    /**
    *   Pysayttaa ajastimen.
    *   @see miinaharava.ajastin.Ajastin#pysaytaAjastin()
    */
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

    /**
    *   Paivittaa ikkunan.
    */   
    public void paivita(){   
        repaint();
    }
    
    /**
    *   Asettaa parametrien koordiinaattien ruudun näkyväksi ja päivittää ikkunan. Lopettaa pelin mikäli kyseisessä ruudussa on miina.
    *   Tarkastaa myös onko pelaaja voittanut siirron jälkeen.
    *   @param x Ruudun x-koordinaatti
    *   @param y Ruudun y-koordinaatti
    *   @see miinaharava.logiikka.Ruudukko#asetaNakyvaJaKetjureaktio(int, int)
    *   @see miinaharava.kayttoliittyma.Kayttoliittyma#paivita()
    *   @see miinaharava.logiikka.Miinaharava#tarkastaVoitto()
    *   @see miinaharava.kayttoliittyma.Kayttoliittyma#peliLoppu()
    */
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
    
    /**
    *   Merkistee parametrien koordiinaattien ruudun ja päivittää ikkunan.
    *   Tarkastaa myös onko pelaaja voittanut siirron jälkeen.
    *   @param x Ruudun x-koordinaatti
    *   @param y Ruudun y-koordinaatti
    *   @see miinaharava.kayttoliittyma.Kayttoliittyma#paivita()
    *   @see miinaharava.logiikka.Miinaharava#tarkastaVoitto()
    *   @see miinaharava.kayttoliittyma.Kayttoliittyma#peliLoppu()
    */
    public void ruutuKlikattuOikea(int x, int y){                
        this.miinaharava.getRuudukko().merkitse(x, y, !this.miinaharava.getRuudukko().onkoMerkitty(x, y));
        paivita();
        
        if(this.miinaharava.tarkastaVoitto()){
            peliLoppu();
        }
    }
    
    /**
    *   Aloittaa uuden pelin.
    */
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
    
    /**
    *   Tallentaa parametreinä saadut asetukset.
    *   @param nimi Pelaajan nimi
    *   @param koko Ruudukon sivun pituus
    *   @param miinoja Miinojen määrä
    */
    public void tallennaAsetukset(String nimi, int koko, int miinoja){
        this.miinaharava.asetaNimi(nimi);
        this.koko = koko;
        this.miinoja = miinoja;
    }
    
    /**
    *   Lopettaa pelin; pysäyttää ajastimen ja deaktivoi hiirikuuntelijan.
    */
    public void peliLoppu(){
        pysaytaAjastin();
        Container pane = getContentPane();
        pane.removeMouseListener(this.hk);
    }
}
