
package miinaharava.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class RuudukkoTest {
    
    public RuudukkoTest() {
        
    }

    @Test
    public void luokanLuominen(){
        Ruudukko ruudukko = new Ruudukko(10, 10);
        assertTrue(ruudukko.getKorkeus() == 10);
        assertTrue(ruudukko.getLeveys() == 10);
        assertTrue(!ruudukko.onkoMiina(0, 0));
    }
    
    @Test
    public void setterienTestaus(){
        Ruudukko ruudukko = new Ruudukko(10, 10);
        
        ruudukko.asetaNakyva(5, 2);
        assertTrue(ruudukko.onkoNakyva(5, 2));
        ruudukko.asetaMiina(0, 0);
        assertTrue(ruudukko.onkoMiina(0, 0));
    }
    
    @Test
    public void virheellisetArvot(){
        Ruudukko ruudukko = new Ruudukko(10, 10);
        //Kokeillaan mahdottomiaArvoja
        ruudukko.asetaNakyva(-1, 2);
        ruudukko.asetaNakyva(10, 10);
        ruudukko.asetaNakyva(12, 0);
    }
    
    @Test
    public void miinojenLaskenta1(){
        Ruudukko ruudukko = new Ruudukko(10, 10);
        
        ruudukko.asetaMiina(0, 1);
        ruudukko.laskeViereisetMiinat(0, 0);
        assertTrue(ruudukko.getViereisetMiinat(0, 0) == 1);
    }
    
    @Test
    public void miinojenLaskenta2(){
        Ruudukko ruudukko = new Ruudukko(10, 10);
        
        ruudukko.asetaMiina(0, 1);
        ruudukko.asetaMiina(1, 0);
        ruudukko.laskeViereisetMiinat(0, 0);
        assertTrue(ruudukko.getViereisetMiinat(0, 0) == 2);
    }
    
    @Test
    public void miinojenLaskenta3(){
        Ruudukko ruudukko = new Ruudukko(10, 10);
        
        ruudukko.asetaMiina(1, 2);
        ruudukko.asetaMiina(1, 3);
        ruudukko.asetaMiina(1, 4);
        ruudukko.asetaMiina(2, 2);
        ruudukko.asetaMiina(2, 4);
        ruudukko.asetaMiina(3, 2);
        ruudukko.asetaMiina(3, 3);
        ruudukko.asetaMiina(3, 4);
        ruudukko.laskeViereisetMiinat(2, 3);
        assertTrue(ruudukko.getViereisetMiinat(2, 3) == 8);
    }
}
