package miinaharava.logiikka;

/*
 * Luokka sisältää ruuduista koostuvan taulukon, logiikka sen toiminnasta (esim. ruudun viereisten miinojen laskeminen) ja yksittäisten ruutujen
 * muokkaamiseen soveltuvia metodeja.
*/

public class Ruudukko {
    private final int koko;
    private final Ruutu[][] ruudukko;
    
    public Ruudukko(int koko){
        this.koko = koko;
        this.ruudukko = new Ruutu[koko][koko];
        valmisteleRuudukko();
    }
       
    /*
    * Täyttää ruudukon Ruutu-luokan ilmentymillä.
    */
    private void valmisteleRuudukko(){
        for(int i=0; i<this.koko; i++){
            for(int j=0; j<this.koko; j++){
                this.ruudukko[i][j] = new Ruutu();
            }
        }
    }
    
    public int getKoko(){
        return this.koko;
    }
    
    
    //Yksittäisiin ruutuihin liittyvät metodit
    
    
    /*
    * Tarkastaa ovatko x ja y koordinaatit sallituissa rajoissa. Tarkastetaan jokaisen ruutuja muokkaavan metodin alussa.
    */
    private boolean sallittu(int x, int y){
        return x>=0 && x<koko && y>=0 && y<koko;
    }
    
    public boolean onkoNakyva(int x, int y){
        if(!sallittu(x, y)){
            return false;
        }
        return this.ruudukko[x][y].onkoNakyva();
    }
    
    public boolean onkoMiina(int x, int y){
        if(!sallittu(x, y)){
            return false;
        }
        return this.ruudukko[x][y].onkoMiina();
    }
    
    public boolean onkoMerkitty(int x, int y){
        if(!sallittu(x, y)){
            return false;
        }
        return this.ruudukko[x][y].onkoMerkitty();
    }
    
    public int getViereisetMiinat(int x, int y){
        if(!sallittu(x, y)){
            return -1;
        }
        return this.ruudukko[x][y].getViereisetMiinat();
    }
    
    public void asetaMiina(int x, int y){
        if(!sallittu(x, y)){
            return;
        }
        this.ruudukko[x][y].asetaMiina();
    }
    
    
    public void merkitse(int x, int y, boolean m){
        if(!sallittu(x, y)){
            return;
        }
        this.ruudukko[x][y].merkitse(m);
    }
    
    /*
    * Laskee montako minaa ruudun viereisissä ruuduissa yhteensä on ja asettaa sen arvoksi kyseiselle ruudulle ruudun asetaViereisetMiinat-metodilla.
    * (Ottaa huomioon mahdollisesti ruudussa itsessään olevan miinan.)
    */
    private void laskeViereisetMiinat(int x, int y){
        if(!sallittu(x, y)){
            return;
        }
        int miinat = 0;
        
        //Ottaa huomioon mahdollisesti paikassa [x][y] olevan miinan
        for(int i=x-1; i<=x+1; i++){
            if(i<0 || i>this.koko-1){
                continue;
            }
            for(int j=y-1; j<=y+1; j++){
                if(j<0 || j>this.koko-1){
                    continue;
                }
                if(this.ruudukko[i][j].onkoMiina()){
                    miinat++;
                }
            }
        }
        
        this.ruudukko[x][y].asetaViereisetMiinat(miinat);
    }
    
    /*
    * Laskee jokaisen ruudukon ruudun viereist miinat käyttäen ruudukon yksityistä laskeViereisetMiinat(x, y) metodia.
    */
    public void laskeViereisetMiinat(){
        for(int i=0; i<this.koko; i++){
            for(int j=0; j<this.koko; j++){
                this.laskeViereisetMiinat(i, j);
            }
        }
    }
    
    public void asetaNakyva(int x, int y){
        if(!sallittu(x, y)){
            return;
        }
        this.ruudukko[x][y].asetaNakyva();
    }
    
    /*
    * Asettaa xy-koordinaateissa olevan ruudun näkyväksi ja mikäli kyseisen ruudun vieressä ei ole miinoja, kutsuu samaa metodia rekursiivisesti kaikille
    * sen viereisille ruuduille. 
    */
    public void asetaNakyvaJaKetjureaktio(int x, int y){
        if(!sallittu(x, y)){
            return;
        }
        
        asetaNakyva(x, y);
        
        if(this.ruudukko[x][y].getViereisetMiinat() != 0){
            return;
        }
        
        for(int i=x-1; i<=x+1; i++){
            if(i<0 || i>this.koko-1){
                continue;
            }
            for(int j=y-1; j<=y+1; j++){
                if(j<0 || j>this.koko-1){
                    continue;
                }
                if(!this.ruudukko[i][j].onkoNakyva()){
                    asetaNakyvaJaKetjureaktio(i, j);
                }
            }
        }
    }

}
