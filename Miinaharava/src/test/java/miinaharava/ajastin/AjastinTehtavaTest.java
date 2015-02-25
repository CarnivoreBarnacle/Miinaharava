package miinaharava.ajastin;

import miinaharava.kayttoliittyma.Kayttoliittyma;
import miinaharava.logiikka.Miinaharava;
import static org.junit.Assert.*;
import org.junit.Test;

public class AjastinTehtavaTest {
    
    
    @Test
    public void testaaRun1(){
        Kayttoliittyma kl = new Kayttoliittyma(new Miinaharava("x", 10, 10));
        AjastinTehtava a = new AjastinTehtava(kl);
        
        assertTrue(kl.getMiinaharava().getAika() == 0);
        
        a.run();
        assertTrue(kl.getMiinaharava().getAika() == 1);
    }
    
    @Test
    public void testaaRun2(){
        Kayttoliittyma kl = new Kayttoliittyma(new Miinaharava("x", 10, 10));
        AjastinTehtava a = new AjastinTehtava(kl);
        
        assertTrue(kl.getMiinaharava().getAika() == 0);
        
        a.run();
        a.run();
        a.run();
        assertTrue(kl.getMiinaharava().getAika() == 3);
    }
}
