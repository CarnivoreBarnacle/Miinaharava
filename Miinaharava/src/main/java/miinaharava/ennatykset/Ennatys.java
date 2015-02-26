package miinaharava.ennatykset;

import java.awt.EventQueue;
import java.io.File;
import java.io.FileWriter;
import java.util.*;
import miinaharava.kayttoliittyma.Virheilmoitus;


/**
*   Luokan tehtävä on käsitellä tiedostoa joka sisältää ennätykset.
*/
public class Ennatys {
    private final String[] rivit;
    
    public Ennatys(){
        this.rivit = new String[9];
    }
    
    /**
    *   Tallentaa tiedostoon ennätyksen mikäli pelaajan pisteet ovat korkeammat kuin jollain aikaisemmalla ennätyksellä.
    *   @param nimi Pelaajan nimi
    *   @param pisteet Pelaajan pisteet
    */
    public void tallennaEnnatys(String nimi, int pisteet){
        File tiedosto = new File("ennatykset.s");
        lueTiedosto(tiedosto);
        
        if(!korvaaEnnatys(nimi, pisteet)){
            return;
        }    
                
        tallennaTiedostoon(tiedosto);
    }
    
    /**
    *   Lukee tiedoston "ennatykset.s" sisällön rivi kerrallaan rivit[] - taulukkoon käyttäen lueTiedosto-metodia ja palauttaa saadun taulukon.
    *   @return Palauttaa taulukon jossa nykyiset ennätykset ovat
    *   @see miinaharava.ennatykset.Ennatys#lueTiedosto(File)
    */
    public String[] lueEnnatykset(){
        File tiedosto = new File("ennatykset.s");
        lueTiedosto(tiedosto);
        
        return this.rivit;
    }
    
    /**
    *   Lukee tiedoston "ennatykset.s" sisällön rivi kerrallaan rivit[] - taulukkoon. Jos tiedosto oli tyhjä täytetään se tiedostosta "ennatyksetDefault.s"
    *   Mikäli tiedostoa ei löytyny, kutsuu kaynnistaVirheIlmoitus-metodia.
    *   @param tiedosto luettava tiedosto
    *   @see miinaharava.ennatykset.Ennatys#kaynnistaVirheIlmoitus(String)
    */
    private void lueTiedosto(File tiedosto){
        Scanner s;
        
        try{
            s = new Scanner(tiedosto);
        }catch(Exception e){
            kaynnistaVirheilmoitus(tiedosto.getName());
            return;
        }
        
        int i = 0;
        
        while(s.hasNextLine()){
            String rivi = s.nextLine();
            rivit[i] = rivi;
            i++;
        }
        
       s.close();
       
       if(this.rivit[8] == null){
            lueTiedosto(new File("ennatyksetDefault.s"));
            tallennaTiedostoon(tiedosto);
       }
    }
    
    /**
    *   Korvaa ennätyksen rivit[] taulukkoon mikäli pelaajan pisteet ovat korkeammat kuin jollain aikaisemmalla ennätyksellä.
    *   @param nimi Pelaajan nimi
    *   @param pisteet Pelaajan pisteet
    *   @return Palauttaa true mikäli jokin aikaisemmista ennätyksitä korvatiin.
    */
    private boolean korvaaEnnatys(String nimi, int pisteet){ 
        for(int i=0; i<this.rivit.length; i++){
            String[] rivi = this.rivit[i].split(":");
            
            if(pisteet > Integer.parseInt(rivi[1])){
                this.rivit[i] = nimi + ":" + pisteet;
                
                String e = rivi[0] + ":" + rivi[1];
                loputYhdellaEteenpain(i+1, e);
                return true;
            }
        }
        
        return false;
    }
    
    private void loputYhdellaEteenpain(int alkuindeksi, String ensimmainen){
        String edellinen = ensimmainen;
        for(int i=alkuindeksi; i<this.rivit.length; i++){
            String vali = this.rivit[i];
            this.rivit[i] = edellinen;
            edellinen = vali;
        }
    }
    
    /**
    *   Tallentaa rivit-taulukon sisällön tiedostoon "ennatykset.s".
    *   Mikäli tiedostoa ei löytyny, kutsuu kaynnistaVirheIlmoitus-metodia.
    *   @see miinaharava.ennatykset.Ennatys#kaynnistaVirheIlmoitus(String)
    */
    private void tallennaTiedostoon(File tiedosto){
        FileWriter fw;
        
        try{
            fw = new FileWriter(tiedosto);
            for(String s:this.rivit){
                fw.write(s + "\n");
            }
            fw.close();
        }catch(Exception e){
            kaynnistaVirheilmoitus(tiedosto.getName());
        }
    }
    
    /**
    *   Käynnistää virheilmoituksen ilmoittamaan tiedoston puuttumisesta.
    *   @param tiedostonNimi puuttuvan tiedoston nimi
    *   @see miinaharava.kayttoliittyma.Virheilmoitus
    */
    private void kaynnistaVirheilmoitus(final String tiedostoNimi){
        EventQueue.invokeLater(new Runnable(){
                @Override
                public void run(){
                    Virheilmoitus v = new Virheilmoitus("Tiedostoa \"" +  tiedostoNimi +  "\" ei löytynyt.");
                    v.setVisible(true);
                }
            });
    }
}
