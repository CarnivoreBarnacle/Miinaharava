package miinaharava.kayttoliittyma;

import java.util.TimerTask;

public class AjastinTehtava extends TimerTask{
    private final Kayttoliittyma kl;
    
    public AjastinTehtava(Kayttoliittyma kl){
        this.kl = kl;
    }
    
    @Override
    public void run() {
        this.kl.getMiinaharava().kasvataAikaa();
        this.kl.paivita();
    }   
}
