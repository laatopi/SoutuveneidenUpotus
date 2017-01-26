package laivanupotusTest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import laivanupotus.Kayttoliittyma;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static sun.awt.X11.XConstants.InputOutput;

/**
 *
 * @author laatopi
 */
public class KayttoliittymaTest {

    Kayttoliittyma k;

    public KayttoliittymaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        k = new Kayttoliittyma();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void ListaToimii() {
        ArrayList<String> lista = k.lista();
        assertTrue(lista.get(0).equals("A"));
        assertTrue(lista.get(2).equals("C"));
        assertTrue(lista.get(4).equals("E"));
        assertTrue(lista.get(6).equals("G"));
        assertTrue(lista.get(7).equals("H"));
    }

    @Test
    public void valitseLeveysToimii() {
        
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
