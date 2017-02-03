/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laivanupotus;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author laatopi
 */
public class LogiikkaTest {

    public LogiikkaTest() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void tarkistaMahtuukoLaivaToimii() {
        Ruudukko ruudukko = new Ruudukko(true);
        assertTrue(Logiikka.tarkistaMahtuukoLaiva(0, 0, true, 0, ruudukko) == true);

        assertTrue(Logiikka.tarkistaMahtuukoLaiva(0, 0, true, 10, ruudukko) == false);

    }

    @Test
    public void listaToimii() {
        assertTrue(Logiikka.lista() != null);
        assertTrue(Logiikka.lista().get(0).equals("A"));
        assertTrue(Logiikka.lista().get(1).equals("B"));
        assertTrue(Logiikka.lista().get(2).equals("C"));
        assertTrue(Logiikka.lista().get(3).equals("D"));
        assertTrue(Logiikka.lista().get(7).equals("H"));
        assertTrue(Logiikka.haeKordinaatti("SFGJJ") == 0);
    }

    @Test
    public void asetaTietokoneenLaivaToimii() {
        Kayttoliittyma k = new Kayttoliittyma();
        Logiikka.asetaTietokoneenLaiva(2, k);
        Logiikka.asetaTietokoneenLaiva(2, k);
        assertTrue(k.tietokoneenRuudukko.onkoKaikkiLaivatUponneet() == false);

    }

    @Test
    public void haeKoordinaattiToimii() {
        assertTrue(Logiikka.haeKordinaatti("A") == 1);
        assertTrue(Logiikka.haeKordinaatti("B") == 2);
        assertTrue(Logiikka.haeKordinaatti("C") == 3);
        assertTrue(Logiikka.haeKordinaatti("D") == 4);
        assertTrue(Logiikka.haeKordinaatti("E") == 5);
        assertTrue(Logiikka.haeKordinaatti("F") == 6);
        assertTrue(Logiikka.haeKordinaatti("G") == 7);
        assertTrue(Logiikka.haeKordinaatti("H") == 8);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
