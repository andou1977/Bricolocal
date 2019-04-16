/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.sys.sysgesbricolocal.domaine;

/**
 *
 * @author Rose
 */
public class Prelevement {

    private int numeroprelevement;
    private Float tca;
    private Float ona;
    private Float sante;
    private Float vie;
    private Float mort;

    public Prelevement() {
    }

    public Prelevement(int numeroprelevement, Float tca, Float ona, Float sante, Float vie, Float mort) {
        this.numeroprelevement = numeroprelevement;
        this.tca = tca;
        this.ona = ona;
        this.sante = sante;
        this.vie = vie;
        this.mort = mort;
    }

    public void setNumeroprelevement(int numeroprelevement) {
        this.numeroprelevement = numeroprelevement;
    }

    public void setTca(Float tca) {
        this.tca = tca;
    }

    public void setOna(Float ona) {
        this.ona = ona;
    }

    public void setSante(Float sante) {
        this.sante = sante;
    }

    public void setVie(Float vie) {
        this.vie = vie;
    }

    public void setMort(Float mort) {
        this.mort = mort;
    }

    public int getNumeroprelevement() {
        return numeroprelevement;
    }

    public Float getTca() {
        return tca;
    }

    public Float getOna() {
        return ona;
    }

    public Float getSante() {
        return sante;
    }

    public Float getVie() {
        return vie;
    }

    public Float getMort() {
        return mort;
    }
}
