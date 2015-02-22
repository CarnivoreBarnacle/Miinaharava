package miinaharava.kayttoliittyma;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class HiiriKuuntelija implements MouseListener{
    private final Kayttoliittyma kl;
    
    public HiiriKuuntelija(Kayttoliittyma kl){
        this.kl = kl;
    }
        
    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1){
           kl.ruutuKlikattuVasen((e.getX()-20)/20, (e.getY()-20)/20);
        } else if(e.getButton() == MouseEvent.BUTTON3){
           kl.ruutuKlikattuOikea((e.getX()-20)/20, (e.getY()-20)/20);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
    
}
