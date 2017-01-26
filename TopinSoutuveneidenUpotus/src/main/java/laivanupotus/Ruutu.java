/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laivanupotus;

/**
 *
 * @author laatopi
 */
public class Ruutu {

    Boolean laiva;
    Boolean ammuttu;

    public Ruutu() { //tila 0 = tyhjä ei ammuttu, tila 1 = tyhja ammuttu, tila 3 laiva ei ammuttu, tila 4 laiva ammuttu
        laiva = false;
        ammuttu = false;
    }

    @Override
    public String toString() { // Näyttää yksittäisen ruudun ulkoasun
        if (laiva) { //MUUTA TAKAISIN!!! laiva == false && ammuttu true
            return "+";
        } else if (laiva && ammuttu) {
            return "o";
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

}
