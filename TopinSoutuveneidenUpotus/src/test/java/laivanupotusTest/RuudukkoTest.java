package laivanupotusTest;

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

    Ruudukko ruudukko;

    @Before
    public void setUp() {
        ruudukko = new Ruudukko(true);
    }

    @Test
    public void konstruktoriToimii() {
        assertTrue(this.ruudukko != null);
    }

    @Test
    public void ruudukkoOnOikeanKokoinen() {
        assertTrue((ruudukko.ruudukko.length * ruudukko.ruudukko[0].length) == 64);
    }

    @Test
    public void printRuudukkoToimii() {
        assertTrue(ruudukko.toString().equals("  A B C D E F G H \n"
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
        ruudukko.luoLaiva(1, 1, true, 2);
        assertTrue(ruudukko.ruudukko[0][0].onkoRuudussaLaiva());
        assertTrue(ruudukko.ruudukko[1][0].onkoRuudussaLaiva());
        assertFalse(ruudukko.ruudukko[2][0].onkoRuudussaLaiva());
    }
    
    @Test
    public void ruuduissaJoLaivaToimii() {
        ruudukko.luoLaiva(1, 1, true, 2);
        assertTrue(ruudukko.ruuduissaJoLaiva(1, 1, 2, true));
        assertFalse(ruudukko.ruuduissaJoLaiva(4, 5, 2, true));
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
