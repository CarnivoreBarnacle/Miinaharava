package miinaharava.logiikka;

/*
 * Luokka sisältää yksittäisen ruudun tilan (esim. näkyvyys, onko siinä miina), sekä sen viereisten miinojen määrän.
 * Metodit yksinkertaisia get/set metodeja.
*/


public class Ruutu {
    private boolean nakyva;
    private boolean miina;
    private boolean merkitty;
    private int viereisetMiinat;
    
    public Ruutu(){
        this.nakyva = false;
        this.miina = false;
        this.merkitty = false;
        this.viereisetMiinat = 0;
    }
    
    
    public void asetaNakyva(){
        this.nakyva = true;
    }
    
    public void asetaMiina(){
        this.miina = true;
    }
    
    public void merkitse(boolean m){
        this.merkitty = m;
    }
    
    public void asetaViereisetMiinat(int maara){
        this.viereisetMiinat = maara;
    }
    
    public boolean onkoNakyva(){
        return this.nakyva;
    }
    
    public boolean onkoMiina(){
        return this.miina;
    }
    
    public boolean onkoMerkitty(){
        return this.merkitty;
    }
    
    public int getViereisetMiinat(){
        return this.viereisetMiinat;
    }
}
