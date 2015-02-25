
package miinaharava.logiikka;

import org.junit.Test;
import static org.junit.Assert.*;

public class MiinaharavaTest {
    
    public MiinaharavaTest(){
        
    }
    
    @Test
    public void luonti1(){
        Miinaharava m = new Miinaharava("default", 10, 1);
        
        assertTrue(m.getNimi().equals("default"));
        assertTrue(testaaMontakoMinaa(m.getRuudukko()) == 1);
        assertTrue(onkoJollainViereisiaMiinoja(m.getRuudukko()));
    }
    
    @Test
    public void luonti2(){
        Miinaharava m = new Miinaharava("default", 10, 5);
        
        assertTrue(testaaMontakoMinaa(m.getRuudukko()) == 5);
        assertTrue(onkoJollainViereisiaMiinoja(m.getRuudukko()));
    }
    
    @Test
    public void virheellinenLuonti(){
        Miinaharava m = new Miinaharava("default", 5, 100);
        assertTrue(m.getMiinoja() == 0);
        assertTrue(testaaMontakoMinaa(m.getRuudukko()) == 0);
        assertTrue(!onkoJollainViereisiaMiinoja(m.getRuudukko()));
    }
    
    @Test
    public void voitonTarkastaminen1(){
        Miinaharava m = new Miinaharava("default", 10, 5);
        
        assertTrue(!m.tarkastaVoitto());
        assertTrue(!m.onkoLoppu());
    }
    
    @Test
    public void voitonTarkastaminen2(){
        Miinaharava m = new Miinaharava("default", 10, 5);
        
        ratkaiseMiinaharava(m.getRuudukko());
        
        assertTrue(m.tarkastaVoitto());
        assertTrue(m.onkoLoppu());
    }
    
    @Test
    public void pisteidenTarkastaminen1(){
        Miinaharava m = new Miinaharava("default", 10, 5);
        
        assertTrue(m.getPisteet() == 0);
    }
    
    @Test
    public void pisteidenTarkastaminen2(){
        Miinaharava m = new Miinaharava("default", 10, 10);
        
        ratkaiseMiinaharava(m.getRuudukko());
        m.tarkastaVoitto();
        
        assertTrue(m.getPisteet() == ((10*10000) - (90*100)));
    }
    
    @Test
    public void pisteidenTarkastaminen3(){
        Miinaharava m = new Miinaharava("default", 10, 10);
        
        ratkaiseMiinaharava(m.getRuudukko());
        m.kasvataAikaa();
        m.kasvataAikaa();
        m.tarkastaVoitto();
        
        assertTrue(m.getPisteet() == ((10*10000) - (90*100) - (2*10)));
    }
    
    @Test
    public void ajanTarkastaminen(){
        Miinaharava m = new Miinaharava("default", 10, 10);
        
        assertTrue(m.getAika() == 0);
        m.kasvataAikaa();
        m.kasvataAikaa();
        m.kasvataAikaa();
        assertTrue(m.getAika() == 3);
    }
    
    private void ratkaiseMiinaharava(Ruudukko r){
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                if(r.onkoMiina(i, j)){
                    r.merkitse(i, j, true);
                } else{
                    r.asetaNakyva(i, j);
                }
            }
        }
    }
    
    private int testaaMontakoMinaa(Ruudukko r){
        int miinoja = 0;
        
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                if(r.onkoMiina(i, j)){
                    miinoja++;
                }
            }
        }
        
        return miinoja;
    }
    
    private boolean onkoJollainViereisiaMiinoja(Ruudukko r){
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                if(r.getViereisetMiinat(i, j) > 0){
                    return true;
                }
            }
        }
        return false;
    }
}
