#Rakennekuvaus

Ruutu on yksinkertainen luokka, jonka teht�v�n�n on vain pit�� yksitt�isen ruudun tiedot muistissa. Ruudukko sis�lt�� kaksiulotteisessa taulukossa Ruutu-luokan ilmentymi� ja niiden k�sittelyyn k�ytett�v�� logiikkaa, kuten esim. viereisten miinojen laskemisen. Miinaharava sis�lt�� Ruudukon lis�ksi korkeamman tason peliin liittyv�� logiikka kuten miinojen arpomisen, pisteidenlaskennan ja Enn�tys-luokan kautta enn�tysten yll�pidon. Enn�tys-luokan teht�v� itsess��n on k�sitell� enn�tykset sis�lt�v�� tiedostoa ja tallentaa uusi tulos sinne tarvittaessa. 

Kayttoliittyma hallitsee kaikkia k�ytt�liittym�n komponentteja ja antaa Miinaharavalle ja Ruudukolle komentoja pelaajan sy�tteen mukaan. PiirtoAlusta vastaa logiikan ruudukon, ajan yms. piirt�misest� n�yt�lle. Valikko sis�lt�� nimens� mukaisesti pelin valikon ja Asetukset, Ennatysikkuna ja Virheilmoitus kukin vastaavat omasta ikkunastaan.

Ajastimen teht�v� on p�ivit�� sille viitteen� annetun Miinaharava-luokan aikaa ja pyyt�� Kayttoliittymaa p�ivitt�m��n sekunnin v�lein.