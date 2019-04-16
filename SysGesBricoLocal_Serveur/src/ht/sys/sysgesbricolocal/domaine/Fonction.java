/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.sys.sysgesbricolocal.domaine;

/**
 *
 * @author Rose
 */
public class Fonction {

    private String fonction;
    private int nombreemploye;
    private int numerofonction;

    public Fonction() {
    }

    public Fonction(String fonction) {
        this.fonction = fonction;
    }

    public Fonction(int nombreemploye) {
        this.nombreemploye = nombreemploye;
    }

    public Fonction(String fonction, int nombreemploye) {
        this.fonction = fonction;
        this.nombreemploye = nombreemploye;
    }

    public Fonction(int nombreemploye, int numerofonction) {
        this.nombreemploye = nombreemploye;
        this.numerofonction = numerofonction;
    }

    public Fonction(String fonction, int nombreemploye, int numerofonction) {
        this.fonction = fonction;
        this.nombreemploye = nombreemploye;
        this.numerofonction = numerofonction;
    }

    public void setNumerofonction(int numerofonction) {
        this.numerofonction = numerofonction;
    }

    public void setNombreemploye(int nombreemploye) {
        this.nombreemploye = nombreemploye;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public int getNumerofonction() {
        return numerofonction;
    }

    public String getFonction() {
        return fonction;
    }

    public int getNombreemploye() {
        return nombreemploye;
    }
}
