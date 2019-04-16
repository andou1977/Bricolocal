/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.sys.sysgesbricolocal.domaine;

/**
 *
 * @author Rose
 */
public class SalaireEmploye {
 private String numeroemploye; 
   private Float salaire;

    public SalaireEmploye() {
    }

    public SalaireEmploye(String numeroemploye) {
        this.numeroemploye = numeroemploye;
    }

    public SalaireEmploye(String numeroemploye, Float salaire) {
        this.numeroemploye = numeroemploye;
        this.salaire = salaire;
    }

    public void setNumeroemploye(String numeroemploye) {
        this.numeroemploye = numeroemploye;
    }

    public void setSalaire(Float salaire) {
        this.salaire = salaire;
    }

    public String getNumeroemploye() {
        return numeroemploye;
    }

    public Float getSalaire() {
        return salaire;
    }
   
   
}
