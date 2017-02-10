/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laivanupotus.logiikka;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author laatopi
 *
 * Ruudukko sisältää kokonaisuudessaan kaikki ruudukon yleisen hallintaan
 * liittyvät metodit, eli se hallitsee ruutuja.
 */
public class Ruudukko {

    /**
     * Itse ruudukko.
     */
    public Ruutu[][] ruudukko;

    /**
     * Onko tietokoneen vai pelaajan ruudukko.
     */
    public boolean oma;

    /**
     * Lista laivojen laskureista eli laivakokonaisuuksien tiloista.
     */
    public ArrayList<LaivaLaskuri> laskurit;

    /**
     * Konstruktori luo aina 8x8 ruudukon, ja asettaa alustavasti jokaiseen
     * tyhjan ruudun.
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
        if (mahtuukoLaivaRuudukkuoon(leveys, pituus, laivanKoko, pysty) == true) {
            if (ruuduissaJoLaiva(leveys, pituus, laivanKoko, pysty) == false) {

                LaivaLaskuri laskuri = new LaivaLaskuri();
                laskurit.add(laskuri);
                for (int i = 0; i < laivanKoko; i++) {
                    ruudukko[pituus][leveys].asetaLaiva();
                    ruudukko[pituus][leveys].asetaLaskuri(laskuri);
                    ruudukko[pituus][leveys].laskuri.kasvata();
                    if (pysty) {
                        pituus++;
                    } else {
                        leveys++;
                    }

                }
            }
        }
    }

    /**
     *
     * Tarkistaa onko ruuduissa mihin yritetään pistää laivaa jo joissain niissä
     * laiva.
     *
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
     * @return palauttaa true jos näin on, false jos ei ole.
     */
    public boolean mahtuukoLaivaRuudukkuoon(int leveys, int pituus, int laivanKoko, boolean pysty) {
        if (pysty) {
            if (pituus + (laivanKoko - 1) >= 8) {
                return false;
            }
        } else if (leveys + (laivanKoko - 1) >= 8) {
            return false;
        }
        return true;
    }

    /**
     * Ampuu parametrien osoittaamaan koordinaattiin, ja mikäli osuu laivaan,
     * ottaa sen huomioon ja merkitsee laivan laskuriin yhden vähemmän.
     *
     */
    public void ammuLaivaa(int leveys, int pituus) {
        ruudukko[pituus][leveys].ampuminen();
        if (ruudukko[pituus][leveys].onkoRuudussaLaiva() == true) {
            ruudukko[pituus][leveys].laskuri.vahenna();
        }
    }

    /**
     *
     * Metodi jolla tietokone ampuu laivaa. Katsoo että ei ammu ruutuun mihin on
     * jo ampunut, mutta ei sisällä tekoälyä eli tietokone ei jatkaa satunnaista
     * pommittamista vaikka olisi osunut edellisellä.
     *
     */
    public void tietokoneAmmuLaivaa() {
        if (onkoKaikkiLaivatUponneet() == true) {
            return;
        }
        Random random = new Random();
        int pituus = random.nextInt(8);
        int leveys = random.nextInt(8);
        while (this.ruudukko[pituus][leveys].ammuttu == true) {
            pituus = (random.nextInt(8));
            leveys = (random.nextInt(8));
        }
        System.out.println(pituus + " hmm " + leveys);
        ruudukko[pituus][leveys].ampuminen();
        if (ruudukko[pituus][leveys].onkoRuudussaLaiva() == true) {
            ruudukko[pituus][leveys].laskuri.vahenna();
        }

        //todo fiksu ampuminen eikä satunnaista hömppää
    }
    /**
     * Katsoo ovatko kyseisen ruudukon kaikki laivat uponneet.
     *
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
                ruudukko[i][j].paneeli.paivita();
            }
        }
    }
}
