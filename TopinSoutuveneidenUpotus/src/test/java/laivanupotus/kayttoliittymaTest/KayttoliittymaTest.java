package laivanupotus.kayttoliittymaTest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import laivanupotus.kayttoliittyma.Kayttoliittyma;
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
public class KayttoliittymaTest {

    Kayttoliittyma k;

    public KayttoliittymaTest() {
    }

    @Before
    public void setUp() {
        this.k = new Kayttoliittyma();
    }

    @Test
    public void KonstruktoriToimii() {
        assertTrue(k.getOma() != null);
        assertTrue(k.getH()!= null);
        assertTrue(k.getKone() != null);
        assertTrue(k.getRandom() != null);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
