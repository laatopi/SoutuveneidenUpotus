/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laivanupotus.logiikka;

import java.util.ArrayList;

/**
 *
 * @author laatopi
 */
public class Ruudukko {

    public Ruutu[][] ruudukko;
    public boolean oma;
    public ArrayList<LaivaLaskuri> laskurit;

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

    

    @Override
    public String toString() { //Printtaa ruuudkon ulkoasun.
        String ulkoasu = "";
        ulkoasu = ulkoasu + "  ";
        char leveys = 'A';
        for (int i = 0; i < 8; i++) {
            ulkoasu = ulkoasu + leveys + " ";
            leveys++;
        }

        ulkoasu = ulkoasu + "\n";
        int pituus = 1;
        for (int i = 0; i < 8; i++) {
            ulkoasu = ulkoasu + pituus + " ";
            for (int j = 0; j < 8; j++) {
                ulkoasu = ulkoasu + ruudukko[i][j] + " ";
            }
            pituus++;
            ulkoasu = ulkoasu + "\n";
        }
        ulkoasu = ulkoasu + "\n";
        return ulkoasu;
    }

    public void luoLaiva(int leveys, int pituus, boolean pysty, int laivanKoko) {
        LaivaLaskuri laskuri = new LaivaLaskuri();
        laskurit.add(laskuri);
        for (int i = 0; i < laivanKoko; i++) {
            ruudukko[pituus - 1][leveys - 1].asetaLaiva();
            ruudukko[pituus - 1][leveys - 1].asetaLaskuri(laskuri);
            ruudukko[pituus - 1][leveys - 1].laskuri.kasvata();
            if (pysty) {
                pituus++;
            } else {
                leveys++;
            }
        }
    }

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

    public void ammuLaivaa(int leveys, int pituus) {
        ruudukko[pituus][leveys].ampuminen();
        if (ruudukko[pituus][leveys].onkoRuudussaLaiva() == true) {
            ruudukko[pituus][leveys].laskuri.vahenna();
        }
    }

    public void tietokoneAmmuLaivaa(int leveys, int pituus) { //TODO ----
        ruudukko[pituus][leveys].ampuminen();
        if (ruudukko[pituus][leveys].onkoRuudussaLaiva() == true) {
            ruudukko[pituus][leveys].laskuri.vahenna();
        }

        //todo fiksu ampuminen eikä satunnaista hömppää
    }

    public boolean onkoKaikkiLaivatUponneet() {
        for (LaivaLaskuri laskuri : laskurit) {
            if (laskuri.arvo() > 0) {
                return false;
            }
        }
        return true;
    }

}
