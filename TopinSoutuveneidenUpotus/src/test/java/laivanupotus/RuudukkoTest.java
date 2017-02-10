package laivanupotus;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import laivanupotus.logiikka.Ruudukko;
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

    

    

 
}
