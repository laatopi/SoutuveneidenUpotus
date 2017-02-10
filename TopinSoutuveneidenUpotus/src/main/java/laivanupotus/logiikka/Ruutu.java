/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laivanupotus.logiikka;

import laivanupotus.grafiikka.Grafiikka.CellPaneOma;

/**
 *
 * @author laatopi
 *
 * Ruutu on yksittäinen ruutu joka sisältää sen tilan, eli onko se amuttu, onko
 * siinä laiva, ja onko ruudussa oleva laiva kokonaisuudessaan uponnut.
 *
 *
 */
public class Ruutu {

    Boolean laiva;
    Boolean ammuttu;
    LaivaLaskuri laskuri;
    CellPaneOma paneeli;

    public Ruutu() { //tila 0 = tyhjä ei ammuttu, tila 1 = tyhja ammuttu, tila 3 laiva ei ammuttu, tila 4 laiva ammuttu
        laiva = false;
        ammuttu = false;
    }

    public void asetaLaiva() { //muuttaa ruudun tilaa
        this.laiva = true;
    }

    public boolean onkoRuudussaLaiva() {
        return this.laiva;
    }

    public void ampuminen() {
        this.ammuttu = true;
    }

    public boolean onkoAmmuttu() {
        return this.ammuttu;
    }

    public void asetaLaskuri(LaivaLaskuri laskuri) {
        this.laskuri = laskuri;
    }

    public LaivaLaskuri palautaLaskuri() {
        return this.laskuri;
    }

    public void asetaPaneeli(CellPaneOma paneeli) {
        this.paneeli = paneeli;
    }
}
