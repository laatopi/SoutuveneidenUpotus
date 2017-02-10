package laivanupotus;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import laivanupotus.logiikka.LaivaLaskuri;
import laivanupotus.logiikka.Ruutu;
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
public class RuutuTest {

    Ruutu ruutu;

    @Before
    public void setUp() {
        ruutu = new Ruutu();
    }

    @Test
    public void konstruktoriToimii() {
        assertTrue(ruutu != null);

    }


    @Test
    public void asetaLaivaToimii() {
        assertFalse(ruutu.onkoRuudussaLaiva());
        ruutu.asetaLaiva();
        assertTrue(ruutu.onkoRuudussaLaiva());
    }

    @Test
    public void onkoRuudussaLaivaToimii() {
        ruutu.asetaLaiva();
        assertTrue(ruutu.onkoRuudussaLaiva());
    }

    @Test
    public void ampuminenToimiiIlmanLaivaa() {
        assertTrue(ruutu.onkoAmmuttu() == false);
        ruutu.ampuminen();
        assertFalse(ruutu.onkoAmmuttu() == false);
    }

    @Test
    public void ampuminenToimiiLaivalla() {
        ruutu.asetaLaiva();
        assertTrue(ruutu.onkoAmmuttu() == false);
        ruutu.ampuminen();
        assertFalse(ruutu.onkoAmmuttu() == false);
    }

    @Test
    public void asetaLaskuriToimii() {
        assertTrue(this.ruutu.palautaLaskuri() == null);
        this.ruutu.asetaLaskuri(new LaivaLaskuri());
        assertFalse(this.ruutu.palautaLaskuri() == null);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
