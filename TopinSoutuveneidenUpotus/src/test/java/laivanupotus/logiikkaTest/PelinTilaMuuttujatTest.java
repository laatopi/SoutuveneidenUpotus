/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laivanupotus.logiikkaTest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import laivanupotus.logiikka.PelinTilaMuuttujat;

/**
 *
 * @author laatopi
 */
public class PelinTilaMuuttujatTest {

    PelinTilaMuuttujat ptm;

    @Before
    public void setUp() {
        ptm = new PelinTilaMuuttujat();
    }

    @Test
    public void konstruktoriToimii() {
        assertTrue(ptm.getLaivanKoko() == 0);
        assertFalse(ptm.isLaivanAsetusKaynnissa());
        assertFalse(ptm.isTaisteluVaiheKaynnissa());
        assertTrue(ptm.isAsetusSuunta());
    }

    @Test
    public void setLaivanKokoToimii() {
        assertTrue(ptm.getLaivanKoko() == 0);
        ptm.setLaivanKoko(1000);
        assertTrue(ptm.getLaivanKoko() == 1000);
        ptm.setLaivanKoko(-1000);
        assertTrue(ptm.getLaivanKoko() == -1000);
    }

    @Test
    public void setAsetusSuuntToimii() {
        assertTrue(ptm.isAsetusSuunta());
        ptm.setAsetusSuunta(false);
        assertFalse(ptm.isAsetusSuunta());
        ptm.setAsetusSuunta(true);
        assertTrue(ptm.isAsetusSuunta());

    }

    @Test
    public void setLaivanAsetusKaynnissaToimii() {
        assertFalse(ptm.isLaivanAsetusKaynnissa());
        ptm.setLaivanAsetusKaynnissa(true);
        assertTrue(ptm.isLaivanAsetusKaynnissa());
        ptm.setLaivanAsetusKaynnissa(false);
        assertFalse(ptm.isLaivanAsetusKaynnissa());
    }

    @Test
    public void setTaisteluVaiheKaynnissaToimii() {
        assertFalse(ptm.isTaisteluVaiheKaynnissa());
        ptm.setTaisteluVaiheKaynnissa(true);
        assertTrue(ptm.isTaisteluVaiheKaynnissa());
        ptm.setTaisteluVaiheKaynnissa(false);
        assertFalse(ptm.isTaisteluVaiheKaynnissa());
    }
//    @Test
//    public void setLaivanKokoToimii() {
//        assertTrue(ptm.getLaivanKoko() == 0);
//        ptm.setLaivanKoko(1000);
//        assertTrue(ptm.getLaivanKoko() == 1000);
//        ptm.setLaivanKoko(-1000);
//        assertTrue(ptm.getLaivanKoko() == -1000);

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
