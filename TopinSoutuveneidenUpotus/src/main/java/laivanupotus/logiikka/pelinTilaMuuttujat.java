/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laivanupotus.logiikka;

/**
 *
 * @author laatopi
 */
public class pelinTilaMuuttujat {

    private boolean laivanAsetusKaynnissa;
    private boolean taisteluVaiheKaynnissa;
    private int laivanKoko;
    private boolean asetusSuunta;
    
//            
    
    public pelinTilaMuuttujat(){
        this.laivanAsetusKaynnissa = false;
        this.taisteluVaiheKaynnissa = false;
        this.laivanKoko = 0;
        this.asetusSuunta = true;
    }
    /**
     * @return the laivanAsetusKaynnissa
     */
    public boolean isLaivanAsetusKaynnissa() {
        return laivanAsetusKaynnissa;
    }

    /**
     * @param laivanAsetusKaynnissa the laivanAsetusKaynnissa to set
     */
    public void setLaivanAsetusKaynnissa(boolean laivanAsetusKaynnissa) {
        this.laivanAsetusKaynnissa = laivanAsetusKaynnissa;
    }

    /**
     * @return the taisteluVaiheKaynnissa
     */
    public boolean isTaisteluVaiheKaynnissa() {
        return taisteluVaiheKaynnissa;
    }

    /**
     * @param taisteluVaiheKaynnissa the taisteluVaiheKaynnissa to set
     */
    public void setTaisteluVaiheKaynnissa(boolean taisteluVaiheKaynnissa) {
        this.taisteluVaiheKaynnissa = taisteluVaiheKaynnissa;
    }

    /**
     * @return the laivanKoko
     */
    public int getLaivanKoko() {
        return laivanKoko;
    }

    /**
     * @param laivanKoko the laivanKoko to set
     */
    public void setLaivanKoko(int laivanKoko) {
        this.laivanKoko = laivanKoko;
    }

    /**
     * @return the asetusSuunta
     */
    public boolean isAsetusSuunta() {
        return asetusSuunta;
    }

    /**
     * @param asetusSuunta the asetusSuunta to set
     */
    public void setAsetusSuunta(boolean asetusSuunta) {
        this.asetusSuunta = asetusSuunta;
    }

}
