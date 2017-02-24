/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laivanupotus.logiikka;

/**
 * Luokka joka sisältää pelinvaihteiden tunnistavat muuttujat.
 *
 * @author laatopi
 */
public class PelinTilaMuuttujat {

    private boolean laivanAsetusKaynnissa;
    private boolean taisteluVaiheKaynnissa;
    private int laivanKoko;
    private boolean asetusSuunta;

    /**
     * Luo muuttujat alkuasetukssilla aluksi.
     */
    public PelinTilaMuuttujat() {
        this.laivanAsetusKaynnissa = false;
        this.taisteluVaiheKaynnissa = false;
        this.laivanKoko = 0;
        this.asetusSuunta = true;
    }

    /**
     * katsoo onko laivansetus tila kaynnissa.
     * @return the laivanAsetusKaynnissa
     */
    public boolean isLaivanAsetusKaynnissa() {
        return laivanAsetusKaynnissa;
    }

    /**
     * asettaa laivanasetuskaynniss tilaksi halutun parametrin.
     * @param laivanAsetusKaynnissa the laivanAsetusKaynnissa to set
     */
    public void setLaivanAsetusKaynnissa(boolean laivanAsetusKaynnissa) {
        this.laivanAsetusKaynnissa = laivanAsetusKaynnissa;
    }

    /**
     * katsoo onko taisteluvaihekaynissa.
     * @return the taisteluVaiheKaynnissa
     */
    public boolean isTaisteluVaiheKaynnissa() {
        return taisteluVaiheKaynnissa;
    }

    /**
     * asettaa taisteluvaiheeksi halutun parametrin.
     * @param taisteluVaiheKaynnissa the taisteluVaiheKaynnissa to set
     */
    public void setTaisteluVaiheKaynnissa(boolean taisteluVaiheKaynnissa) {
        this.taisteluVaiheKaynnissa = taisteluVaiheKaynnissa;
    }

    /**
     * palauttaa laivan koon.
     * @return the laivanKoko
     */
    public int getLaivanKoko() {
        return laivanKoko;
    }

    /**
     * asettaa laivankoon.
     * @param laivanKoko the laivanKoko to set
     */
    public void setLaivanKoko(int laivanKoko) {
        this.laivanKoko = laivanKoko;
    }

    /**
     * palauttaa asetussuunan. true pysty false vaaka.
     * @return the asetusSuunta
     */
    public boolean isAsetusSuunta() {
        return asetusSuunta;
    }

    /**
     * asettaa asetussuunnan. true pysty false vaaka.
     * @param asetusSuunta the asetusSuunta to set
     */
    public void setAsetusSuunta(boolean asetusSuunta) {
        this.asetusSuunta = asetusSuunta;
    }

}
