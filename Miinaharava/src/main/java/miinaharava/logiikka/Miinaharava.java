package miinaharava.logiikka;

import java.util.Random;
import miinaharava.ennatykset.Ennatys;


/*
*   Luokka sisältää yleisen pelilogiikan
*/
public class Miinaharava {
    private final Ruudukko ruudukko;
    private final int miinoja;
    private String nimi;
    private int pisteet;
    private int aika;
    private boolean loppu;
    
    /*
    *   Suorittaa myös miinojen arpomisen ja viereisten miinojen laskemisen.
    *   @see miinaharava.logiikka.Miinaharava#arvoMiinat()
    *   @see miinaharava.logiikka.Ruudukko#laskeViereisetMiinat()
    */
    public Miinaharava(String nimi, int koko, int miinoja){
        if(miinoja > (koko*koko)-10){
            miinoja = 0;
        }
        
        this.nimi = nimi;
        this.ruudukko = new Ruudukko(koko);
        this.miinoja = miinoja;
        this.pisteet = 0;
        this.aika = 0;
        this.arvoMiinat();
        this.ruudukko.laskeViereisetMiinat();
        this.loppu = false;      
    }
       
    /*
    *   Arpoo miinoja-muuttujan verran miinoja ruudukkoon, käyttäen ruudukon onkoMiina- ja asetaMiina- metodeja.
    *   @see miinaharava.logiikka.Ruudukko#onkoMiina(int, int)
    *   @see miinaharava.logiikka.Ruudukko#arvoMiina(int, int)
    */
    private void arvoMiinat(){
        Random r = new Random();
        for(int i=0; i<this.miinoja; i++){
            int x = r.nextInt(this.ruudukko.getKoko());
            int y = r.nextInt(this.ruudukko.getKoko());
            if(this.ruudukko.onkoMiina(x, y)){
                i--;
            } else{
                this.ruudukko.asetaMiina(x, y);
            }
        }
    }
    
    public Ruudukko getRuudukko(){
        return this.ruudukko;
    }
    
    public int getMiinoja(){
        return this.miinoja;
    }
    
    public int getPisteet(){
        return this.pisteet;
    }
    
    /*
    *   Tarkastaa onko kaikki ruudut, joissa on miina merkittyjä ja kaikki ruudut joissa ei ole miinaa näkyviä.
    *   Mikäli näin on, suorittaa myös pisteidenlaskennan ja (mahdollisesti) tallentaa pisteet ennätyksiin ja asettaa miinaharavan loppu-arvon todeksi.
    *   @return Palauttaa onko peli voitettu vai ei
    *   @see miinaharava.logiikka.Miinaharava#laskePisteet()
    *   @see miinaharava.ennatykset.Ennatys#tallennaEnnatys(String, int)
    */
    public boolean tarkastaVoitto(){
        for(int i=0; i<this.ruudukko.getKoko(); i++){
            for(int j=0; j<this.ruudukko.getKoko(); j++){
                if((this.ruudukko.onkoMiina(i, j) && !this.ruudukko.onkoMerkitty(i, j)) || (!this.ruudukko.onkoMiina(i, j) && !this.ruudukko.onkoNakyva(i, j))){
                    return false;
                }
            }
        }
                
        laskePisteet();
        if(!this.loppu){
            new Ennatys().tallennaEnnatys(this.nimi, this.pisteet);
        }
        this.loppu = true;
        return true;
    }
    
    public void loppu(){
        this.loppu = true;
    }
    
    public boolean onkoLoppu(){
        return this.loppu;
    }
    
    public void kasvataAikaa(){
        this.aika++;
    }
    
    public int getAika(){
        return this.aika;
    }
    
    /*
    *   Laskee pelaajan pisteet kaavalla: (miinojen määrä)*1000 - (tyhjien ruutujen määrä)*100 - (aika)*10.
    *   Mikäli pisteet menenvät negatiivisiksi, ne asetetaan nollaan sen sijaan.
    */
    private void laskePisteet(){
        int ruutujenMaara = this.ruudukko.getKoko()*this.ruudukko.getKoko();
        int tyhjienMaara = ruutujenMaara - this.miinoja;
        
        this.pisteet =  ((this.miinoja*10000)-(tyhjienMaara*100)) - (this.aika*10);
        if(this.pisteet < 0){
            this.pisteet = 0;
        }
    }
    
    public void asetaNimi(String nimi){
        this.nimi = nimi;
    }
    
    public String getNimi(){
        return this.nimi;
    }
}
