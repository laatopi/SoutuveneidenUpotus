/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laivanupotus.kayttoliittyma;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;
import laivanupotus.grafiikka.Grafiikka;
import laivanupotus.logiikka.Ruudukko;
import laivanupotus.logiikka.Ruudukko;
import laivanupotus.logiikka.PelinTilaMuuttujat;

/**
 * luokka tarjoaa pelin etenemiseen liittyvat metodit ja toteuttaa ne oikeassa
 * oikeassa järjestyksessä.
 */
public class Kayttoliittyma {

    private Grafiikka h;
    private Ruudukko oma;
    private Ruudukko kone;
    private Random random;
    private PelinTilaMuuttujat m;

    /**
     * Konstruktori luo kaikki ohjelmaan tarvittavat oliot, kovakoodattuna
     * pelaaja vastaan tietokone.
     */
    public Kayttoliittyma() {
        reset();
    }

    public Grafiikka getH() {
        return h;
    }

    public Ruudukko getOma() {
        return oma;
    }

    public Ruudukko getKone() {
        return kone;
    }

    public Random getRandom() {
        return random;
    }

    /**
     * Kaynnistaa ohjelman.
     */
    private void kaynnista() { //käynnistää pelin
        asetaLaivat();
        paivitaGrafiikka();
        pommitusvaihe();

    }

    /**
     * asettaa laivat. käyttää ruudukon klikkauksia laivan asettamiseen.
     */
    private void asetaLaivat() {
        int x = 2;
        for (int i = 0; i < 5; i++) {
            h.setTeksti("Aseta Laivat!    ");
            asetaLaiva(x);
            h.setTeksti("Laiva asetettu!");
            if (i == 1) {
                x = 3;
            } else if (i == 3) {
                x = 4;
            }
        }
        asetaKoneenLaiva(2);
        asetaKoneenLaiva(2);
        asetaKoneenLaiva(2);
        asetaKoneenLaiva(3);
        asetaKoneenLaiva(3);
        asetaKoneenLaiva(4);
    }

    /**
     * asettaa yksittäisen laivan
     *
     * @param i laivan koko.
     *
     */
    private void asetaLaiva(int i) {
        int montaEnnen = oma.montakoLaivaa();
        while (true) {
            this.m.setLaivanAsetusKaynnissa(true);
            this.m.setLaivanKoko(i);
            if (oma.montakoLaivaa() >= montaEnnen + i) {
                this.m.setLaivanAsetusKaynnissa(false);
                break;
            }
        }
    }

    /**
     * paivittaa ruudukkojen grafiikat ampumisen jälkeen.
     */
    private void paivitaGrafiikka() {
        h.paivitaGrafiikat();
    }

    /**
     * asettaa tietokoneelle satunnaiseen paikkaan laivan.
     *
     * @param i laivan koko.
     */
    private void asetaKoneenLaiva(int i) {
        while (true) {
            int p = random.nextInt(7);
            int l = random.nextInt(7);
            boolean suunta = random.nextBoolean();

            if (kone.mahtuukoLaivaRuudukkuoon(l, p, i, suunta) == true && kone.ruuduissaJoLaiva(l, p, i, suunta) == false) {
                kone.luoLaiva(l, p, suunta, i);
                break;
            }
        }

    }

    /**
     * pommitus vaihe lähtee käyntiin kun laivat asetettu.
     */
    private void pommitusvaihe() {
        h.setTeksti("Pommita!!");
        while (true) {
            m.setTaisteluVaiheKaynnissa(true);
            if (oma.onkoKaikkiLaivatUponneet() == true) {
                h.setTeksti("Hävisit! :(");
                break;
            } else if (kone.onkoKaikkiLaivatUponneet() == true) {
                h.setTeksti("Voitit!!");
                break;
            }

        }
        m.setTaisteluVaiheKaynnissa(false);
        if (h.loppuKysely()) {
            h.suljeIkkuna();
            reset();
        } else {
            h.suljeIkkuna();
        }
    }

    /**
     * Pallauttaa pelin tila muuttujat.
     *
     * @return palauttaa pelin tila muuttujat jota käyttöliittymä päivittelee.
     */
    public PelinTilaMuuttujat palautaMuuttujat() {
        return this.m;
    }

    /**
     *
     * resettaa pelin.
     */
    private void reset() {
        this.m = new PelinTilaMuuttujat();
        this.oma = new Ruudukko(true);
        this.kone = new Ruudukko(false);
        this.h = new Grafiikka(oma, kone, m);
        this.random = new Random();
        kaynnista();
    }

}
