**Aihe:** Laivanupotuspeli jossa on mahdollisuus pelata tekoälyä vastaan jolla on jonkin sortin aavistus siitä mihin ruutuihin kannattaa pommittaa osuman jälkeen.

**Käyttäjät:** Pelaaja

**Pelaajan toiminnot:**
- Pystyy laittamaan erikokoisia laivoja haluamiin ruutuihin.
- Pystyy pommittamaan vihollisen laivoja.
- Näkee jos ruudussa johon on pommitettu on vihollisen laiva.
- Näkee myös oman ruudukkonsa tilanteen.
![Alt text](https://github.com/laatopi/SoutuveneidenUpotus/blob/master/dokumentaatio/kaavio.jpeg)
- Esimerkkejä sekvensseistä.
![Alt text](https://github.com/laatopi/SoutuveneidenUpotus/blob/master/dokumentaatio/laivanLuominen.png)
![Alt text](https://github.com/laatopi/SoutuveneidenUpotus/blob/master/dokumentaatio/ampuminen.png)

**Rakennekuvaus:**
Ohjelmassa on 3 eri pakettia: Kayttoliittyma, Logiika ja Grafiikka.
Kayttoliittyma luo aluksi 2 ruudukkoa, oma ruudukon ja tietokoneen ruudukon. Tämän jälkeen Kayttoliittyma luo Grafiikka olion joka piirtää molemmat ruudukot ja värittää ne ikäänkuin tyhjäksi. Se myös luo niiden ympärille koordinaatiston jotta ne olisi helpompi hahmottaa.

Grafiikka pyytää käyttäjää asettamaan omat laivat, joka tapahtuu uita klikkaamalla. Kun ruutua klikkaa, se luo laivan siitä ruudusta lähtien, joko alaspäin tai oikealle lähtevän, riippuen nykyisestä asetussuunnasta. Kun ruudukkoon luodaan laiva, sille luodaan myös laivalaskuri olio, joka pitää kirjaa siitä että kuinka monta ei upotettua palaa yhdellä laivalla on jäljellä. Tämän avulla se pystyy tietämään onko yksittäinen laivanpala uponneesta vai haavoittuneesta laivasta.

Kun kaikki laivat on asetettu, jotka on kovakoodattu koodiin 3x2 Pituista laivaa, 2x3 Pituista laivaa, ja 1x4 Pituista laivaa, asettaa sovellus tietokoneelle satunnaisesti samankokoiset laivat sen omaan ruudukkoon, joka on oikealla puolella oleva ruudukko (Pelaajan on vasen).

Tämän jälkeen klikkaamalla tietokoneen Ruudukkoa pystyy pommittamaan sitä. Tietokone pommittaa aina pelaajan jälkeen, ja omaa pienehkön tekoälyn, joka reagoi osumaan lisäämällä kaikki vierekkäiset ruudut pinoon, jotka se pommittaa ennenkuin alkaa taas pommittamaan satunnaisia ruutuja.

Osumat aina merkitsevät ruudukon yksittäiseen ruutuun että se on ammuttu, ja tietää myös että onko siinä laiva vai ei, joka määritettiin asetusvaiheessa.

Grafiikka päivittää itsensä aina jokaisen pommituksen jälkeen oikella tavalla riippuen mitä on tapahtunut. Sininen ruutu tarkottaa koskematonta ruutua, keltainen pommitettua tyhjää ruutua, punainen pommitettua laivanpalaa, ja musta upotettua laivanpalaa. Sen lisäksi omassa ruudukossa näkee harmaalla missä omat laivat sijaitsee.

 Kun jommankumman ruudukon kaikki laivat ovat uponneet peli (toistaiseksi ei oikeasti) loppuu.





