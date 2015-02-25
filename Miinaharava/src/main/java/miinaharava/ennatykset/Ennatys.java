package miinaharava.ennatykset;

import java.io.File;
import java.io.FileWriter;
import java.util.*;


/*
*   Luokan tehtävä on käsitellä tiedostoa joka sisältää ennätykset.
*/
public class Ennatys {
    private String[] rivit;
    
    public Ennatys(){
        this.rivit = new String[9];
    }
    
    /*
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
    
    /*
    *   Lukee tiedoston "ennatykset.s" sisällön rivi kerrallaan rivit[] - taulukkoon käyttäen lueTiedosto-metodia ja palauttaa saadun taulukon.
    *   @return Palauttaa taulukon jossa nykyiset ennätykset ovat
    *   @see miinaharava.ennatykset.Ennatys#lueTiedosto(File)
    */
    public String[] lueEnnatykset(){
        File tiedosto = new File("ennatykset.s");
        lueTiedosto(tiedosto);
        
        return this.rivit;
    }
    
    /*
    *   Lukee tiedoston "ennatykset.s" sisällön rivi kerrallaan rivit[] - taulukkoon.
    */
    private void lueTiedosto(File tiedosto){
        Scanner s;
        
        try{
            s = new Scanner(tiedosto);
        }catch(Exception e){
            return;
        }
        
        int i = 0;
        
        while(s.hasNextLine()){
            String rivi = s.nextLine();
            rivit[i] = rivi;
            i++;
        }
        
       s.close();
    }
    
    /*
    *   Korvaa ennätyksen rivit[] taulukkoon mikäli pelaajan pisteet ovat korkeammat kuin jollain aikaisemmalla ennätyksellä.
    *   @param nimi Pelaajan nimi
    *   @param pisteet Pelaajan pisteet
    *   @return Palauttaa true mikäli jokin aikaisemmista ennätyksitä korvatiin.
    */
    private boolean korvaaEnnatys(String nimi, int pisteet){ 
        for(int i=0; i<this.rivit.length; i++){
            String[] rivi = this.rivit[i].split(":");
            
            if(pisteet > Integer.parseInt(rivi[2])){
                this.rivit[i] = i + ":" + nimi + ":" + pisteet;
                return true;
            }
        }
        
        return false;
    }
    
    /*
    *   Tallentaa rivit-taulukon sisällön tiedostoon "ennatykset.s"
    */
    private void tallennaTiedostoon(File tiedosto){
        FileWriter fw;
        
        try{
            fw = new FileWriter(tiedosto);
            for(String s:this.rivit){
                fw.write(s + "\n");
            }
            fw.close();
        }catch(Exception e){}
    }
}
