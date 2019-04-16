/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.sys.sysgesbricolocal.domaine;

/**
 *
 * @author Rose
 */
public class Employe {

    private String numeroemploye;
    private String nom;
    private String prenom;
    private String sexe;
    private String nif;
    private String datenaissance;
    private String adresse;
    private String dateembauche;
    private String numerodepartement;
    private String fonction;

    public Employe() {
    }

    public Employe(String numeroemploye) {
        this.numeroemploye = numeroemploye;
    }

    public Employe(String numeroemploye, String nom, String prenom, String sexe, String nif, String datenaissance, String adresse, String dateembauche, String numerodepartement, String fonction) {
        this.numeroemploye = numeroemploye;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.nif = nif;
        this.datenaissance = datenaissance;
        this.adresse = adresse;
        this.dateembauche = dateembauche;
        this.numerodepartement = numerodepartement;
        this.fonction = fonction;
    }

    public void setNumeroemploye(String numeroemploye) {
        this.numeroemploye = numeroemploye;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public void setDatenaissance(String datenaissance) {
        this.datenaissance = datenaissance;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setDateembauche(String dateembauche) {
        this.dateembauche = dateembauche;
    }

    public void setNumerodepartement(String numerodepartement) {
        this.numerodepartement = numerodepartement;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public String getNumeroemploye() {
        return numeroemploye;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public String getNif() {
        return nif;
    }

    public String getDatenaissance() {
        return datenaissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getDateembauche() {
        return dateembauche;
    }

    public String getNumerodepartement() {
        return numerodepartement;
    }

    public String getFonction() {
        return fonction;
    }
}
