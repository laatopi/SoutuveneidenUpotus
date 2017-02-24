package laivanupotus.logiikkaTest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import laivanupotus.grafiikka.Grafiikka;
import laivanupotus.kayttoliittyma.Kayttoliittyma;
import laivanupotus.logiikka.*;
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
        assertTrue((ruukukko.getRuudukko().length * ruukukko.getRuudukko()[0].length) == 64);
    }

    @Test
    public void ruuduissaJoLaivaToimii() {
        ruukukko.luoLaiva(1, 1, true, 2);
        assertTrue(ruukukko.ruuduissaJoLaiva(1, 1, 2, true));
        assertFalse(ruukukko.ruuduissaJoLaiva(4, 5, 2, true));
    }

    @Test
    public void ammuLaivaToimiiIlmanLaivaa() {
        assertTrue(ruukukko.getRuudukko()[0][0].onkoAmmuttu() == false);
        ruukukko.ammuLaivaa(0, 0);
        assertTrue(ruukukko.getRuudukko()[0][0].onkoAmmuttu() == true);
    }

    @Test
    public void ammuLaivaToimiiLaivalla() {
        ruukukko.luoLaiva(0, 0, true, 2);
        assertTrue(ruukukko.getLaskurit().get(0).arvo() == 2);
        ruukukko.ammuLaivaa(0, 0);
        assertTrue(ruukukko.getLaskurit().get(0).arvo() == 1);

    }

    @Test
    public void luoLaivaToimii() {
        ruukukko.luoLaiva(10, 5, true, 100);
        assertTrue(ruukukko.montakoLaivaa() == 0);
        ruukukko.luoLaiva(-1000, -100, true, -1000);
        assertTrue(ruukukko.montakoLaivaa() == 0);

        ruukukko.luoLaiva(0, 0, true, 2);
        assertTrue(ruukukko.montakoLaivaa() == 2);
        ruukukko.luoLaiva(0, 0, false, 2);
        assertTrue(ruukukko.montakoLaivaa() == 2);
        ruukukko.luoLaiva(4, 5, false, 2);
        assertTrue(ruukukko.montakoLaivaa() == 4);
        assertFalse(ruukukko.getLaskurit().isEmpty());
        assertTrue(ruukukko.getLaskurit().get(0).arvo() == 2);
    }

    @Test
    public void mahtuukoLaivaToimii() {
        assertFalse(ruukukko.mahtuukoLaivaRuudukkuoon(-100, -1000, -1000, true));
        assertFalse(ruukukko.mahtuukoLaivaRuudukkuoon(-1000, -100, -100, false));
        assertFalse(ruukukko.mahtuukoLaivaRuudukkuoon(10000, 1000, 1000, true));
        assertFalse(ruukukko.mahtuukoLaivaRuudukkuoon(1000, 1000, 1000, false));
        assertTrue(ruukukko.mahtuukoLaivaRuudukkuoon(0, 0, 0, true));
        assertTrue(ruukukko.mahtuukoLaivaRuudukkuoon(0, 0, 0, false));
        assertTrue(ruukukko.mahtuukoLaivaRuudukkuoon(2, 2, 2, true));
        assertFalse(ruukukko.mahtuukoLaivaRuudukkuoon(2, 2, 2, true) == false);
        assertFalse(ruukukko.mahtuukoLaivaRuudukkuoon(0, 0, 0, false) == false);
    }

    @Test
    public void onkoKaikkiLaivatUponneetToimii() {
        assertTrue(ruukukko.onkoKaikkiLaivatUponneet());
        ruukukko.luoLaiva(0, 0, true, 3);
        assertFalse(ruukukko.onkoKaikkiLaivatUponneet());
    }

    @Test
    public void tietoKoneAmmuLaivaaToimii() {
        ruukukko.tietokoneAmmuLaivaa();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                assertFalse(ruukukko.getRuudukko()[i][j].onkoAmmuttu());
            }
        }
        ruukukko.luoLaiva(0, 0, true, 3);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (ruukukko.getRuudukko()[i][j].onkoAmmuttu() == true) {
                    assertFalse(ruukukko.onkoKaikkiLaivatUponneet());
                }
            }
        }
        ruukukko.tietokoneAmmuLaivaa();
        assertTrue(ruukukko.montakoLaivaa() == 3);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (ruukukko.getRuudukko()[i][j].onkoAmmuttu() == true && ruukukko.getRuudukko()[i][j].onkoRuudussaLaiva() == true) {
                    assertTrue(ruukukko.montakoLaivaa() == 2);
                }
            }
        }
    }

    @Test
    public void paivitaToimii() {
        Kayttoliittyma k = new Kayttoliittyma();
        Ruudukko r = k.getOma();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ruukukko.paivitaGrafiikka();
            }
        }
        r.getRuudukko()[0][0].ampuminen();
        r.paivitaGrafiikka();

    }

    @Test
    public void lisaaPinoonToimii() {
        assertTrue(ruukukko.palautaPino().palautaMetsastys());
        ruukukko.lisaaRuudutPinoon(3, 3);
        ruukukko.getRuudukko()[3][3].asetaLaiva();
        ruukukko.lisaaRuudutPinoon(3, 3);
        assertTrue(ruukukko.palautaPino().palautaPinonKoko() == 4);
        assertFalse(ruukukko.palautaPino().palautaMetsastys());
        
        
    }
}
