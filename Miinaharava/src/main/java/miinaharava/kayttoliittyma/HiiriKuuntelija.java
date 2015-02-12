package miinaharava.kayttoliittyma;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class HiiriKuuntelija implements MouseListener{
    private Kayttoliittyma kl;
    private int x;
    private int y;
    
    public HiiriKuuntelija(Kayttoliittyma kl, int x, int y){
        this.kl = kl;
        this.x = x;
        this.y = y;
    }
        
    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1){
           this.kl.ruutuKlikattuVasen(this.x, this.y);
           this.kl.paivitaRuudukko(); 
        } else if(e.getButton() == MouseEvent.BUTTON3){
           this.kl.ruutuKlikattuOikea(this.x, this.y);
           this.kl.paivitaRuudukko(); 
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
    
}
