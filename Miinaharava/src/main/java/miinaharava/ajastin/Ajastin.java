package miinaharava.ajastin;

import java.util.Timer;
import miinaharava.kayttoliittyma.Kayttoliittyma;

/**
 *   Luokan tehtävänä on luoda sekunnin välein kutsuttava AjastinTehtava ja pysayttaa se tarvittaessa.
*/
public class Ajastin extends Timer{
    
    /**
     *   Luo AjastinTehtavan ja scheduloi sen suoritettavaksi sekunnin välein.
     *   @param kl Käyttöliittymä jota päivitetään ja joka sisältää viitteen ajastintehtävän tarvitsemaan miinaharava-luokan ilmentymän
     *   @see miinaharava.ajastin.AjastinTehtava
    */
    public void kaynnistaAjastin(Kayttoliittyma kl){
        scheduleAtFixedRate(new AjastinTehtava(kl), 1000, 1000);
    }
    
    /**
     *   Poistaa kaikki ajastimelle scheduloidut ajastintehtävät.
    */
    public void pysaytaAjastin(){
        cancel();
        purge();
    }
}
