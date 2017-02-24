/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laivanupotus.logiikka;

import java.util.Stack;

/**
 *
 * Apuluokka joka käyttää pinoa. Tietokoneen tekoäly hyödyntää tätä.
 *
 * @author laatopi
 */
public class Pino {

    private boolean metsastys;
    private Stack<String> pino;

    /**
     * Luo uuden pinon.
     */
    public Pino() {
        this.metsastys = true;
        this.pino = new Stack();
    }

    /**
     *Lisaa pinoon uudet koordinaatit.
     * @param koordinaatti mikä koordinaatti kyseessä.
     */
    public void lisaaPinoon(String koordinaatti) {
        this.pino.add(koordinaatti);
    }

    /**
     * Pistää metsästyksen päälle, eli pinoon ei sillon voi lisätä mitään.
     */
    public void metsastysPaalle() {
        this.metsastys = true;
    }

    /**
     * Pistää metsätyksen pois päältä, eli pinoa voi muokata.
     */
    public void metsastysPois() {
        this.metsastys = false;
    }

    /**
     *  Katsoo onko metsästys päällä.
     *  @return onko päällä.
     */
    public boolean palautaMetsastys() {
        return this.metsastys;
    }

    /**
     *  Poppaa pinon päällimäisen koordinaatin.
     *  @return palauttaa koordinaatin tai 00 jos pino tyhjä.
     */
    public String poppaus() {
        if (!onkoPinoTyhja()) {
            return this.pino.pop();
        }
        return "00";
    }

    /**
     * Katsoo onko pino tyhjä.
     * @return onko tyhjä vai ei.
     */
    public boolean onkoPinoTyhja() {
        return this.pino.empty();
    }

    /**
     * Tyhjentää pinon.
     */
    public void tyhjennaPino() {
        this.pino.clear();
    }

    /**
     * Testimetodeissa tarvittava metodi joka näyttää pinon koon.
     * @return pinon koko.
     */
    public int palautaPinonKoko() {
        return this.pino.size();
    }

}
