package miinaharava.logiikka;

class Ruutu {
    private boolean nakyva;
    private boolean miina;
    private boolean merkitty;
    private int viereisetMiinat;
    
    Ruutu(){
        this.nakyva = false;
        this.miina = false;
        this.merkitty = false;
        this.viereisetMiinat = 0;
    }
    
    void asetaNakyva(){
        this.nakyva = true;
    }
    
    void asetaMiina(){
        this.miina = true;
    }
    
    void merkitse(boolean m){
        this.merkitty = m;
    }
    
    void asetaViereisetMiinat(int maara){
        this.viereisetMiinat = maara;
    }
    
    boolean onkoNakyva(){
        return this.nakyva;
    }
    
    boolean onkoMiina(){
        return this.miina;
    }
    
    boolean onkoMerkitty(){
        return this.merkitty;
    }
    
    int getViereisetMiinat(){
        return this.viereisetMiinat;
    }
}
