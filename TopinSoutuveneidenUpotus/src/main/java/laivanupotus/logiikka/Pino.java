/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laivanupotus.logiikka;

import java.util.Stack;

/**
 *
 * @author laatopi
 */
class Pino {

    private boolean metsastys;
    private Stack<String> pino;

    public Pino() {
        this.metsastys = true;
        this.pino = new Stack();
    }

    public void lisaaPinoon(String koordinaatti) {
        this.pino.add(koordinaatti);
    }

    public void metsastysPaalle() {
        this.metsastys = true;
    }

    public void metsastysPois() {
        this.metsastys = false;
    }

    public boolean palautaMetsastys() {
        return this.metsastys;
    }

    public String poppaus() {
        return this.pino.pop();
    }
    
    public boolean onkoPinoTyhja(){
        return this.pino.empty();
    }
    
    public void tyhjennaPino(){
        this.pino.clear();
    }

}
