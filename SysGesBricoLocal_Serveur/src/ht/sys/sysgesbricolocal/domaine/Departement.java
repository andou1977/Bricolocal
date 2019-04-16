/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.sys.sysgesbricolocal.domaine;

/**
 *
 * @author Rose
 */
public class Departement {
 private String  numerodepartement;
private String Departement;

    public Departement() {
    }

    public Departement(String numerodepartement) {
        this.numerodepartement = numerodepartement;
    }

    public Departement(String numerodepartement, String Departement) {
        this.numerodepartement = numerodepartement;
        this.Departement = Departement;
    }

    public void setNumerodepartement(String numerodepartement) {
        this.numerodepartement = numerodepartement;
    }

    public void setDepartement(String Departement) {
        this.Departement = Departement;
    }

    public String getNumerodepartement() {
        return numerodepartement;
    }

    public String getDepartement() {
        return Departement;
    }


    
}
