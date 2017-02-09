/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laivanupotus.kayttoliittyma;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;
import laivanupotus.grafiikka.GrafiikkaTest;
import laivanupotus.logiikka.Logiikka;
import laivanupotus.logiikka.Logiikka;
import laivanupotus.logiikka.Ruudukko;
import laivanupotus.logiikka.Ruudukko;

/**
 *
 * @author laatopi
 */
public class Kayttoliittyma {

    Scanner lukija;
    public Ruudukko omaRuudukko;
    public Ruudukko tietokoneenRuudukko;
    Random random;
    GrafiikkaTest g;
    public int pituusAsetaLaiva;
    public int leveysAsetaLaiva;
    public boolean asetusKaynnissa;

    public Kayttoliittyma() {
        this.random = new Random();
        this.lukija = new Scanner(System.in);
        this.omaRuudukko = new Ruudukko(true);
        this.tietokoneenRuudukko = new Ruudukko(false);
    }

    public void kaynnista() { //käynnistää pelin
        
        this.g = new GrafiikkaTest(this);
        System.out.println("Aseta laivat!\n");
        System.out.println(this.omaRuudukko.toString());
        asetaLaivat();
        peliKayntiin();
    }

    private void asetaLaivat() { //asettaa laivatnumerot
        asetaLaiva(2);
        asetaLaiva(2);
        asetaLaiva(3);
        asetaLaiva(3);
        asetaLaiva(4);
        Logiikka.asetaTietokoneenLaiva(2, this.tietokoneenRuudukko);
        Logiikka.asetaTietokoneenLaiva(2, this.tietokoneenRuudukko);
        Logiikka.asetaTietokoneenLaiva(3, this.tietokoneenRuudukko);
        Logiikka.asetaTietokoneenLaiva(3, this.tietokoneenRuudukko);
        Logiikka.asetaTietokoneenLaiva(4, this.tietokoneenRuudukko);

    }

    private void asetaLaiva(int i) { //asettaa laivat. yksittäiset laivat pitää olla vierekkäin.
        System.out.println("Valitse laivan pään koordinaatit " + i + " pituiselle laivalle.\n");

        leveysAsetaLaiva = 8;
        pituusAsetaLaiva = 8;
        boolean pysty = false;

//        System.out.print("Tuleeko laiva pysty vai vaakatasoon ? (p/l): ");
//        String suunta = lukija.nextLine();
//        if (suunta.equals("p")) {
//            pysty = true;
//        }
        asetusKaynnissa = true;
        while (true) {
            
            if (Logiikka.tarkistaMahtuukoLaiva(leveysAsetaLaiva, pituusAsetaLaiva, pysty, i, omaRuudukko) == true) {
                asetusKaynnissa = false;
                break;                                                       //tai meneekö se jonkun toisen laivan päälle.
            }
        }

        omaRuudukko.luoLaiva(leveysAsetaLaiva, pituusAsetaLaiva, pysty, i);
        System.out.println("\nLaiva asetettu!");
        System.out.println(omaRuudukko.toString());
    }

    public int valitseLeveysKoordinaatti() {

        while (true) { // valitaan ensin leveyssuuntainen
            System.out.print("Leveys (A-H): ");
            String leveys = lukija.nextLine();
            int leveys2 = Logiikka.haeKordinaatti(leveys);
            if (leveys2 != 0) {
                return leveys2;
            }
            System.out.println("Koordinaatin pitää olla väliltä A-H. (Ota huomioon laivan perä!)");
        }
    }

    public int valitsePituusKoordinaatti() {
        while (true) { // sitten pituusssuuntainen
            int pituus = 0;
            System.out.print("Pituus (1-8): ");
            String x = lukija.nextLine();
            try {
                pituus = Integer.parseInt(x);
            } catch (NumberFormatException nfe) {
                System.out.println("Ei ole numero väliltä 1-8.(Ota huomioon laivan perä!)");
            }
            if (pituus > 0 && pituus < 9) {
                return pituus;
            }
        }
    }

    private void peliKayntiin() {
        while (true) {
            System.out.println("---OMA RUUDUKKO---");
            System.out.println(omaRuudukko);
            System.out.println("---TIETOKONEEN RUUDUKKO---");
            System.out.println(tietokoneenRuudukko);

            ammu();

            if (tietokoneenRuudukko.onkoKaikkiLaivatUponneet() == true) {
                System.out.println("Jihuu! Voitto!!");
                break;
            }

            System.out.println("JEA");
            omaRuudukko.tietokoneAmmuLaivaa(random.nextInt(7) + 1, random.nextInt(7) + 1);

            if (omaRuudukko.onkoKaikkiLaivatUponneet()) {
                System.out.println("Voi EI! Häviö :(");
                break;
            }

        }
    }

    private void ammu() {
        while (true) {
            System.out.print("Valitse ammuttavat koordinaatit(Mallilla A-8): ");
            String koordinaatit = lukija.nextLine();

            int pituus = 0;
            int leveys = Logiikka.haeKordinaatti("" + koordinaatit.charAt(0));
            try {
                pituus = Integer.parseInt("" + koordinaatit.charAt(2));
            } catch (NumberFormatException nfe) {
            }

            if (pituus > 0 && pituus < 9 && leveys != 0) {
                tietokoneenRuudukko.ammuLaivaa(leveys - 1, pituus - 1);
                break;
            }

        }
    }

}
