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

/**
 *
 * @author laatopi
 * 
 * luokka tarjoaa pelin etenemiseen liittyvat metodit ja toteuttaa ne oikeassa
 * oikeassa järjestyksessä.
 *
 */
public class Kayttoliittyma {

    Grafiikka h;
    Ruudukko oma;
    Ruudukko kone;
    public Random random;

    public Kayttoliittyma() {

    }

    public void kaynnista() { //käynnistää pelin
        this.oma = new Ruudukko(true);
        this.kone = new Ruudukko(false);
        this.h = new Grafiikka(oma, kone);
        this.random = new Random();

        asetaLaivat();
        paivitaGrafiikka();
        pommitusvaihe();

    }

    private void asetaLaivat() {
        int x = 2;
        for (int i = 0; i < 5; i++) {
            h.teksti.setText("Aseta Laivat!    ");
            asetaLaiva(x);
            h.teksti.setText("Laiva asetettu!");
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

    private void asetaLaiva(int i) {
        int montaEnnen = oma.montakoLaivaa();
        while (true) {
            this.h.laivanAsetusKaynnissa = true;
            this.h.laivanKoko = i;
            if (oma.montakoLaivaa() >= montaEnnen + i) {
                this.h.laivanAsetusKaynnissa = false;
                break;
            }

        }
    }

    private void paivitaGrafiikka() {
        oma.paivitaGrafiikka();
        kone.paivitaGrafiikka();
    }

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

    private void pommitusvaihe() {
        h.teksti.setText("Pommita!!");
        while (true) {
            h.taisteluVaiheKaynnissa = true;
            if (oma.onkoKaikkiLaivatUponneet() == true) {
                h.teksti.setText("Hävisit! :(");
                break;
            } else if (kone.onkoKaikkiLaivatUponneet() == true) {
                h.teksti.setText("Voitit!!");
                break;
            }

        }
    }
}
