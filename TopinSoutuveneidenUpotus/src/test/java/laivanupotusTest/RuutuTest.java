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
    public void ulkoasuToimii() {
        assertTrue(ruutu.toString().equals("x"));
        ruutu.asetaLaiva();
        assertTrue(ruutu.toString().equals("+"));
    }

    @Test
    public void asetaLaivaToimii() {
        assertFalse(ruutu.onkoRuudussaLaiva());
        ruutu.asetaLaiva();
        assertTrue(ruutu.onkoRuudussaLaiva());
    }
    
    @Test
    public void onkoRuudussaLaivaToimii(){
        ruutu.asetaLaiva();
        assertTrue(ruutu.onkoRuudussaLaiva());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
