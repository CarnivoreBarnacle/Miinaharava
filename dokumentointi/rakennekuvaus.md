#Rakennekuvaus

Ruutu on yksinkertainen luokka, jonka tehtävänän on vain pitää yksittäisen ruudun tiedot muistissa. Ruudukko sisältää kaksiulotteisessa taulukossa Ruutu-luokan ilmentymiä ja niiden käsittelyyn käytettävää logiikkaa, kuten esim. viereisten miinojen laskemisen. Miinaharava sisältää Ruudukon lisäksi korkeamman tason peliin liittyvää logiikka kuten miinojen arpomisen, pisteidenlaskennan ja Ennätys-luokan kautta ennätysten ylläpidon. Ennätys-luokan tehtävä itsessään on käsitellä ennätykset sisältävää tiedostoa ja tallentaa uusi tulos sinne tarvittaessa. 

Kayttoliittyma hallitsee kaikkia käyttöliittymän komponentteja ja antaa Miinaharavalle ja Ruudukolle komentoja pelaajan syötteen mukaan. PiirtoAlusta vastaa logiikan ruudukon, ajan yms. piirtämisestä näytölle. Valikko sisältää nimensä mukaisesti pelin valikon ja Asetukset, Ennatysikkuna ja Virheilmoitus kukin vastaavat omasta ikkunastaan.

Ajastimen tehtävä on päivitää sille viitteenä annetun Miinaharava-luokan aikaa ja pyytää Kayttoliittymaa päivittämään sekunnin välein.