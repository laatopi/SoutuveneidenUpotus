/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laivanupotus;

import laivanupotus.*;
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
public class LaivaLaskuriTest {

    public LaivaLaskuriTest() {
    }

    LaivaLaskuri laskuri;

    @Before
    public void setUp() {
        this.laskuri = new LaivaLaskuri();
    }

    @Test
    public void konstruktoriToimii() {
        assertTrue(this.laskuri != null);
    }

    @Test
    public void kasvataToimii() {
        assertTrue(this.laskuri.arvo() == 0);
        this.laskuri.kasvata();
        assertTrue(this.laskuri.arvo() == 1);
        this.laskuri.kasvata();
        assertTrue(this.laskuri.arvo() == 2);
    }

    @Test
    public void palautaArvoToimii() {
        assertTrue(this.laskuri.arvo() == 0);
    }
    
    @Test
    public void vahennaToimii(){
        assertTrue(this.laskuri.arvo() == 0);
        this.laskuri.kasvata();
        this.laskuri.kasvata();
        this.laskuri.vahenna();
        this.laskuri.vahenna();
        assertTrue(this.laskuri.arvo() == 0);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
