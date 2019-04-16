/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.sys.sysgesbricolocal.domaine;

/**
 *
 * @author Rose
 */
public class Fournisseur {

    private String numerofournisseur;
    private String nom;
    private String adresse;
    private String dateajout;

    public Fournisseur() {
    }

    public Fournisseur(String numerofournisseur) {
        this.numerofournisseur = numerofournisseur;
    }

    public Fournisseur(String numerofournisseur, String nom, String adresse, String dateajout) {
        this.numerofournisseur = numerofournisseur;
        this.nom = nom;
        this.adresse = adresse;
        this.dateajout = dateajout;
    }

    public void setNumerofournisseur(String numerofournisseur) {
        this.numerofournisseur = numerofournisseur;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setDateajout(String dateajout) {
        this.dateajout = dateajout;
    }

    public String getNumerofournisseur() {
        return numerofournisseur;
    }

    public String getNom() {
        return nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getDateajout() {
        return dateajout;
    }
}
