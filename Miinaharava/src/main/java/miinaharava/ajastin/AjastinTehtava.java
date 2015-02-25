package miinaharava.ajastin;

import java.util.TimerTask;
import miinaharava.kayttoliittyma.Kayttoliittyma;

/*
*   Ajastimen käyttämä luokka, jonka tehtävä on päivittää miinaharavan aika-muuttujaa ja päivittää käyttöliittymää sekunnin välein.
*/
public class AjastinTehtava extends TimerTask{
    private final Kayttoliittyma kl;
    
    public AjastinTehtava(Kayttoliittyma kl){
        this.kl = kl;
    }
    
    /*
    *   Kasvattaa aikaa yhdellä, ja päivittää käyttöliittymän.
    *   @see miinaharava.logiikka.Miinaharava#kasvataAikaa()
    *   @see miinaharava.kayttoliittyma.Kayttoliittyma#paivita()
    */
    @Override
    public void run() {
        this.kl.getMiinaharava().kasvataAikaa();
        this.kl.paivita();
    }   
}
