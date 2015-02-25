package miinaharava.ajastin;

import miinaharava.kayttoliittyma.Kayttoliittyma;
import miinaharava.logiikka.Miinaharava;
import static org.junit.Assert.*;
import org.junit.Test;

public class AjastinTest {
    
    @Test
    public void testaaAjastin1(){
        Kayttoliittyma kl = new Kayttoliittyma(new Miinaharava("x", 10, 10));
        Ajastin a = new Ajastin();
        
        assertTrue(kl.getMiinaharava().getAika() == 0);
        
        a.kaynnistaAjastin(kl);
        
        try {
            Thread.sleep(1500);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        
        a.pysaytaAjastin();
        
        assertTrue(kl.getMiinaharava().getAika() >= 1 );
    }
    
    public void testaaAjastin2(){
        Kayttoliittyma kl = new Kayttoliittyma(new Miinaharava("x", 10, 10));
        Ajastin a = new Ajastin();
        
        assertTrue(kl.getMiinaharava().getAika() == 0);
        
        a.kaynnistaAjastin(kl);
        
        try {
            Thread.sleep(5500);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        
        a.pysaytaAjastin();
        
        assertTrue(kl.getMiinaharava().getAika() >= 5);
    }
}
