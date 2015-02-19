
package miinaharava.logiikka;

import org.junit.Test;
import static org.junit.Assert.*;

public class MiinaharavaTest {
    
    public MiinaharavaTest(){
        
    }
    
    @Test
    public void luonti1(){
        Miinaharava m = new Miinaharava(10, 1);
        
        assertTrue(testaaMontakoMinaa(m.getRuudukko()) == 1);
    }
    
    @Test
    public void luonti2(){
        Miinaharava m = new Miinaharava(10, 5);
        
        assertTrue(testaaMontakoMinaa(m.getRuudukko()) == 5);
    }
    
    @Test
    public void virheellinenLuonti(){
        Miinaharava m = new Miinaharava(5, 30);
        assertTrue(m.getMiinoja() == 0);
        assertTrue(testaaMontakoMinaa(m.getRuudukko()) == 0);
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
}
