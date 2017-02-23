/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laivanupotus.logiikka;

/**
 * pieni apuluokka jolla pidetään laskua yksittäisen laivan
 * tilasta. eli kun laiva on 0, niin laiva uppoaa.
 */
public class LaivaLaskuri {

    private int laskuri;

    /**
     * Luo laivalaskurin, joka alkaa nollasta.
     */
    public LaivaLaskuri() {
        laskuri = 0;
    }

    /**
     * Kasvattaa laskurin arvoa yhdellä.
     */
    public void kasvata() {
        laskuri++;
    }

    /**
     * Vähentää laskurin arvoa yhdellä.
     */
    public void vahenna() {
        laskuri--;
    }

    /**
     * Palauttaa laskurin arvon.
     * @return laskurin nykyinen arvo.
     */
    public int arvo() {
        return this.laskuri;
    }

}
