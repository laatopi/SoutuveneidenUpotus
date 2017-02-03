package laivanupotus;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import laivanupotus.*;

/**
 *
 * @author laatopi
 */
public class RuudukkoTest {

    public RuudukkoTest() {
    }

    Ruudukko ruukukko;

    @Before
    public void setUp() {
        ruukukko = new Ruudukko(true);
    }

    @Test
    public void konstruktoriToimii() {
        assertTrue(this.ruukukko != null);
    }

    @Test
    public void ruudukkoOnOikeanKokoinen() {
        assertTrue((ruukukko.ruudukko.length * ruukukko.ruudukko[0].length) == 64);
    }

    @Test
    public void printRuudukkoToimii() {
        assertTrue(ruukukko.toString().equals("  A B C D E F G H \n"
                + "1 x x x x x x x x \n"
                + "2 x x x x x x x x \n"
                + "3 x x x x x x x x \n"
                + "4 x x x x x x x x \n"
                + "5 x x x x x x x x \n"
                + "6 x x x x x x x x \n"
                + "7 x x x x x x x x \n"
                + "8 x x x x x x x x \n"
                + "\n"));
    }

    @Test
    public void luoLaivaToimii() {
        assertTrue(ruukukko.laskurit.size() == 0);
        ruukukko.luoLaiva(1, 1, true, 2);
        assertTrue(ruukukko.ruudukko[0][0].onkoRuudussaLaiva());
        assertTrue(ruukukko.ruudukko[1][0].onkoRuudussaLaiva());
        assertFalse(ruukukko.ruudukko[2][0].onkoRuudussaLaiva());
        assertTrue(ruukukko.laskurit.size() == 1);
    }

    @Test
    public void ruuduissaJoLaivaToimii() {
        ruukukko.luoLaiva(1, 1, true, 2);
        assertTrue(ruukukko.ruuduissaJoLaiva(1, 1, 2, true));
        assertFalse(ruukukko.ruuduissaJoLaiva(4, 5, 2, true));
    }

    @Test
    public void ammuLaivaToimiiIlmanLaivaa() {
        assertTrue(ruukukko.ruudukko[0][0].onkoAmmuttu() == false);
        ruukukko.ammuLaivaa(0, 0);
        assertTrue(ruukukko.ruudukko[0][0].onkoAmmuttu() == true);
    }

    @Test
    public void ammuLaivaToimiiLaivalla() {
        ruukukko.luoLaiva(1, 1, true, 2);
        assertTrue(ruukukko.laskurit.get(0).arvo() == 2);
        assertTrue(ruukukko.ruudukko[0][0].onkoAmmuttu() == false);
        ruukukko.ammuLaivaa(0, 0);
        assertTrue(ruukukko.ruudukko[0][0].onkoAmmuttu() == true);
        assertTrue(ruukukko.laskurit.get(0).arvo() == 1);
    }

    @Test
    public void onkoKaikkiLaivatUponneetToimii() {
        assertTrue(ruukukko.onkoKaikkiLaivatUponneet() == true);
        ruukukko.luoLaiva(1, 1, true, 2);
        assertFalse(ruukukko.onkoKaikkiLaivatUponneet() == true);
        ruukukko.ammuLaivaa(0, 0);
        assertFalse(ruukukko.onkoKaikkiLaivatUponneet() == true);
        ruukukko.ammuLaivaa(0, 1);
        assertTrue(ruukukko.onkoKaikkiLaivatUponneet() == true);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
