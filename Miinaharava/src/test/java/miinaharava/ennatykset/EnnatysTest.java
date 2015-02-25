package miinaharava.ennatykset;

import static org.junit.Assert.*;
import org.junit.Test;

public class EnnatysTest {
    
    
    @Test
    public void ennatyksenTallentaminen1(){
        Ennatys e = new Ennatys();
        e.tallennaEnnatys("default0", 1000000);
        
        assertTrue(onkoEnnatyksissa(e, "default0", 1000000));
    }
    
    @Test
    public void ennatyksenTallentaminen2(){
        Ennatys e = new Ennatys();
        e.tallennaEnnatys("defaultX", 0);
        
        assertTrue(!onkoEnnatyksissa(e, "defaultX", 0));
    }
    
    private boolean onkoEnnatyksissa(Ennatys e, String nimi, int pisteet){
        for(String s:e.lueEnnatykset()){
            if(s.equals(nimi + ":" + pisteet)){
                return true;
            }
        }
        
        return false;
    }
}
