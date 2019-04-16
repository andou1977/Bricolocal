/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.sys.sysgesbricolocal.domaine;

/**
 *
 * @author Rose
 */
public class Categorie {
    private String  numerocategorie ;
  private String  description  ;
  private String  date_ajout  ;

    public Categorie() {
    }

    public Categorie(String numerocategorie) {
        this.numerocategorie = numerocategorie;
    }

    public Categorie(String numerocategorie, String description, String date_ajout) {
        this.numerocategorie = numerocategorie;
        this.description = description;
        this.date_ajout = date_ajout;
    }

    public void setNumerocategorie(String numerocategorie) {
        this.numerocategorie = numerocategorie;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate_ajout(String date_ajout) {
        this.date_ajout = date_ajout;
    }

    public String getNumerocategorie() {
        return numerocategorie;
    }

    public String getDescription() {
        return description;
    }

    public String getDate_ajout() {
        return date_ajout;
    }
 
    
}
