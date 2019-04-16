/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.sys.sysgesbricolocal.domaine;

/**
 *
 * @author Rose
 */
public class GrilleSalariale {
  private String  fonction;
  private Float salaireminimal;
  private Float Salairemaximal;

    public GrilleSalariale() {
    }

    public GrilleSalariale(String fonction) {
        this.fonction = fonction;
    }

    public GrilleSalariale(String fonction, Float salaireminimal, Float Salairemaximal) {
        this.fonction = fonction;
        this.salaireminimal = salaireminimal;
        this.Salairemaximal = Salairemaximal;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public void setSalaireminimal(Float salaireminimal) {
        this.salaireminimal = salaireminimal;
    }

    public void setSalairemaximal(Float Salairemaximal) {
        this.Salairemaximal = Salairemaximal;
    }

    public String getFonction() {
        return fonction;
    }

    public Float getSalaireminimal() {
        return salaireminimal;
    }

    public Float getSalairemaximal() {
        return Salairemaximal;
    }
  
}
