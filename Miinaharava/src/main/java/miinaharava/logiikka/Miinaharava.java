package miinaharava.logiikka;

import java.util.Random;

/*
 * Luokka sisältää yleisen pelilogiikan
*/

public class Miinaharava {
    private Ruudukko ruudukko;
    private int miinoja;
    private int pisteet;
    
    public Miinaharava(int koko, int miinoja){
        if(miinoja > (koko*koko)-10){
            miinoja = 0;
        }
        
        this.ruudukko = new Ruudukko(koko);
        this.miinoja = miinoja;
        this.pisteet = 0;
        this.arvoMiinat();
        this.ruudukko.laskeViereisetMiinat();
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
    
}
