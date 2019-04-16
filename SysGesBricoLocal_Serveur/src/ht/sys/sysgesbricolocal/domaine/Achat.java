/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ht.sys.sysgesbricolocal.domaine;

/**
 *
 * @author Rose
 */
public class Achat {
  private String  numeroemploye;
   private String numeroachat;
   private String numerofournisseur;
   private String description;
   private int quantite;
   private Float prix ;
  private Float  frais;
   private String dateachat ;
  private String  dateenregistrement;

    public Achat() {
    }

    public Achat(String numeroemploye) {
        this.numeroemploye = numeroemploye;
    }

    public Achat(String numeroachat, String numerofournisseur, String description, Float prix, int quantite, Float frais, String dateachat, String dateenregistrement) {
        this.numeroachat = numeroachat;
        this.numerofournisseur = numerofournisseur;
        this.description = description;
        this.quantite = quantite;
        this.prix = prix;
        this.frais = frais;
        this.dateachat = dateachat;
        this.dateenregistrement = dateenregistrement;
    }
    

    public Achat(String numeroemploye, String numeroachat, String numerofournisseur, String description, int quantite, Float prix, Float frais, String dateachat, String dateenregistrement) {
        this.numeroemploye = numeroemploye;
        this.numeroachat = numeroachat;
        this.numerofournisseur = numerofournisseur;
        this.description = description;
        this.quantite = quantite;
        this.prix = prix;
        this.frais = frais;
        this.dateachat = dateachat;
        this.dateenregistrement = dateenregistrement;
    }

    public void setNumeroemploye(String numeroemploye) {
        this.numeroemploye = numeroemploye;
    }

    public void setNumeroachat(String numeroachat) {
        this.numeroachat = numeroachat;
    }

    public void setNumerofournisseur(String numerofournisseur) {
        this.numerofournisseur = numerofournisseur;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public void setFrais(Float frais) {
        this.frais = frais;
    }

    public void setDateachat(String dateachat) {
        this.dateachat = dateachat;
    }

    public void setDateenregistrement(String dateenregistrement) {
        this.dateenregistrement = dateenregistrement;
    }

    public String getNumeroemploye() {
        return numeroemploye;
    }

    public String getNumeroachat() {
        return numeroachat;
    }

    public String getNumerofournisseur() {
        return numerofournisseur;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantite() {
        return quantite;
    }

    public Float getPrix() {
        return prix;
    }

    public Float getFrais() {
        return frais;
    }

    public String getDateachat() {
        return dateachat;
    }

    public String getDateenregistrement() {
        return dateenregistrement;
    }
  
  
    
}
