
package miinaharava.kayttoliittyma;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.*;
import miinaharava.logiikka.Miinaharava;

public class Kayttoliittyma extends JFrame{
    private Miinaharava miinaharava;
    private JTextArea[][] graafinenRuudukko;

    
    public Kayttoliittyma(Miinaharava m){
        this.miinaharava = m;
        this.graafinenRuudukko = new JTextArea[this.miinaharava.getRuudukko().getKorkeus()][this.miinaharava.getRuudukko().getLeveys()];
        
        valmisteleKayttoliityma();
    }
    
    private void valmisteleKayttoliityma(){             
        Container pane = getContentPane();
        pane.setBackground(Color.LIGHT_GRAY);                             
        
        luoRuudukko(pane);
        
        pack();
        
        setTitle("Miinaharava");
        setSize(this.miinaharava.getRuudukko().getKorkeus()*20, this.miinaharava.getRuudukko().getLeveys()*20);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    
    private void luoRuudukko(Container pane){
        GridLayout ruudukko = new GridLayout(this.miinaharava.getRuudukko().getKorkeus(), this.miinaharava.getRuudukko().getLeveys());
        pane.setLayout(ruudukko);
        
        for(int i=0; i<this.miinaharava.getRuudukko().getKorkeus(); i++){
            for(int j=0; j<this.miinaharava.getRuudukko().getLeveys(); j++){
                this.graafinenRuudukko[i][j] = kirjoitaRuutu(i, j);
                this.graafinenRuudukko[i][j].addMouseListener(new HiiriKuuntelija(this, i, j));
                pane.add(this.graafinenRuudukko[i][j]);
            }
        }       
    }
    
    
    private JTextArea kirjoitaRuutu(int x, int y){
        JTextArea a = new JTextArea();
        a.setEditable(false);
        
        //Piilotettu ruutu
        if(!this.miinaharava.getRuudukko().onkoNakyva(x, y)){
            a.setBackground(Color.DARK_GRAY);
            a.setBorder(BorderFactory.createLineBorder(Color.black));
            
            if(this.miinaharava.getRuudukko().onkoMerkitty(x, y)){
                a.setForeground(Color.blue);
                a.setText("?");
            }
            
            return a;
        }
        
        
        a.setBackground(Color.LIGHT_GRAY);
        a.setBorder(BorderFactory.createLineBorder(Color.black));
        if(this.miinaharava.getRuudukko().onkoMiina(x, y)){
            a.setForeground(Color.red);
            a.setText("X");
        } else{
            if(this.miinaharava.getRuudukko().getViereisetMiinat(x, y) == 0){
                a.setText(" ");
            } else{
                a.setForeground(Color.green);
                a.setText("" + this.miinaharava.getRuudukko().getViereisetMiinat(x, y));
            }
        }
        
        return a;
    }    
        
    public void paivitaRuudukko(){
        for(int i=0; i<this.miinaharava.getRuudukko().getKorkeus(); i++){
            for(int j=0; j<this.miinaharava.getRuudukko().getLeveys(); j++){
                paivitaRuutu(i, j);
            }
        }
    }
    
    private void paivitaRuutu(int x, int y){
        JTextArea a = this.graafinenRuudukko[x][y];
        a.setEditable(false);
        
        //Piilotettu ruutu
        if(!this.miinaharava.getRuudukko().onkoNakyva(x, y)){
            a.setBackground(Color.DARK_GRAY);
            a.setBorder(BorderFactory.createLineBorder(Color.black));
            
            if(this.miinaharava.getRuudukko().onkoMerkitty(x, y)){
                a.setForeground(Color.green);
                a.setText("?");
            }
            
            return;
        }
        
        
        a.setBackground(Color.LIGHT_GRAY);
        a.setBorder(BorderFactory.createLineBorder(Color.black));
        if(this.miinaharava.getRuudukko().onkoMiina(x, y)){
            a.setForeground(Color.red);
            a.setText("X");
        } else{
            if(this.miinaharava.getRuudukko().getViereisetMiinat(x, y) == 0){
                a.setText(" ");
            } else{
                a.setForeground(Color.blue);
                a.setText("" + this.miinaharava.getRuudukko().getViereisetMiinat(x, y));
            }
        }
    }
    
    public void ruutuKlikattuVasen(int x, int y){
        this.miinaharava.getRuudukko().asetaNakyvaJaKetjureaktio(x, y);
    }
    
    public void ruutuKlikattuOikea(int x, int y){
        this.miinaharava.getRuudukko().merkitse(x, y, !this.miinaharava.getRuudukko().onkoMerkitty(x, y));
    }
}
