/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laivanupotus.logiikkaTest;

import laivanupotus.logiikka.Pino;
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
public class PinoTest {

    Pino p;

    @Before
    public void setUp() {
        p = new Pino();
    }

    @Test
    public void testaaPoppaus() {
        assertTrue(p.poppaus().equals("00"));
        p.lisaaPinoon("12");
        assertFalse(p.poppaus().equals("00"));
        p.lisaaPinoon("12");
        assertTrue(p.poppaus().equals("12"));
    }

    @Test
    public void testaaTyhjennys() {
        assertTrue(p.onkoPinoTyhja());
        p.lisaaPinoon("12");
        assertFalse(p.onkoPinoTyhja());
        p.tyhjennaPino();
        assertTrue(p.onkoPinoTyhja());
    }

}
