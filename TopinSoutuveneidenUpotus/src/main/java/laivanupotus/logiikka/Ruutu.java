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
public class Ruutu {

    Boolean laiva;
    Boolean ammuttu;
    LaivaLaskuri laskuri;

    public Ruutu() { //tila 0 = tyhjä ei ammuttu, tila 1 = tyhja ammuttu, tila 3 laiva ei ammuttu, tila 4 laiva ammuttu
        laiva = false;
        ammuttu = false;
    }

    @Override
    public String toString() { // Näyttää yksittäisen ruudun ulkoasun
        if (laiva && ammuttu && laskuri.arvo() <= 0) { //jos laskuri arvo 0 niin koko laiva on uponnut
            return "@";
        } else if (laiva && ammuttu) {
            return "o";
        } else if (laiva) {
            return "+";
        } else if (ammuttu) {
            return "#";
        } else {
            return "x";
        }
    }

    public void asetaLaiva() { //muuttaa ruudun tilaa
        this.laiva = true;
    }

    public boolean onkoRuudussaLaiva() {
        return this.laiva;
    }

//    public String toStringTietokone() { // Näyttää yksittäisen ruudun ulkoasun
//        if (laiva && ammuttu && laskuri.arvo() <= 0) { //MUUTA TAKAISIN!!! laiva == false && ammuttu true
//            return "@";
//        } else if (laiva && ammuttu) {
//            return "o";
//        } else if (laiva) {
//            return "+";
//        } else {
//            return "x";
//        }
//    }

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
}
