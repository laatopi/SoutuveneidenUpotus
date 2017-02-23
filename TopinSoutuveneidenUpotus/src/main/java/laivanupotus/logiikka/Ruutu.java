/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laivanupotus.logiikka;

import laivanupotus.grafiikka.Grafiikka.Paneeli;

/**
 * Ruutu on yksittäinen ruutu joka sisältää sen tilan, eli onko se amuttu, onko
 * siinä laiva, ja onko ruudussa oleva laiva kokonaisuudessaan uponnut.
 */
public class Ruutu {

    private Boolean laiva;
    private Boolean ammuttu;
    private LaivaLaskuri laskuri;
    private Paneeli paneeli;
    
    /**
     * Konstruktori joka luo uuden ruudun aloitustilassa eli ei ammuttuna ja
     * tyhjänä.
     */
    public Ruutu() { //tila 0 = tyhjä ei ammuttu, tila 1 = tyhja ammuttu, tila 3 laiva ei ammuttu, tila 4 laiva ammuttu
        laiva = false;
        ammuttu = false;
    }
    
    /**
     * Asettaa ruutuun laivan.
     */
    public void asetaLaiva() { //muuttaa ruudun tilaa
        this.laiva = true;
    }
    
    /**
     * Palauttaa onko ruudussa laiva.
     *
     * @return false jos ei, true jos on.
     */
    public boolean onkoRuudussaLaiva() {
        return this.laiva;
    }
    /**
     * muuttaa ruudun tilan ammutuksi.
     */
    public void ampuminen() {
        this.ammuttu = true;
    }
    /**
     * Katsoo onko ruuutua ammuttu.
     *
     * @return on jos true, false jos ei.
     */
    public boolean onkoAmmuttu() {
        return this.ammuttu;
    }
    /**
     * laittaa ruudulle siihen laivaan kuuluvaan laskurin.
     * @param laskuri asetettava laskuri olio
     */
    public void asetaLaskuri(LaivaLaskuri laskuri) {
        this.laskuri = laskuri;
    }
    /**
     * Palauttaa ruutuun liittyvän laivan laskurin.
     *
     * @return laskuri olio.
     */
    public LaivaLaskuri palautaLaskuri() {
        return this.laskuri;
    }
    /**
     * Asettaa ruudulle siihen kuuluvan grafiikan paneelin.
     * @param paneeli asetettava paneeli olio.
     */
    public void asetaPaneeli(Paneeli paneeli) {
        this.paneeli = paneeli;
    }
    
    public Paneeli palautaPaneeli(){
        return this.paneeli;
    }
}
