/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laivanupotus.logiikka;

/**
 * 
 * @author laatopi
 * pieni apuluokka jolla pidetään laskua yksittäisen laivan tilasta. eli kun
 * laiva on 0, niin laiva uppoaa.
 */
public class LaivaLaskuri {

    int laskuri;

    public LaivaLaskuri() {
        laskuri = 0;
    }

    public void kasvata() {
        laskuri++;
    }

    public void vahenna() {
        laskuri--;
    }

    public int arvo() {
        return this.laskuri;
    }

}
