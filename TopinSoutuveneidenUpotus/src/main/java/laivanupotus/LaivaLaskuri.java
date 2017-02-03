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
