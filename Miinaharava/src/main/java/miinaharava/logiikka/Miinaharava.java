package miinaharava.logiikka;

import java.util.Random;
import java.util.Timer;

/*
 * Luokka sisältää yleisen pelilogiikan
*/

public class Miinaharava {
    private Ruudukko ruudukko;
    private int miinoja;
    private int pisteet;
    private int aika;
    private boolean loppu;
    
    public Miinaharava(int koko, int miinoja){
        if(miinoja > (koko*koko)-10){
            miinoja = 0;
        }
        
        this.ruudukko = new Ruudukko(koko);
        this.miinoja = miinoja;
        this.pisteet = 0;
        this.aika = 0;
        this.arvoMiinat();
        this.ruudukko.laskeViereisetMiinat();
        this.loppu = false;      
    }
       
    /*
    * Arpoo miinoja-muuttujan verran miinoja ruudukkoon
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
    
    
    public boolean tarkastaVoitto(){
        for(int i=0; i<this.ruudukko.getKoko(); i++){
            for(int j=0; j<this.ruudukko.getKoko(); j++){
                if((this.ruudukko.onkoMiina(i, j) && !this.ruudukko.onkoMerkitty(i, j)) || (!this.ruudukko.onkoMiina(i, j) && !this.ruudukko.onkoNakyva(i, j))){
                    return false;
                }
            }
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
}
