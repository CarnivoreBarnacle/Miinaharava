package miinaharava.kayttoliittyma;

import java.awt.*;
import javax.swing.*;

/**
*   Luokan tehtävä on luoda ikkuna jossa ilmoitetaan virheilmoitus.
*/
public class Virheilmoitus extends JFrame{
    
    
    public Virheilmoitus(String viesti){
        valmisteleIkkuna(viesti);
    }
    
    private void valmisteleIkkuna(String viesti){
        Container pane = getContentPane();
        
        JTextField v = new JTextField(viesti);
        v.setEditable(false);
        pane.add(v);
        
        setTitle("Virhe");
        setSize(400, 200);
        setResizable(false);
        setAlwaysOnTop(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
