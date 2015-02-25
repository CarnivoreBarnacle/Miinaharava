package miinaharava.kayttoliittyma;

import java.awt.*;
import javax.swing.*;
import miinaharava.ennatykset.Ennatys;

public class EnnatysIkkuna extends JFrame{
    
    public EnnatysIkkuna(){
        valmisteleIkkuna();
    }
    
    private void valmisteleIkkuna(){
        Container pane = getContentPane();
        GridLayout layout = new GridLayout(0,2);
        pane.setLayout(layout);
        
        luoKomponentit(pane);
        
        setTitle("Ennätykset");
        setSize(250, 400);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    private void luoKomponentit(Container pane){
        String[] ennatykset = new Ennatys().lueEnnatykset();
        
        for(String s:ennatykset){
            String[] jaettu = s.split(":");

            String tulos = jaettu[0] + ". " + jaettu[1];
            
            JTextField uusi = new JTextField(tulos);
            JTextField pisteet = new JTextField(jaettu[2]);            
            uusi.setEditable(false);
            pisteet.setEditable(false);
            pane.add(uusi);
            pane.add(pisteet);
        }
    }
}
