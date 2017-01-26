/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laivanupotus;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author laatopi
 */
public class Kayttoliittyma {

    Scanner lukija;
    ArrayList<String> numerot;
    Ruudukko omaRuudukko;
    Ruudukko tietokoneenRuudukko;

    public Kayttoliittyma() {
        this.numerot = lista();
        this.lukija = new Scanner(System.in);
    }

    public ArrayList<String> lista() {
        ArrayList<String> ktoN = new ArrayList<>();

        char a = 'A';
        for (int i = 0; i < 8; i++) {
            ktoN.add(i, "" + a);
            a++;
        }
        return ktoN;
    }

    public void kaynnista() { //käynnistää pelin
        this.omaRuudukko = new Ruudukko(true);
        this.tietokoneenRuudukko = new Ruudukko(false);

        System.out.println("Aseta laivat!\n");
        System.out.println(omaRuudukko.toString());
        asetaLaivat();
        omaRuudukko.toString();

    }

    private void asetaLaivat() { //asettaa laivatnumerot
        asetalaiva(2);
        asetalaiva(2);

    }

    private void asetalaiva(int i) { //asettaa laivat. yksittäiset laivat pitää olla vierekkäin.
        System.out.println("Valitse laivan pään koordinaatit " + i + " pituiselle laivalle.\n");

        int leveys = 0;
        int pituus = 0;
        boolean pysty = false;

        System.out.print("Tuleeko laiva pysty vai vaakatasoon ? (p/l): ");
        String suunta = lukija.nextLine();
        if (suunta.equals("p")) {
            pysty = true;
        }

        while (true) {

            leveys = valitseLeveysKoordinaatti();
            pituus = valitsePituusKoordinaatti();

            if (tarkistaMahtuukoLaiva(leveys, pituus, pysty, i) == true) { //katsoo mahtuuko laiva koordinaatistoon
                break;                                                       //tai meneekö se jonkun toisen laivan päälle.
            }
            System.out.println("\nLaiva ei mahdu, kokeile uusilla koordinaateilla!\n");
        }

        omaRuudukko.luoLaiva(leveys, pituus, pysty, i);
        System.out.println("\nLaiva asetettu!");
    }

    private int haeKordinaatti(String leveys) {
        for (int i = 0; i < 8; i++) {
            if (leveys.equals(numerot.get(i)) || leveys.equals(numerot.get(i).toLowerCase())) {
                return i + 1;
            }
        }
        return 0;
    }

    private boolean tarkistaMahtuukoLaiva(int leveys, int pituus, boolean suunta, int laivanpituus) {
        
        if (suunta == true) {
            if (pituus + (laivanpituus - 1) > 8) {
                return false;
            }
        } else if (leveys + (laivanpituus - 1) > 8) {
            return false;
        }

        if (omaRuudukko.ruuduissaJoLaiva(leveys, pituus, laivanpituus, suunta) == true) {
            System.out.println("\nHups, laivahan menisi päällekkäin toisen laivan kanssa! Eihän se sovi.\n");
            return false;
        }
        return true;
    }

    public int valitseLeveysKoordinaatti() {

        while (true) { // valitaan ensin leveyssuuntainen
            System.out.print("Leveys (A-H): ");
            String leveys = lukija.nextLine();
            int leveys2 = haeKordinaatti(leveys);
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

}
