/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laivanupotus;

/**
 *
 * @author laatopi
 */
public class Ruudukko {

    public Ruutu[][] ruudukko;
    public boolean oma;

    public Ruudukko(boolean oma) { //luo ruudukon
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
        for (int i = 0; i < laivanKoko; i++) {
            ruudukko[pituus - 1][leveys - 1].asetaLaiva();
            if (pysty) {
                pituus++;
            } else {
                leveys++;
            }
        }

    }

    public boolean ruuduissaJoLaiva(int leveys, int pituus, int laivanKoko, boolean pysty) {
        for (int i = 0; i < laivanKoko; i++) {
            if (ruudukko[pituus - 1][leveys - 1].onkoRuudussaLaiva() == true) {
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

}
