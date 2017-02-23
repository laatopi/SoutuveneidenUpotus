package laivanupotus.logiikka;

import java.util.ArrayList;
import java.util.Random;

/**
 * Ruudukko sisältää kokonaisuudessaan kaikki ruudukon yleisen hallintaan
 * liittyvät metodit, eli se hallitsee ruutuja.
 */
public class Ruudukko {

    private Ruutu[][] ruudukko;
    private boolean oma;
    private ArrayList<LaivaLaskuri> laskurit;
    private Pino ta;

    /**
     * Konstruktori luo aina 8x8 ruudukon, ja asettaa alustavasti jokaiseen
     * tyhjan ruudun.
     *
     * @param oma kertoo onko ruudukko pelaajan vai tietokoneen. true jos on.
     */
    public Ruudukko(boolean oma) { //luo ruudukon

        laskurit = new ArrayList<>();

        this.ruudukko = new Ruutu[8][8]; //ensimmäinen Y akseli, toinen X akseli
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ruudukko[i][j] = new Ruutu();
            }
        }
        this.oma = oma;

        this.ta = new Pino();

    }

    /**
     * Metodi luo laivan, annetusta pääpisteestä ruudukkoon.
     *
     * @param leveys leveyskoordinaatti
     * @param pituus pituuskoordinaatti
     * @param pysty onko laiva pystyssä (true) vai vaakatasossa (false)
     * @param laivanKoko kuinka pitkästä laivasta on kyse int muuttujana
     */
    public void luoLaiva(int leveys, int pituus, boolean pysty, int laivanKoko) {
        int pystyK = pituus;
        int vaakaK = leveys;
        boolean onkoPystyssa = pysty;
        if (laivanKoko >= 5 || laivanKoko <= 0) {
            return;
        }
        if (mahtuukoLaivaRuudukkuoon(vaakaK, pystyK, laivanKoko, onkoPystyssa) == true) {
            if (ruuduissaJoLaiva(vaakaK, pystyK, laivanKoko, onkoPystyssa) == false) {

                LaivaLaskuri laskuri = new LaivaLaskuri();
                laskurit.add(laskuri);
                for (int i = 0; i < laivanKoko; i++) {
                    ruudukko[pystyK][vaakaK].asetaLaiva();
                    ruudukko[pystyK][vaakaK].asetaLaskuri(laskuri);
                    ruudukko[pystyK][vaakaK].palautaLaskuri().kasvata();
                    if (onkoPystyssa) {
                        pystyK++;
                    } else {
                        vaakaK++;
                    }
                }
            }
        }
    }

    /**
     * Tarkistaa onko ruuduissa mihin yritetään pistää laivaa jo joissain niissä
     * laiva.
     *
     * @param leveys leveyskoordinaatti
     * @param pituus pituuskoordinaatti
     * @param pysty onko laiva pystyssä (true) vai vaakatasossa (false)
     * @param laivanKoko kuinka pitkästä laivasta on kyse int muuttujana
     *
     * @return false jos näin ei ole, true jos on.
     */
    public boolean ruuduissaJoLaiva(int leveys, int pituus, int laivanKoko, boolean pysty) {
        for (int i = 0; i < laivanKoko; i++) {
            if (ruudukko[pituus][leveys].onkoRuudussaLaiva() == true) {
                return true;
            }
            if (pysty) {
                pituus++;
            } else {
                leveys++;
            }
        }
        return false;
    }

    /**
     * Metodi katsoo mahtuuko laiva ruudukkoon, eli toisinsanoen on lähinnä
     * estämässä arrayoutofboundexceptionit.
     *
     * @param leveys leveyskoordinaatti
     * @param pituus pituuskoordinaatti
     * @param pysty onko laiva pystyssä (true) vai vaakatasossa (false)
     * @param laivanKoko kuinka pitkästä laivasta on kyse int muuttujana
     *
     * @return palauttaa true jos näin on, false jos ei ole.
     */
    public boolean mahtuukoLaivaRuudukkuoon(int leveys, int pituus, int laivanKoko, boolean pysty) {
        boolean onkoPystyssa = pysty;
        if (onkoPystyssa) {
            if (pituus + (laivanKoko - 1) >= 8 || pituus < 0) {
                return false;
            }
        } else if (leveys + (laivanKoko - 1) >= 8 || leveys < 0) {
            return false;
        }
        return true;
    }

    /**
     * Ampuu parametrien osoittaamaan koordinaattiin, ja mikäli osuu laivaan,
     * ottaa sen huomioon ja merkitsee laivan laskuriin yhden vähemmän.
     *
     * @param leveys leveyskoordinaatti
     * @param pituus pituuskoordinaatti
     */
    public void ammuLaivaa(int pituus, int leveys) {
        if (ruudukko[pituus][leveys].onkoRuudussaLaiva() == true && ruudukko[pituus][leveys].onkoAmmuttu() == false) {
            ruudukko[pituus][leveys].palautaLaskuri().vahenna();
        }
        ruudukko[pituus][leveys].ampuminen();
    }

    /**
     *
     * Metodi jolla tietokone ampuu laivaa. Katsoo että ei ammu ruutuun mihin on
     * jo ampunut, ja jos osuu, niin lisää stackkiin viereiset ruudut ja pommittaa ne tyhjäksi.
     * tekoäly on melko tyhmä mutta satunnaista käyttävää parempi.
     *
     */
    public void tietokoneAmmuLaivaa() {
        if (onkoKaikkiLaivatUponneet() == true) {
            return;
        }

        boolean laivaUpotettuVuorolla = false;
        int pituus = 0;
        int leveys = 0;

        if (this.ta.palautaMetsastys() == true) {
            Random random = new Random();
            pituus = random.nextInt(8);
            leveys = random.nextInt(8);
            while (this.ruudukko[pituus][leveys].onkoAmmuttu() == true) {
                pituus = (random.nextInt(8));
                leveys = (random.nextInt(8));
            }
        } else {
            String koordinaatit = this.ta.poppaus();
            pituus = Character.getNumericValue(koordinaatit.charAt(0));
            leveys = Character.getNumericValue(koordinaatit.charAt(1));
        }
        ammuLaivaa(pituus, leveys);
        if (this.ruudukko[pituus][leveys].onkoRuudussaLaiva() == true) {
            if (this.ruudukko[pituus][leveys].palautaLaskuri().arvo() == 0) {
                ta.tyhjennaPino();
                laivaUpotettuVuorolla = true;
            }
        }
        if (this.ta.onkoPinoTyhja() == true) {
            this.ta.metsastysPaalle();
        }

        if (laivaUpotettuVuorolla == false) {
            if (this.ruudukko[pituus][leveys].onkoRuudussaLaiva() == true) {
                this.ta.metsastysPois();
                if ((leveys + 1) <= 7) {
                    if (this.ruudukko[pituus][leveys + 1].onkoAmmuttu() == false) {
                        ta.lisaaPinoon("" + pituus + "" + (leveys + 1));
                    }
                }
                if ((pituus + 1) <= 7) {
                    if (this.ruudukko[pituus + 1][leveys].onkoAmmuttu() == false) {
                        ta.lisaaPinoon("" + (pituus + 1) + "" + leveys);
                    }
                }
                if ((leveys - 1) >= 0) {
                    if (this.ruudukko[pituus][leveys - 1].onkoAmmuttu() == false) {
                        ta.lisaaPinoon("" + pituus + "" + (leveys - 1));
                    }
                }
                if ((pituus - 1) >= 0) {
                    if (this.ruudukko[pituus - 1][leveys].onkoAmmuttu() == false) {
                        ta.lisaaPinoon("" + (pituus - 1) + "" + leveys);
                    }
                }
            }
        }
    }

    /**
     * Katsoo ovatko kyseisen ruudukon kaikki laivat uponneet.
     *
     * @return true jos on, false jos ei.
     */
    public boolean onkoKaikkiLaivatUponneet() {
        for (LaivaLaskuri laskuri : laskurit) {
            if (laskuri.arvo() > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Laskee montako laivaruutua ruudukossa on.
     *
     * @return laivojenmäärä
     */
    public int montakoLaivaa() {
        int x = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (ruudukko[i][j].onkoRuudussaLaiva()) {
                    x++;
                }
            }
        }
        return x;
    }

    /**
     * paivittaa jokaisen ruudun oman grafiiikan.
     *
     */
    public void paivitaGrafiikka() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (ruudukko[i][j].palautaPaneeli() != null) {
                    ruudukko[i][j].palautaPaneeli().paivita();
                }
            }
        }
    }
    
    public boolean onkoOma(){
        return oma;
    }
    
    public Ruutu[][] getRuudukko(){
        return this.ruudukko;
    }
}
