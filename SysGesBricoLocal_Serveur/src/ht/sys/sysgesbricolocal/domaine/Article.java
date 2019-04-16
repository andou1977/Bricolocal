/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.sys.sysgesbricolocal.domaine;

/**
 *
 * @author Rose
 */
public class Article {

    private String numerofournisseur;
    private String numeroarticle;
    private String libelle;
    private String categorie;
    private Float prixarticle;

    public Article() {
    }

    public Article(String numerofournisseur) {
        this.numerofournisseur = numerofournisseur;
    }

    public Article(String numerofournisseur, String numeroarticle, String libelle, String categorie, Float prixarticle) {
        this.numerofournisseur = numerofournisseur;
        this.numeroarticle = numeroarticle;
        this.libelle = libelle;
        this.categorie = categorie;
        this.prixarticle = prixarticle;
    }

    public void setNumerofournisseur(String numerofournisseur) {
        this.numerofournisseur = numerofournisseur;
    }

    public void setNumeroarticle(String numeroarticle) {
        this.numeroarticle = numeroarticle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setPrixarticle(Float prixarticle) {
        this.prixarticle = prixarticle;
    }

    public String getNumerofournisseur() {
        return numerofournisseur;
    }

    public String getNumeroarticle() {
        return numeroarticle;
    }

    public String getLibelle() {
        return libelle;
    }

    public String getCategorie() {
        return categorie;
    }

    public Float getPrixarticle() {
        return prixarticle;
    }
}
