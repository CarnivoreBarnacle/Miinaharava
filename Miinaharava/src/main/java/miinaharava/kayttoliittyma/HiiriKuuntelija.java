package miinaharava.kayttoliittyma;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
*   Luokka sisältää hiirikuuntelijan, joka ottaa vastaan pelaajan syötteen ja laittaa sen eteenpäin käyttöliittymälle.
*/
public class HiiriKuuntelija implements MouseListener{
    private final Kayttoliittyma kl;
    
    public HiiriKuuntelija(Kayttoliittyma kl){
        this.kl = kl;
    }
        
    @Override
    public void mouseClicked(MouseEvent e) {}
    
    /**
    *   Ilmoittaa käyttöliittymälle että ruutua on klikattu joko vasemmalla tai oikealla painikkeella.
    *   @see miinaharava.kayttoliittyma.Kayttoliittyma#ruutuKlikattuVasen(int, int)
    *   @see miinaharava.kayttoliittyma.Kayttoliittyma#ruutuKlikattuOikea(int, int)
    */
    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getX() < 20 || e.getY() < 20){
            return;
        }
        
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
