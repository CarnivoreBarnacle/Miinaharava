package miinaharava.logiikka;

import java.util.Random;

public class Miinaharava {
    private Ruudukko ruudukko;
    private int miinoja;
    private int pisteet;
    
    public Miinaharava(int korkeus, int leveys, int miinoja){
        if(miinoja > (korkeus*leveys)-10){
            miinoja = 0;
        }
        
        this.ruudukko = new Ruudukko(korkeus, leveys);
        this.miinoja = miinoja;
        this.pisteet = 0;
        this.arvoMiinat();
        this.ruudukko.laskeViereisetMiinat();
    }
    
    private void arvoMiinat(){
        Random r = new Random();
        for(int i=0; i<this.miinoja; i++){
            int x = r.nextInt(this.ruudukko.getKorkeus());
            int y = r.nextInt(this.ruudukko.getLeveys());
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
