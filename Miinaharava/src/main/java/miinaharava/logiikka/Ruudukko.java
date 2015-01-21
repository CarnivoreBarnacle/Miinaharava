package miinaharava.logiikka;

public class Ruudukko {
    private final int korkeus;
    private final int leveys;
    private final Ruutu[][] ruudukko;
    
    public Ruudukko(int korkeus, int leveys){
        this.korkeus = korkeus;
        this.leveys = leveys;
        this.ruudukko = new Ruutu[leveys][korkeus];
        valmisteleRuudukko();
    }
    
    private void valmisteleRuudukko(){
        for(int i=0; i<this.korkeus; i++){
            for(int j=0; j<this.leveys; j++){
                this.ruudukko[i][j] = new Ruutu();
            }
        }
    }
    
    public int getKorkeus(){
        return this.korkeus;
    }
    
    public int getLeveys(){
        return this.leveys;
    }
    
    
    
    //Yksittäisiin ruutuihin liittyvät metodit
    
    private boolean sallittu(int x, int y){
        if(x<0 || x>leveys-1 || y<0 || y>korkeus-1){
            return false;
        }
        return true;
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
    
    public void asetaNakyva(int x, int y){
        if(!sallittu(x, y)){
            return;
        }
        this.ruudukko[x][y].asetaNakyva();
    }
    
    public void merkitse(int x, int y, boolean m){
        if(!sallittu(x, y)){
            return;
        }
        this.ruudukko[x][y].merkitse(m);
    }
    
    public void laskeViereisetMiinat(int x, int y){
        if(!sallittu(x, y)){
            return;
        }
        int miinat = 0;
        
        //Ottaa huomioon mahdollisesti paikassa [x][y] olevan miinan
        for(int i=x-1; i<=x+1; i++){
            if(i<0 || i>this.korkeus-1){
                continue;
            }
            for(int j=y-1; j<=y+1; j++){
                if(j<0 || j>this.leveys-1){
                    continue;
                }
                if(this.ruudukko[i][j].onkoMiina()){
                    miinat++;
                }
            }
        }
        
        this.ruudukko[x][y].asetaViereisetMiinat(miinat);
    }
}
