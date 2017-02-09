/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laivanupotus.logiikka;

import laivanupotus.kayttoliittyma.Kayttoliittyma;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author laatopi
 */
public class Logiikka {
    
    


    public static boolean tarkistaMahtuukoLaiva(int leveys, int pituus, boolean suunta, int laivanpituus, Ruudukko ruudukko) {
        if (suunta == true) {
            if (pituus + (laivanpituus - 1) > 7) {
                return false;
            }
        } else if (leveys + (laivanpituus - 1) > 7) {
            return false;
        }
        if (ruudukko.ruuduissaJoLaiva(leveys, pituus, laivanpituus, suunta) == true) {
            return false;
        }
        System.out.println("Novenaas");
        return true;
    }

    public static void asetaTietokoneenLaiva(int i, Ruudukko ruudukko) {
        Random random = new Random();
        while (true) {
            int leveys = random.nextInt(7) + 1;
            int pituus = random.nextInt(7) + 1;
            boolean pysty = random.nextBoolean();
            if (Logiikka.tarkistaMahtuukoLaiva(leveys, pituus, pysty, pituus, ruudukko) == true) {
                ruudukko.luoLaiva(leveys, pituus, pysty, i);
                break;
            }
        }
    }

    public static ArrayList<String> lista() {
        //Lista jolla kirjaimista voidaan katsoa
        ArrayList<String> ktoN = new ArrayList<>(); // niitä vastaava numeroarvo
        char a = 'A';
        for (int i = 0; i < 8; i++) {
            ktoN.add(i, "" + a);
            a++;
        }
        return ktoN;
    }

    public static int haeKordinaatti(String leveys) {
        ArrayList<String> lista = lista(); 
        
        for (int i = 0; i < 8; i++) {
            if (leveys.equals(lista.get(i)) || leveys.equals(lista.get(i).toLowerCase())) {
                return i + 1;
            }
        }
        return 0;
    }

}
